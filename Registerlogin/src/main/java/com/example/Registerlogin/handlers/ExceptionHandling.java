package com.example.Registerlogin.handlers;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Registerlogin.exception.Usernotfoundexception;


@RestControllerAdvice
public class ExceptionHandling {
	

	@ResponseStatus(HttpStatus.BAD_REQUEST)
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
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Usernotfoundexception.class)
	public String handleexception(Usernotfoundexception ex)
	{
		Map<String, String> errm=new HashMap<>();
		errm.put("errorMessage", ex.getMessage());
		return ex.getMessage();
	}
	
  
}