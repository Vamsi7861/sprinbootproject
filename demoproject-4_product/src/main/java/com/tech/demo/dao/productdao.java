package com.tech.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.Product;
import com.tech.demo.repositry.productrepositry;

@Repository
public class productdao {
	@Autowired
	productrepositry repo;
	public Product saveproduct(Product u) {
		return repo.save(u);
	}
	public Product updateproduct(Product u) {
		return repo.save(u);
	}
	public Optional<Product> findbyid(int id){
		return repo.findById(id);
	}
	public void deletebyid(Product u) {
		repo.delete(u);
	}
	public List<Product> findall(){
		return repo.findAll();
	}
}
