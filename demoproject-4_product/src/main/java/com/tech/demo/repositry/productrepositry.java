package com.tech.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.demo.dto.Product;

public interface productrepositry  extends JpaRepository<Product, Integer>{

}
