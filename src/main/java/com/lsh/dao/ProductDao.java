package com.lsh.dao;


import com.lsh.dataobject.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product,Long> {
    Product findById(Long id);
}
