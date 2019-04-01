package com.retailstore.checkout.controller;

import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Product;
import com.retailstore.checkout.service.ProductService;

/**
 * @author KDavara
 *
 */

@RestController
public class ProductServiceController {

	@Autowired
	ProductService productService;

	final Logger logger = LogManager.getLogger(ProductServiceController.class);

	@RequestMapping(value = "/products")
	public ResponseEntity<Collection<ProductDTO>> getProducts() {
		return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/full")
	public ResponseEntity<Collection<Product>> getProductsWithCompleteDetail() {
		return new ResponseEntity<>(productService.getProductsWithCompleteDetail(), HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody ProductDTO product) {
		logger.debug("Request received to create the product " + product);
		productService.createProduct(product);
		return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO product) {
		logger.debug("Request received to update the product with id " + id + " and new product data "+product);
		productService.updateProduct(id, product);
		return new ResponseEntity<>("Product updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
		logger.debug("Request received to delete the product with id " + id);
		productService.deleteProduct(id);
		return new ResponseEntity<>("Product deleted successsfully", HttpStatus.OK);
	}

}
