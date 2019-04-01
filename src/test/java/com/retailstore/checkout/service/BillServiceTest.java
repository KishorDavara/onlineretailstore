package com.retailstore.checkout.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.retailstore.checkout.dto.BillDTO;
import com.retailstore.checkout.dto.BillProductDTO;
import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.entity.Bill;
import com.retailstore.checkout.entity.Product;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BillServiceTest {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	BillService billService;

	@Test
	public void createBillTest() {
		try {
			// create the products
			Product product1 = productService.createProduct(new ProductDTO("Maggy Masala",20,1));
			Product product2 = productService.createProduct(new ProductDTO("Balaji Wafers",20,2));
			
			List<BillProductDTO> billProducts = new ArrayList<BillProductDTO>();
			billProducts.add(new BillProductDTO(product1.getId(),2));
			billProducts.add(new BillProductDTO(product2.getId(),4));
			
			BillDTO billDTO = new BillDTO(billProducts);
			
			Bill bill = billService.createBill(billDTO);
			
			long totalItems = 6;
			double subTotal = (20*2)+(20*4);
			double totalSalesTax = ((20 * 0.10)*2) + ((20* 0.20)*4);
			double totalCost = subTotal + totalSalesTax;
			Assert.assertEquals(totalItems, bill.getTotalItems());
			Assert.assertEquals(subTotal, bill.getSubTotal(),0.1);
			Assert.assertEquals(totalSalesTax, bill.getTotalSalesTax(),0.1);
			Assert.assertEquals(totalCost, bill.getTotalCost(),0.1);	
		} catch(Exception e) {
			Assert.fail("Error occured while creating the bill");
			throw new RuntimeException("Error occured while creating the bill " + e);
		}
	}
	
	@Test
	public void deleteBillTest() {
		try {
			// create the products
			Product product1 = productService.createProduct(new ProductDTO("Maggy Masala",20,1));
			Product product2 = productService.createProduct(new ProductDTO("Balaji Wafers",20,2));
			
			List<BillProductDTO> billProducts = new ArrayList<BillProductDTO>();
			billProducts.add(new BillProductDTO(product1.getId(),2));
			billProducts.add(new BillProductDTO(product2.getId(),4));
			
			BillDTO billDTO = new BillDTO(billProducts);
			//create the bill
			Bill bill = billService.createBill(billDTO);
			
			long billId = bill.getId();
			
			//delete the bill
			billService.deleteBill(billId);
			
			//BillDTO deletedBill = billService.getBillById(id);
			//Assert.assertNull(deletedBill);	
		} catch(Exception e) {
			Assert.fail("Error occured while deleting the bill");
			throw new RuntimeException("Error occured while deleting the bill " + e);
		}
	}
	
	// This is added intentionally to check the validations in case of wrong id
	// please remove the below commented code to verify the behavior
	/*@Test
	public void nonExistingBillDeleteTest() {
		try {
			billService.deleteBill((long)5555);
		} catch(Exception e) {
			Assert.fail("Bill you are trying to delete doesn't exist");
			throw new RuntimeException("Bill you are trying to delete doesn't exist " + e);
		}
	}*/
}