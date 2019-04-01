package com.retailstore.checkout.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author KDavara
 * Entity class for the product category
 */

@Entity
@Table(name = "product_category")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private double salesTaxPercentage;
	
	public ProductCategory() {
		
	}
	
	public ProductCategory(String name,double salesTaxPercentage) {
		this.name = name;
		this.salesTaxPercentage = salesTaxPercentage;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the salesTaxPercentage
	 */
	public double getSalesTaxPercentage() {
		return salesTaxPercentage;
	}

	/**
	 * @param salesTaxPercentage the salesTaxPercentage to set
	 */
	public void setSalesTaxPercentage(double salesTaxPercentage) {
		this.salesTaxPercentage = salesTaxPercentage;
	}

	
}
