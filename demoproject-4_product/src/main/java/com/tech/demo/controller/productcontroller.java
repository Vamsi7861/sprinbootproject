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

import com.tech.demo.dto.Product;
import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;
import com.tech.demo.service.productservice;

@RestController
public class productcontroller {
	@Autowired
	productservice service;
	@PostMapping("/product/{user_id}")
	public ResponseEntity<Responcestructure<Product>> saveuser(@RequestBody Product u,@PathVariable int user_id) {
		return service.saveProduct(u,user_id);
	}
	@PutMapping("/product")
	public ResponseEntity<Responcestructure<Product>> updateuser(@RequestBody Product u) {
		return service.updateProduct(u);
	}
	@GetMapping("/product/{id}")
	public ResponseEntity<Responcestructure<Product>> findbyid(@PathVariable int id){
		return service.findbyid(id);
	}
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Responcestructure<String>> deletebyid(@PathVariable int id) {
		return service.deletebyid(id);
	}
	@GetMapping("/product")
	public ResponseEntity<Responcestructure<List<Product>>> findall(){
		return service.findall();
	}
	@GetMapping("/user1/{user_id}")
	public ResponseEntity<Responcestructure<Product>> fetchbyuser_id(@PathVariable int user_id) {
		return service.fetchbyuser_id(user_id);
	}
}
