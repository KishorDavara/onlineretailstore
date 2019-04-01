/**
 * 
 */
package com.retailstore.checkout.service;


import java.util.List;

import com.retailstore.checkout.dto.BillDTO;
import com.retailstore.checkout.entity.Bill;

/**
 * @author KDavara
 * 
 */
public interface BillService {
	
	/**
	 * method responsible for creating bill
	 * @param bill data of the bill
	 * @return created Bill
	 */
	Bill createBill(BillDTO bill);

	/**
	 * method responsible for updating bill
	 * @param id of the bill to be updated
	 * @param bill
	 * @return updated bill
	 */
	Bill updateBill(Long id, BillDTO bill);

	/**
	 * method responsible for delete the bill
	 * @param id
	 */
	void deleteBill(Long id);

	/**
	 * 
	 * @return list of bills with only exposing the relevant data to the end user
	 */
	List<BillDTO> getBills();

    /**
     * 
     * @param id of bill to be fetch
     * @return bills with given id only exposing the relevant data to the end user
     */
	BillDTO getBillById(Long id);
	
	/**
	 * 
	 * @param id of bill to be fetch
	 * @return bill with the entity data
	 */
	Bill getBillByIdWithCompleteDetails(Long id);
 
	/**
	 * 
	 * @return list of bills with the entity data
	 */
	List<Bill> getBillsWithCompleteDetails();
}
