/**
 * 
 */
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

import com.retailstore.checkout.dto.BillDTO;
import com.retailstore.checkout.entity.Bill;
import com.retailstore.checkout.service.BillService;

/**
 * @author KDavara
 *
 */

@RestController
public class BillServiceController {

	@Autowired
	BillService billService;
	
	final Logger logger = LogManager.getLogger(BillServiceController.class);


	@RequestMapping(value = "/bills")
	public ResponseEntity<Collection<BillDTO>> geBills() {
		return new ResponseEntity<>(billService.getBills(), HttpStatus.OK);
	}

	@RequestMapping(value = "/bills/full")
	public ResponseEntity<Collection<Bill>> getBillsWithCompleteDetail() {
		return new ResponseEntity<>(billService.getBillsWithCompleteDetails(), HttpStatus.OK);
	}
	

	@RequestMapping(value = "/bills/{id}")
	public ResponseEntity<BillDTO> getBillById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(billService.getBillById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/bills/full/{id}")
	public ResponseEntity<Bill> getBillsByIdWithCompleteDetail(@PathVariable("id") Long id) {
		return new ResponseEntity<>(billService.getBillByIdWithCompleteDetails(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/bills", method = RequestMethod.POST)
	public ResponseEntity<Object> createProduct(@RequestBody BillDTO bill) {
	   logger.debug("Request received to create the bill "+ bill);
	   billService.createBill(bill);
	   return new ResponseEntity<>("Bill is created successfully", HttpStatus.CREATED);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> 
	   updateBill(@PathVariable("id") Long id, @RequestBody BillDTO bill) {
	   logger.debug("Request received to update the bill with the id "+ id + " and new bill data "+bill);	
	   billService.updateBill(id, bill);
	   return new ResponseEntity<>("Bill updated successsfully", HttpStatus.OK);
	}

	@RequestMapping(value = "/bills/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
	   logger.debug("Request received to delete the bill with the id "+ id);
	   billService.deleteBill(id);
	   return new ResponseEntity<>("Bill deleted successsfully", HttpStatus.OK);
	}
}
