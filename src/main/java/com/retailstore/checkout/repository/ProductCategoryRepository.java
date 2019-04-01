/**
 * 
 */
package com.retailstore.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailstore.checkout.entity.ProductCategory;

/**
 * @author KDavara
 * Repository for configure and handling the productCategory
 */

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
