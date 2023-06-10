package com.promineotech.pet.store.controller.error;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {
	
	//Returns a NoSuchElementException message. The NoSuchElementException parameter is converted to a string value.
	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public Map<String, String> handleNoSuchElementExeption(NoSuchElementException ex) {
		log.info("NoSuchElementException occurred: {}", ex.toString());
		Map<String, String> message = new HashMap<>();
		message.put("message", ex.toString());
		return message;
	}
}
