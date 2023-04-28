package com.tech.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tech.demo.dto.User;
import com.tech.demo.repositry.userrepositry;

@Repository
public class userdao {
	@Autowired
userrepositry repo;
public User saveuser(User u) {
	return repo.save(u);
}
public User updateuser(User u) {
	return repo.save(u);
}
public Optional<User> findbyid(int id){
	return repo.findById(id);
}
public void deletebyid(User u) {
	repo.delete(u);
}
public List<User> findall(){
	return repo.findAll();
}
}
