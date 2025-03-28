package com.example.SimpleWebApp.repository;

import com.example.SimpleWebApp.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
