/**
 * 
 */
package com.retailstore.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailstore.checkout.entity.Purchase;

/**
 * @author KDavara
 * Repository for handling the purchased products
 */

@Repository
public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

}
