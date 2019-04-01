/**
 * 
 */
package com.retailstore.checkout.dto;

import java.util.List;
import java.util.Set;


/**
 * @author KDavara
 * DTO class for bill use to only expose relevant data and not an entity data to the end user
 */
public class BillDTO {
	
	private Set<PurchaseDTO> purchases;
	
	private List<BillProductDTO> billProducts;
	
	private int noOfItems;
	
	private double subTotal;
	
	private double totalTax;
	
	private double totalCost;

	public BillDTO() {
		
	}
	
	public BillDTO(Set<PurchaseDTO> purchases) {
		this.purchases = purchases;
	}
	
	public BillDTO(List<BillProductDTO> billProducts) {
		this.billProducts = billProducts;
	}

	/**
	 * @return the purchases
	 */
	public Set<PurchaseDTO> getPurchases() {
		return purchases;
	}

	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(Set<PurchaseDTO> purchases) {
		this.purchases = purchases;
	}

	/**
	 * @return the noOfItems
	 */
	public int getNoOfItems() {
		return noOfItems;
	}

	/**
	 * @param noOfItems the noOfItems to set
	 */
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	/**
	 * @return the subTotal
	 */
	public double getSubTotal() {
		return subTotal;
	}

	/**
	 * @param subTotal the subTotal to set
	 */
	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	/**
	 * @return the totalTax
	 */
	public double getTotalTax() {
		return totalTax;
	}

	/**
	 * @param totalTax the totalTax to set
	 */
	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	/**
	 * @return the totalCost
	 */
	public double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost the totalCost to set
	 */
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	/**
	 * @return the billProducts
	 */
	public List<BillProductDTO> getBillProducts() {
		return billProducts;
	}

	/**
	 * @param billProducts the billProducts to set
	 */
	public void setBillProducts(List<BillProductDTO> billProducts) {
		this.billProducts = billProducts;
	}
}
