/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.retailstore.checkout.entity.Product;

/**
 * @author KDavara
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#createProduct(com.retailstore.checkout.entity.Product)
	 */
	@Override
	public void createProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#updateProduct(java.lang.String, com.retailstore.checkout.entity.Product)
	 */
	@Override
	public void updateProduct(String id, Product product) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#deleteProduct(java.lang.String)
	 */
	@Override
	public void deleteProduct(String id) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#getProducts()
	 */
	@Override
	public Collection<Product> getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#getProductById(java.lang.String)
	 */
	@Override
	public Collection<Product> getProductById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
