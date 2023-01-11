package com.canteen.demo.controller;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.canteen.demo.dto.CustomerDTO;
import com.canteen.demo.exception.CustomerNotFoundException;
import com.canteen.demo.service.ICustomerServices;





@RestController
@RequestMapping("/CustomerDetails")

public class CustomerController {

	Logger log=LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	public ICustomerServices customerService;
	
	@Validated
	@PostMapping("/addcustomer")
	public CustomerDTO addCustomer (@RequestBody @Valid CustomerDTO customer) {
	CustomerDTO customers= customerService.addCustomer(customer);
	log.info("products Added successfully");
	return customers;
	}
	
	@GetMapping("/customers/getcustomers")
	public List<CustomerDTO> viewCustomersList(){
		log.info("products viewed successfully by Id");
		return customerService.viewCustomersList();
	}
	
	@PutMapping("/updatecustomers/{customerId}")
	public CustomerDTO updateCustomers ( @PathVariable("customerId") Integer CustomerId ,@RequestBody CustomerDTO customerdto) throws CustomerNotFoundException
	{
		CustomerDTO customer =customerService.updateCustomers(CustomerId,customerdto);
		log.info("view customers by ID");
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomers(@PathVariable("customerId") Integer CustomerId) throws CustomerNotFoundException
	{
		customerService.deleteCustomers(CustomerId);
	 log.info("delete customers by ID");
	return "customer deleted Succesfully";	 
	}
	
	@GetMapping("/getCustomersById/{customerId}")
	public CustomerDTO viewCustomers(@PathVariable("customerId") Integer CustomerId)throws CustomerNotFoundException
	{
		CustomerDTO customers = customerService.viewCustomers(CustomerId);
		log.info("view products by Id");
		return customers;
	
	}
	
}
