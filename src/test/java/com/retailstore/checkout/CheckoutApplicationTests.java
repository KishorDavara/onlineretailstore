package com.retailstore.checkout;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.checkout.entity.ProductCategory;
import com.retailstore.checkout.repository.ProductCategoryRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CheckoutApplicationTests {

	@Autowired
    private ProductCategoryRepository prodcutCategoryRepository;
	
	@Test
	public void contextLoads() {
	   productCategoryCreateTest();
	}
	
	@Test
	public void productCategoryCreateTest() {
		long beforeAddCount = prodcutCategoryRepository.count();
		ProductCategory category1 = new ProductCategory("A",10.00);
		ProductCategory category2 = new ProductCategory("B",20.00);
		ProductCategory category3 = new ProductCategory("C",0.00);
			
	    List<ProductCategory> categoryList = new ArrayList<>();
	    categoryList.add(category1);
	    categoryList.add(category2);
	    categoryList.add(category3);
		prodcutCategoryRepository.saveAll(categoryList);
		long afterAddCount = prodcutCategoryRepository.count();
		Assert.assertEquals(afterAddCount, beforeAddCount + 3);
	}

}
