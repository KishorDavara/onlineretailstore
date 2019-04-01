package com.retailstore.checkout.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailstore.checkout.dto.BillDTO;
import com.retailstore.checkout.dto.BillProductDTO;
import com.retailstore.checkout.dto.ProductDTO;
import com.retailstore.checkout.dto.PurchaseDTO;
import com.retailstore.checkout.entity.Bill;
import com.retailstore.checkout.entity.Product;
import com.retailstore.checkout.entity.Purchase;
import com.retailstore.checkout.repository.BillRepository;
import com.retailstore.checkout.repository.ProductRepository;
import com.retailstore.checkout.repository.PurchaseRepository;

/**
 * @author KDavara
 *
 */

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	BillRepository billRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	PurchaseRepository purchaseRepository;
	

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#createBill(com.retailstore.checkout.entity.Bill)
	 */
	@Override
	public void createBill(BillDTO billDTO) {
		List<BillProductDTO> billProducts = billDTO.getBillProducts();
		Set<Purchase> purchases = new LinkedHashSet<>(); 
		int totalItems = 0;
		double subTotal = 0.0;
		double totalSalesTax = 0.0;
		
		for (BillProductDTO bill : billProducts) {
			Product product = productRepository.findById(bill.getProductId()).get();
			int quantity = bill.getQuantity();
			// add purchase to the list of purchases
			purchases.add( new Purchase(product,quantity));
			
			//calculate the totalItems,value and tax
			totalItems += quantity;
			subTotal += product.getPrice();
			totalSalesTax += product.getSalesTax();
		}
		
		Bill bill = new Bill(purchases,totalItems,subTotal,totalSalesTax);
		
		billRepository.save(bill);		
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#updateBill(java.lang.String, com.retailstore.checkout.entity.Bill)
	 */
	@Override
	public void updateBill(Long id, BillDTO billDTO) {
		List<BillProductDTO> billProducts = billDTO.getBillProducts();
		Set<Purchase> purchases = new LinkedHashSet<>(); 
		int totalItems = 0;
		double subTotal = 0.0;
		double totalSalesTax = 0.0;
		
		for (BillProductDTO bill : billProducts) {
			Product product = productRepository.findById(bill.getProductId()).get();
			int quantity = bill.getQuantity();
			// add purchase to the list of purchases
			purchases.add( new Purchase(product,quantity));
			
			//calculate the totalItems,value and tax
			totalItems += quantity;
			subTotal += product.getPrice();
			totalSalesTax += product.getSalesTax();
		}
		
		Bill bill = billRepository.findById(id).get();
		bill.setPurchases(purchases);
		bill.setTotalItems(totalItems);
		bill.setSubTotal(subTotal);
		bill.setTotalSalesTax(totalSalesTax);
		bill.setTotalCost(subTotal + totalSalesTax);
		
		billRepository.save(bill);
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#deleteBill(java.lang.String)
	 */
	@Override
	public void deleteBill(Long id) {
	    billRepository.deleteById(id);	
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#getBills()
	 */
	@Override
	public Collection<BillDTO> getBills() {
		List<Bill> bills = billRepository.findAll();
		List<BillDTO> billList = new ArrayList<>();
		bills.forEach(bill -> {
			BillDTO billdto = new BillDTO();
			billdto.setNoOfItems(bill.getTotalItems());
			billdto.setSubTotal(bill.getSubTotal());
			billdto.setTotalTax(bill.getTotalSalesTax());
			billdto.setTotalCost(bill.getTotalCost());
			Set<Purchase> purchases = new LinkedHashSet<>(bill.getPurchases());
			Set<PurchaseDTO> purchasesList = new LinkedHashSet<>();
			
			purchases.forEach(purchase -> {
				Product product = purchaseRepository.findById(purchase.getId()).get().getProduct();
				ProductDTO productdto = new ProductDTO(product.getName(), product.getPrice(), product.getProductCategory().getId());
				PurchaseDTO purchasedto = new PurchaseDTO(productdto, purchase.getQuantity());
				purchasesList.add(purchasedto);
			});
			billdto.setPurchases(purchasesList);
			billList.add(billdto);		
		});
		return billList;
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#getBillById(java.lang.String)
	 */
	@Override
	public BillDTO getBillById(Long id) {
		Bill bill = billRepository.findById(id).get();
		
		BillDTO billdto = new BillDTO();
		billdto.setNoOfItems(bill.getTotalItems());
		billdto.setSubTotal(bill.getSubTotal());
		billdto.setTotalTax(bill.getTotalSalesTax());
		billdto.setTotalCost(bill.getTotalCost());
		
		Set<Purchase> purchases = new LinkedHashSet<>(bill.getPurchases());
		Set<PurchaseDTO> purchasesList = new LinkedHashSet<>();
		purchases.forEach(purchase -> {
				Product product = purchaseRepository.findById(purchase.getId()).get().getProduct();
				ProductDTO productdto = new ProductDTO(product.getName(), product.getPrice(), product.getProductCategory().getId());
				PurchaseDTO purchasedto = new PurchaseDTO(productdto, purchase.getQuantity());
				purchasesList.add(purchasedto);
		});
		billdto.setPurchases(purchasesList);		
		return billdto;
	}

	/* (non-Javadoc)
	 * @see com.retailstore.checkout.service.BillService#getBillsWithCompleteDetails()
	 */
	@Override
	public Collection<Bill> getBillsWithCompleteDetails() {
		return billRepository.findAll();
	}

}
