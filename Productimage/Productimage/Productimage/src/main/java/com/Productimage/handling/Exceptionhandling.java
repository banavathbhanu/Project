package com.Productimage.handling;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptionhandling {
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Collection<String>handleInvalidArgument(MethodArgumentNotValidException ex)
	{
		Map<String, String> errm=new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
		errm.put(error.getField(), error.getDefaultMessage());
		});
		System.out.println(errm.values());
		return errm.values();
	}

}
