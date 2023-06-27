package com.piseth.java.school.phoneshop_eng.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<?> handleError(ApiException apiException){
		ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
		errorResponseDTO.setMessage(apiException.getMessage());
		return ResponseEntity
				.status(apiException.getHttpStatus())
				.body(errorResponseDTO);
	}
	

}
