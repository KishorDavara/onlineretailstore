/**
 * 
 */
package com.retailstore.checkout.dto;


/**
 * @author KDavara
 * DTO class for product use to only expose relevant data and not an entity data to the end user
 */
public class ProductDTO {
	
	private String name;
	
	private double price;
	
	private long productCategoryId;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(String name,double price,long productCategoryId) {
		this.name = name;
		this.price = price;
		this.productCategoryId = productCategoryId;
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the productCategoryId
	 */
	public long getProductCategoryId() {
		return productCategoryId;
	}

	/**
	 * @param productCategoryId the productCategoryId to set
	 */
	public void setProductCategoryId(long productCategoryId) {
		this.productCategoryId = productCategoryId;
	}
    
}
