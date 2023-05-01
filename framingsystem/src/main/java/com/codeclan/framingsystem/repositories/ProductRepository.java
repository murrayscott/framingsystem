package com.codeclan.framingsystem.repositories;

import com.codeclan.framingsystem.models.Part;
import com.codeclan.framingsystem.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product, Long>{
    List<Product> findProductById(Long id);
}
