package com.retailstore.checkout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author KDavara
 *
 */
@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	
	@ManyToOne
    @JoinColumn(name = "product_id")
	private Product product;
	
	private int quantity;
	
	private double totalCost;
	
	private double totalSalesTax;

	public Purchase() {

	}

	public Purchase(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		this.totalCost = this.product.getPrice() * this.quantity;
		this.totalSalesTax = this.product.getSalesTax() * this.quantity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public double getTotalSalesTax() {
		return totalSalesTax;
	}

	public void setTotalSalesTax(double totalSalesTax) {
		this.totalSalesTax = totalSalesTax;
	}
}
