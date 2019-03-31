package com.retailstore.checkout;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retailstore.checkout.entity.Product;
import com.retailstore.checkout.entity.ProductCategory;
import com.retailstore.checkout.repository.ProductCategoryRepository;
import com.retailstore.checkout.repository.ProductRepository;

@RestController
public class Test {

	@Autowired
	ProductCategoryRepository productCategoryRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	
    @RequestMapping("/categories")
    public List<ProductCategory> getProductCategories() {
    	List<ProductCategory> s = productCategoryRepository.findAll();
    	s.forEach(ss -> System.out.println(ss.getName()+" "+ss.getSalesTaxPercentage()));
        return s;
    }

    @RequestMapping("/")
    public List<Product> product() {
    	List<Product> s = productRepository.findAll();
    	s.forEach(ss -> System.out.println(ss.getName()+" "+ss.getProductCategory()));
        return s;
    }
}