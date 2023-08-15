package com.godknows.oauth2jwt.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.godknows.oauth2jwt.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
