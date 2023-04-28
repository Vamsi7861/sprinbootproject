package com.tech.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//@ControllerAdvice

import com.tech.demo.dto.Responcestructure;
@RestControllerAdvice
public class Useridnotfoundexception extends   ResponseEntityExceptionHandler {
@ExceptionHandler(idnotfoundexception.class)
public ResponseEntity<Responcestructure<String>> getIdnotfoundexception(idnotfoundexception e){
	Responcestructure<String> structure=new Responcestructure<>();
	structure.setBody("user not found");
	structure.setCode(HttpStatus.NOT_FOUND.value());
	structure.setMessage(e.getmessage());
	return new ResponseEntity<Responcestructure<String>>(structure, HttpStatus.NOT_FOUND);
}
}
