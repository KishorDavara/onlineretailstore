/**
 * 
 */
package com.retailstore.checkout;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.entity.Product;
import com.retailstore.checkout.entity.ProductCategory;
import com.retailstore.checkout.repository.ProductCategoryRepository;

/**
 * @author KDavara
 * Helper class for configure the Retail Store Data
 * This class is responsible for adding the products and category details x
 */

@Component
public class ConfigureRetailStore implements CommandLineRunner {

	@Autowired
    private ProductCategoryRepository prodcutCategoryRepository;
    
    @Autowired
    private ProductRepository productRepository;
    
    private static List<ProductCategory> categoryList;
    
    static {
    	// create the product category
    		ProductCategory category1 = new ProductCategory("A",10.00);
    		ProductCategory category2 = new ProductCategory("B",20.00);
    		ProductCategory category3 = new ProductCategory("C",0.00);
    			
    	    categoryList = new ArrayList<>();
    	    categoryList.add(category1);
    	    categoryList.add(category2);
    	    categoryList.add(category3);
      }
    
	@Override
	public void run(String... args) throws Exception {
	  this.configureProductCategory();
	  this.configureProduct();
	}
	
	/**
	 * create the product category list
	 * @throws Exception
	 */
	public void configureProductCategory() throws Exception {
        //save the product categories into database
        prodcutCategoryRepository.saveAll(categoryList);
	}
	
	/**
	 * create the products
	 * @throws Exception
	 */
    public void configureProduct() throws Exception {
    	//configure the product data
    	List<Product> productList = new ArrayList<>();
    	productList.add(new Product("All Natural Peanut Butter Crunchy (1 kg) ",449.00,categoryList.get(0)));
    	productList.add(new Product("Apis Himalaya Honey, 1kg",390.00,categoryList.get(1)));
    	productList.add(new Product("Girnar Green Tea, Desi Kahwa, 36 Tea Bags",330.00,categoryList.get(2)));
    	productList.add(new Product("Quaker Oats Pouch, 1kg",185.00,categoryList.get(0)));
    	productList.add(new Product("Maggi 2-Minute Noodles Masala, 70g (Pack of 12)",144.00,categoryList.get(2)));
    
        //save the product data into database
    	productRepository.saveAll(productList);
	}

}
