package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.User;

public interface userrepositry extends JpaRepository<User, Integer> {

}
