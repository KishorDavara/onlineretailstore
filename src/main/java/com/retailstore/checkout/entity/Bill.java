package com.retailstore.checkout.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;


/**
 * @author KDavara
 * entity class for shopping bill
 */

@Entity
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "bill_purchases", joinColumns = @JoinColumn(name = "bill_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "purchase_id", referencedColumnName = "id"))
	private Set<Purchase> purchases;
	
	@NotNull
	private int totalItems;
	
	@NotNull
	private double subTotal;
	
	@NotNull
	private double totalSalesTax;
	
	private double totalCost;
	
	public Bill() {
		
	}
	
	public Bill(Set<Purchase> purchases,int totalItems,double subTotal,double totalSalesTax) {
		this.purchases = purchases;
		this.totalItems = totalItems;
		this.subTotal = subTotal;
		this.totalSalesTax = totalSalesTax;
		this.totalCost = this.subTotal + this.totalSalesTax;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the purchases
	 */
	public Set<Purchase> getPurchases() {
		return purchases;
	}

	/**
	 * @param purchases the purchases to set
	 */
	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	/**
	 * @return the totalItems
	 */
	public int getTotalItems() {
		return totalItems;
	}

	/**
	 * @param totalItems the totalItems to set
	 */
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
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
	 * @return the totalSalesTax
	 */
	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	/**
	 * @param totalSalesTax the totalSalesTax to set
	 */
	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
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
	
	
}
