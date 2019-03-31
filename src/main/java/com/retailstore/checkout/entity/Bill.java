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
	
	private int totalItems;
	
	private double subTotal;
	
	private double totalSalesTax;
	
	private double totalCost;
	
	public Bill() {
		
	}
	
	public Bill(Set<Purchase> lineItems) {
		this.purchases = lineItems;
	}
	
	public Bill(Set<Purchase> lineItems,int totalItems,double subTotal,double totalSalesTax, double totalCost) {
		this.purchases = lineItems;
		this.totalItems = totalItems;
		this.subTotal = subTotal;
		this.totalSalesTax = totalSalesTax;
		this.totalCost = totalCost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Set<Purchase> getLineItems() {
		return purchases;
	}

	public void setLineItems(Set<Purchase> lineItems) {
		this.purchases = lineItems;
	}

	public int getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}
