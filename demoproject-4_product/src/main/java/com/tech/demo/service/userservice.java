package com.tech.demo.service;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.demo.dao.userdao;
import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;
import com.tech.demo.exception.idnotfoundexception;
@Service
public class userservice {
	@Autowired
	userdao dao;
	
	public ResponseEntity<Responcestructure<User>> saveuser(User u) {
		Responcestructure<User> structure=new Responcestructure<>();
		structure.setBody(dao.saveuser(u));
		structure.setMessage("user saved successfully");
		structure.setCode(HttpStatus.CREATED.value());
	structure.setBody(u);
			return new ResponseEntity<Responcestructure<User>>(structure,HttpStatus.CREATED) ;
		
		
	}
	public ResponseEntity<Responcestructure<User>> updateuser(User u) {
		Responcestructure<User> structure=new Responcestructure<>();
		structure.setBody(dao.updateuser(u));
		structure.setMessage("user updated successfully");
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<Responcestructure<User>>(structure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<Responcestructure<User>> findbyid(int id){
		Optional<User> u=dao.findbyid(id);
		Responcestructure<User> structure=new Responcestructure<>();
		if(u.isPresent()) {
			structure.setMessage("user found");
			structure.setBody(u.get());
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Responcestructure<User>>(structure,HttpStatus.FOUND) ;
		}
		else {
			
			throw new idnotfoundexception();
		}
	}
	public ResponseEntity<Responcestructure<String>> deletebyid(int id) {
		Optional<User> u=dao.findbyid(id);
		Responcestructure<String> structure=new Responcestructure<>();
		if(u.isPresent()) {
			dao.deletebyid(u.get());
			structure.setMessage("user found");
			structure.setBody("user deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<Responcestructure<String>>(structure,HttpStatus.FOUND) ;
		}
		else {
			
			throw new idnotfoundexception();
		}
	}
	public ResponseEntity<Responcestructure<List<User>>> findall(){
		Responcestructure<List<User>> structure=new Responcestructure<>();
			structure.setMessage(" found all");
			structure.setBody(dao.findall());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<Responcestructure<List<User>>>(structure,HttpStatus.OK) ;
	}
}
