/**
 * 
 */
package com.retailstore.checkout.dto;

/**
 * @author KDavara
 *
 */
public class PurchaseDTO {
    private ProductDTO product;
	
	private int quantity;
		
	public PurchaseDTO() {
		
	}
	
	public PurchaseDTO(ProductDTO product,int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	/**
	 * @return the product
	 */
	public ProductDTO getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDTO product) {
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
}
