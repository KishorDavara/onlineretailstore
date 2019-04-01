package com.retailstore.checkout.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Product;

import org.junit.Assert;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {

	@Autowired
	ProductService productService;
	
	@Test
	public void createProductTest() {
		try {
			Product product1 = productService.createProduct(new ProductDTO("Masala Maggy",12,1));
			Product product2 = productService.getProductWithCompleteDetail(product1.getId());
			Assert.assertEquals(product1.getId(),product2.getId());	
		} catch(Exception e) {
			Assert.fail("Error occured while creating the product");
			throw new RuntimeException("Error occured while creating the product " + e);
		}
	}
	
	@Test
	public void getAllProductTest() {
		try {
			long earlierCount = productService.getTotalProductCount();
			productService.createProduct(new ProductDTO("Orangle",20,1));
			productService.createProduct(new ProductDTO("Banana",30,2));
			productService.createProduct(new ProductDTO("Grapes",40,3));
			long afterAddCount = productService.getTotalProductCount();
			Assert.assertEquals(afterAddCount, earlierCount + 3);
		} catch(Exception e) {
			Assert.fail("Error occured while retrieving the products");
			throw new RuntimeException("Error occured while retrieving the products" + e);
		}
	}
	
	@Test
	public void updateProductTest() {
		try {
			Product product1 = productService.createProduct(new ProductDTO("Masala Maggy ",12,1));
			Product product2 = productService.updateProduct(product1.getId(),new ProductDTO("Masala Maggy ",12,1));
			Product product3 = productService.getProductWithCompleteDetail(product1.getId());
			Assert.assertEquals(product3.getId(),product2.getId());
			Assert.assertEquals(product3.getName(),product2.getName());
			Assert.assertEquals(product3.getPrice(),product2.getPrice(),0.1);
			Assert.assertEquals(product3.getSalesTax(),product2.getSalesTax(),0.1);
			Assert.assertEquals(product3.getProductCategory().getId(),product2.getProductCategory().getId());	
		} catch(Exception e) {
			Assert.fail("Error occured while updating the product");
			throw new RuntimeException("Error occured while updating the product " + e);
		}
	}
	
	//this is added intentionally to check the product update behavior in case of wrong product id
	// please remove the below commented code to check the behavior
	/*@Test
	public void nonExistingProductUpdateTest() {
		try {
			Product product = productService.createProduct(new ProductDTO("Orangle",20,1));
			Product updatedProduct = productService.updateProduct((long)22222,new ProductDTO("Masala Maggy ",12,1));
		} catch(Exception e) {
			// Assert.fail("Product you are trying to update doesn't exist");
			throw new RuntimeException("Product you are trying to update doesn't exist" + e);
		}
	}*/
	
	@Test
	public void deleteProductTest() {
		try {
		Product product = productService.createProduct(new ProductDTO("kissan ketchup",45,2));
		long productId = product.getId();
		productService.deleteProduct(productId);
//		ProductDTO deletedProduct = productService.getProductById(productId);
//		Assert.assertNull(deletedProduct);
		} catch(Exception e) {
			Assert.fail("Error occured while deleting the product");
			throw new RuntimeException("Error occured while deleting the product " + e);
		}
	}

	//this is added intentionally to check the product delete behavior in case of wrong product id
	// please remove the below commented code to check the behavior
	/*@Test
	public void nonExistingProductDeleteTest() {
		try {
		productService.deleteProduct((long)5555);
		} catch(Exception e) {
			Assert.fail("Product you are trying to delete doesn't exist");
			throw new RuntimeException("Product you are trying to delete doesn't exist " + e);
		}
	}*/
}