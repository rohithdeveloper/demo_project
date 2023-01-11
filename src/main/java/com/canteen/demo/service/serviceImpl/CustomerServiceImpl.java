package com.canteen.demo.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.canteen.demo.dto.CustomerDTO;
import com.canteen.demo.entity.Customer;
import com.canteen.demo.exception.CustomerNotFoundException;
import com.canteen.demo.repository.CustomerJPARepository;
import com.canteen.demo.service.ICustomerServices;





@Service
public class CustomerServiceImpl implements ICustomerServices{

	@Autowired
	public CustomerJPARepository repository;

	
	@Override
	public CustomerDTO addCustomer(CustomerDTO customer) {
		// TODO Auto-generated method stub
		Customer c =new Customer();
		c.setCustomerEmail(customer.getCustomerEmail());
		//c.setCustomerId(customer.getCustomerId());
		c.setCustomerName(customer.getCustomerName());
		c.setMobileNo(customer.getMobileNo());
		repository.save(c);
		return customer;
	}

	@Override
	public List<CustomerDTO> viewCustomersList() {
		
		// TODO Auto-generated method stub
		
		 List<CustomerDTO> Customer=new ArrayList<>();
	        List<Customer> listCustomers=repository.findAll();
	        listCustomers.stream().forEach(customer-> {
	        	CustomerDTO customerdto=new CustomerDTO();
	        	customerdto.setCustomerEmail(customer.getCustomerEmail());
	        	customerdto.setCustomerId(customer.getCustomerId());
	        	customerdto.setCustomerName(customer.getCustomerName());
	        	customerdto.setMobileNo(customer.getMobileNo());
	        	Customer.add(customerdto);
	        });
		
			return Customer;
	
	}

	@Override
	public CustomerDTO updateCustomers(Integer customerId, CustomerDTO customerdto) {
		// TODO Auto-generated method stub
		Customer c =repository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("no customer with"+customerId));
		c.setCustomerEmail(customerdto.getCustomerEmail());
		//c.setCustomerId(customerdto.getCustomerId());
		c.setCustomerName(customerdto.getCustomerName());
		c.setMobileNo(customerdto.getMobileNo());
		repository.save(c);
	    return customerdto;
		
	}

	@Override
	public void deleteCustomers(Integer customerId) {
		// TODO Auto-generated method stub
		repository.deleteById(customerId);
		
	}

	@Override
	public CustomerDTO viewCustomers(Integer customerId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Customer customerdto=repository.findById(customerId).orElseThrow(()-> new CustomerNotFoundException("no customer with"+customerId));
		CustomerDTO c =new CustomerDTO();
		c.setCustomerEmail(customerdto.getCustomerEmail());
		c.setCustomerId(customerdto.getCustomerId());
		c.setCustomerName(customerdto.getCustomerName());
		c.setMobileNo(customerdto.getMobileNo());
		return c;
	
	}

	

	
	

	

	

}
