/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.Collection;

import com.retailstore.checkout.dto.BillDTO;
import com.retailstore.checkout.entity.Bill;

/**
 * @author KDavara
 *
 */
public interface BillService {
	void createBill(BillDTO bill);

	void updateBill(Long id, BillDTO bill);

	void deleteBill(Long id);

	Collection<BillDTO> getBills();

	BillDTO getBillById(Long id);
 
	Collection<Bill> getBillsWithCompleteDetails();
	
}
