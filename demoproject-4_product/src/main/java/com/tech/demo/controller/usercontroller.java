package com.tech.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;
import com.tech.demo.service.userservice;

@RestController
public class usercontroller {
	@Autowired
	userservice service;
	@PostMapping("/user")
	public ResponseEntity<Responcestructure<User>> saveuser(@RequestBody User u) {
		return service.saveuser(u);
	}
	@PutMapping("/user")
	public ResponseEntity<Responcestructure<User>> updateuser(@RequestBody User u) {
		return service.updateuser(u);
	}
	@GetMapping("/user/{id}")
	public ResponseEntity<Responcestructure<User>> findbyid(@PathVariable int id){
		return service.findbyid(id);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<Responcestructure<String>> deletebyid(@PathVariable int id) {
		return service.deletebyid(id);
	}
	@GetMapping("/user")
	public ResponseEntity<Responcestructure<List<User>>> findall(){
		return service.findall();
	}
}
