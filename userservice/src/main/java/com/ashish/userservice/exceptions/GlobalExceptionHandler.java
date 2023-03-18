package com.ashish.userservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ashish.userservice.utility.GenericResponse;
import com.ashish.userservice.utility.ResponseHeaderUtility;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<GenericResponse> handlerResourceNotFoundException(ResourceNotFoundException ex1) {
		GenericResponse resp = getResponse("failure", "-1", "Response not found", "Response not found", null);
		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);

	}

	@ExceptionHandler(ServiceUnavailableExection.class)
	public ResponseEntity<GenericResponse> handlerResourceNotFoundException(ServiceUnavailableExection ex1) {
		GenericResponse resp = getResponse("failure", "-1", ex1.getMessage(), "Response not found", null);
		return new ResponseEntity<>(resp, ResponseHeaderUtility.HttpHeadersConfig(), HttpStatus.OK);

	}

	private GenericResponse getResponse(String status, String errorCode, String errorMesg, String erroDesc,
			Object userData) {
		GenericResponse objGenericResponse = new GenericResponse();
		objGenericResponse.setStatus(status);
		objGenericResponse.setErrorCode(errorCode);
		objGenericResponse.setErrorDescription(errorMesg);
		objGenericResponse.setUserDisplayMesg(erroDesc);
		objGenericResponse.setData(userData);
		return objGenericResponse;
	}
}
