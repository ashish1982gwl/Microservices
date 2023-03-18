package com.ashish.rating.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ashish.rating.entities.Rating;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String>
{
    //custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);

}
