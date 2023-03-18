package com.ashish.userservice.services.impl;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ashish.userservice.entities.Hotel;
import com.ashish.userservice.entities.User;
import com.ashish.userservice.exceptions.ResourceNotFoundException;
import com.ashish.userservice.exceptions.ServiceUnavailableExection;
import com.ashish.userservice.external.services.HotelService;
import com.ashish.userservice.repositories.UserRepository;
import com.ashish.userservice.services.UserService;
import com.ashish.userservice.utility.GenericResponse;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;
    
   
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        //generate  unique userid
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        //implement RATING SERVICE CALL: USING REST TEMPLATE
        return userRepository.findAll();
    }

    //get single user
    @CircuitBreaker(name = "CircuitBreakerService",fallbackMethod = "hotelServiceFallBackMethod")

    @Override
    public User getUser(String userId) {
    	//get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad
        Hotel hotel = hotelService.getHotel("14bef2bf-fc1a-4d77-9ed2-789ea1c1aaa1");
      //  Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
        logger.info("{------------obj----------------} "+ hotel);
//        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
//        List<Rating> ratingList = ratings.stream().map(rating -> {
//            //api call to hotel service to get the hotel
//            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791
//            //ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            logger.info("response status code: {} ",forEntity.getStatusCode());
//            //set the hotel to rating
//            rating.setHotel(hotel);
//            //return the rating
//            return rating;
//        }).collect(Collectors.toList());
//
//        user.setRatings(ratingList);

        return user;
    }
    public User hotelServiceFallBackMethod(String userId,Exception ex) {
		String msg = "Hotel Service is taking longer than Expected." + " Please try again later";
		throw new ServiceUnavailableExection(msg);
	}
}
