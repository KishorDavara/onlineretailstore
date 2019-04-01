/**
 * 
 */
package com.retailstore.checkout.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Product;
import com.retailstore.checkout.entity.ProductCategory;
import com.retailstore.checkout.repository.ProductCategoryRepository;
import com.retailstore.checkout.repository.ProductRepository;

/**
 * @author KDavara
 *
 */

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#createProduct(com.retailstore.checkout.entity.Product)
	 */
	@Override
	public void createProduct(ProductDTO productDTO) {
	  Long productCategoryID = productDTO.getProductCategoryId();	
	  
	  ProductCategory productCategory = productCategoryRepository.findById(productCategoryID).get();
	  
	  Product product = new Product(productDTO.getName(),productDTO.getPrice(),productCategory); 	
      
	  productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#updateProduct(java.lang.String, com.retailstore.checkout.entity.Product)
	 */
	@Override
	public void updateProduct(Long id, ProductDTO productDTO) {
		Long productCategoryID = productDTO.getProductCategoryId();	
		
		ProductCategory productCategory = productCategoryRepository.findById(productCategoryID).get();
		
		Product product = productRepository.findById(id).get();
		product.setName(productDTO.getName());
		product.setPrice(productDTO.getPrice());
		product.setProductCategory(productCategory);

		productRepository.save(product);
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#deleteProduct(java.lang.String)
	 */
	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#getProducts()
	 */
	@Override
	public Collection<ProductDTO> getProducts() {
		List<Product> products = productRepository.findAll();
		List<ProductDTO> productsDTO = new ArrayList<>();
		products.forEach(product -> {
			productsDTO.add(new ProductDTO(product.getName(), product.getPrice(), product.getProductCategory().getId()));
		});
		return productsDTO;
	}
	
	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#getProducts()
	 */
	@Override
	public Collection<Product> getProductsWithCompleteDetail() {
		return productRepository.findAll();
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.ProductService#getProductById(java.lang.String)
	 */
	@Override
	public ProductDTO getProductById(Long id) {
		Product product = productRepository.findById(id).get();
        ProductDTO productDTO = new ProductDTO(product.getName(),product.getPrice(), product.getProductCategory().getId());
		System.out.println(productRepository.getOne(id).getId());
		return productDTO;
	}

}
