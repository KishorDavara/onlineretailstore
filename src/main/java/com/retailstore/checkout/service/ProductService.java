/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.List;

import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Product;

/**
 * @author KDavara
 * 
 */
public interface ProductService {
	/**
	 * method responsible for creating product
	 * @param product data
	 * @return created product
	 */
	Product createProduct(ProductDTO product);
	
	/**
	 * method responsible for updating product
	 * @param id of the product to be updated
	 * @param product
	 * @return updated product
	 */
	Product updateProduct(Long id, ProductDTO product);
	
	/**
	 * method responsible for deleting product
	 * @param id of the product to be deleted
	 */
	void deleteProduct(Long id);
	
	/**
	 * 
	 * @return list of products with only exposing the relevant data to the end user
	 */
	List<ProductDTO> getProducts();
	
	/**
	 * 
	 * @return list of products with the entity data
	 */
	List<Product> getProductsWithCompleteDetail();
	
	/**
	 * 
	 * @param id of the product to be fetch
	 * @return product with the entity data
	 */
	Product getProductWithCompleteDetail(Long id);
	
	/**
	 * 
	 * @param id of the product to be fetch
	 * @return product with only exposing the relevant data to the end user
	 */
	ProductDTO getProductById(Long id);
	
	/**
	 * 
	 * @return total product count
	 */
	long getTotalProductCount();
}
