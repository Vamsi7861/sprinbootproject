package com.tech.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.tech.demo.dao.productdao;
import com.tech.demo.dao.userdao;
import com.tech.demo.dto.Product;
import com.tech.demo.dto.Responcestructure;
import com.tech.demo.dto.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Service
public class productservice {
	@PersistenceContext
	EntityManager manager;
	@Autowired
	productdao dao;
	@Autowired
	userdao dao1;
	public ResponseEntity<Responcestructure<Product>> saveProduct(Product p,int user_id) {
		Responcestructure<Product> structure=new Responcestructure<>();
		Optional<User> user=dao1.findbyid(user_id);
		if(user.isPresent()) {
			User us=user.get();
			us.getProd().add(p);
			p.setUser(us);
			structure.setBody(dao.saveproduct(p));
			structure.setMessage("Product saved successfully");
			structure.setCode(HttpStatus.CREATED.value());
			return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.CREATED) ;	
			}
		else {
			structure.setBody(null);
			structure.setCode(HttpStatus.NOT_FOUND.value());
			structure.setMessage("user ID NOT FOUND");
			return  new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.NOT_FOUND) ;
		}
		
	}
	public ResponseEntity<Responcestructure<Product>> updateProduct(Product u) {
		Responcestructure<Product> structure=new Responcestructure<>();
		structure.setBody(dao.updateproduct(u));
		structure.setMessage("Product updated successfully");
		structure.setCode(HttpStatus.CREATED.value());
		return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.CREATED) ;
	}
	public ResponseEntity<Responcestructure<Product>> findbyid(int id){
		Optional<Product> u=dao.findbyid(id);
		Responcestructure<Product> structure=new Responcestructure<>();
		if(u.isPresent()) {
			structure.setMessage("Product found");
			structure.setBody(u.get());
			structure.setCode(HttpStatus.FOUND.value());
			return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.FOUND) ;
		}
		else {
			
			structure.setBody(null);
			structure.setMessage("invalid input");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.NOT_FOUND) ;
		}
	}
	public ResponseEntity<Responcestructure<String>> deletebyid(int id) {
		Optional<Product> u=dao.findbyid(id);
		Responcestructure<String> structure=new Responcestructure<>();
		if(u.isPresent()) {
			dao.deletebyid(u.get());
			structure.setMessage("Product found");
			structure.setBody("Product deleted");
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<Responcestructure<String>>(structure,HttpStatus.OK) ;
		}
		else {
			
			structure.setBody("Product not found");
			structure.setMessage("invalid input");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Responcestructure<String>>(structure,HttpStatus.NOT_FOUND) ;
		}
	}
	public ResponseEntity<Responcestructure<List<Product>>> findall(){
		Responcestructure<List<Product>> structure=new Responcestructure<>();
			structure.setMessage(" found all");
			structure.setBody(dao.findall());
			structure.setCode(HttpStatus.OK.value());
			return new ResponseEntity<Responcestructure<List<Product>>>(structure,HttpStatus.OK) ;
	}
	public ResponseEntity<Responcestructure<Product>> fetchbyuser_id(int id) {
		Responcestructure<Product> structure=new Responcestructure<>();
		Query q=manager.createQuery("select p from Product p where p.user.id=?1");
		q.setParameter(1, id);
		List<Product> l=q.getResultList();
		if(l.size()>0) {
			int p_id=l.get(0).getId();
			Optional<Product> u=dao.findbyid(p_id);
			
			if(u.isPresent()) {
				structure.setMessage("Product found");
				structure.setBody(u.get());
				structure.setCode(HttpStatus.FOUND.value());
			}
			return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.FOUND) ;
		}
		
		else {
			
			structure.setBody(null);
			structure.setMessage("invalid input");
			structure.setCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<Responcestructure<Product>>(structure,HttpStatus.NOT_FOUND) ;
		}
	}
}
