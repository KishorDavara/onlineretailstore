/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.Collection;

import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Product;

/**
 * @author KDavara
 * 
 */
public interface ProductService {
	void createProduct(ProductDTO product);
	
	void updateProduct(Long id, ProductDTO product);
	
	void deleteProduct(Long id);
	
	Collection<ProductDTO> getProducts();
	
	Collection<Product> getProductsWithCompleteDetail();
	
	ProductDTO getProductById(Long id);
}
