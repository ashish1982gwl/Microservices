package com.ashish.gatway;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.gateway.exceptions.ServiceUnavailableExection;
import com.ashish.gateway.utility.GenericResponse;

@RestController
public class FallBackMethodController {

	@GetMapping("/userServiceFallBack")
	public ResponseEntity<GenericResponse> userServiceFallBackMethod() {
		String msg = "Department Service is taking longer than Expected." + " Please try again later";
		throw new ServiceUnavailableExection(msg);
	}

	@GetMapping("/hotelServiceFallBack")
	public ResponseEntity<GenericResponse> hotelServiceFallBackMethod() {
		String msg = "Department Service is taking longer than Expected." + " Please try again later";
		throw new ServiceUnavailableExection(msg);
	}

	@GetMapping("/ratingServiceFallBack")
	public ResponseEntity<GenericResponse> ratingServiceFallBackMethod() {
		String msg = "Department Service is taking longer than Expected." + " Please try again later";
		throw new ServiceUnavailableExection(msg);

	}
}
