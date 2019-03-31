/**
 * 
 */
package com.retailstore.checkout.service;

import com.retailstore.checkout.entity.Bill;

/**
 * @author KDavara
 *
 */
public interface BillService {
	void createBill(Bill bill);

	void updateBill(String id, Bill bill);

	void deleteBill(String id);

	void getBills();

	void getBillById(String id);
}
