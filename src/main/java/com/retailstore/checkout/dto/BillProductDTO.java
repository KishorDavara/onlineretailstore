/**
 * 
 */
package com.retailstore.checkout.dto;

/**
 * @author KDavara
 *
 */
public class BillProductDTO {
	
 private Long productId;
 
 private int quantity;
 
 public BillProductDTO() {
	 
 }
 
 public BillProductDTO(Long productId, int quantity) {
	 this.productId = productId;
	 this.quantity = quantity;
 }

/**
 * @return the productId
 */
public Long getProductId() {
	return productId;
}

/**
 * @param productId the productId to set
 */
public void setProductId(Long productId) {
	this.productId = productId;
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
