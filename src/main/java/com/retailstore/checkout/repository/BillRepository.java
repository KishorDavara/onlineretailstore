package com.retailstore.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailstore.checkout.entity.Bill;

/**
 * @author KDavara
 * Repository interface for billing
 */

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

}
