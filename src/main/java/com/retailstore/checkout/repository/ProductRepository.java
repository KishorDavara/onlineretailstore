package com.retailstore.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailstore.checkout.entity.Product;

/**
 * @author KDavara
 * Repository for configure and handling the products
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
