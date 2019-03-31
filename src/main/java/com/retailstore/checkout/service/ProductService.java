/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.Collection;

import com.retailstore.checkout.entity.Product;

/**
 * @author KDavara
 * 
 */
public interface ProductService {
	void createProduct(Product product);
	
	void updateProduct(String id, Product product);
	
	void deleteProduct(String id);
	
	Collection<Product> getProducts();
	
	Collection<Product> getProductById(String id);
}
