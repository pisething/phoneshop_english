package com.piseth.java.school.phoneshop_eng.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiException extends RuntimeException{
	private HttpStatus httpStatus;
	private String message;
}
