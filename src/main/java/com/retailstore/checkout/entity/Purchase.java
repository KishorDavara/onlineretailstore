package com.retailstore.checkout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author KDavara
 * entity class for purchases
 */
@Entity
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
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

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
}
