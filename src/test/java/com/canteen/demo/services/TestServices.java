package com.canteen.demo.services;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.canteen.demo.dto.CustomerDTO;
import com.canteen.demo.entity.Customer;
import com.canteen.demo.repository.CustomerJPARepository;
import com.canteen.demo.service.ICustomerServices;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestServices {
	
	@Autowired
	ICustomerServices customerServices;
	
	@Mock
	CustomerJPARepository customerRepository;
	
	@Test
	void addCustomer() {
		CustomerDTO customerdto=createCustomerDtoMockData();
		Customer customer =createCustomerMockData();
		when(customerRepository.save(customer)).thenReturn(customer);
		CustomerDTO dto=customerServices.addCustomer(customerdto);
		assert(customer.getCustomerId()==dto.getCustomerId());
	}

	private Customer createCustomerMockData() {
		// TODO Auto-generated method stub
		int customerId=1;
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName("rohith");
		customer.setMobileNo("63263233345");
		customer.setCustomerEmail("ro@gmail.com");
		return customer;
	}

	private CustomerDTO createCustomerDtoMockData() {
		// TODO Auto-generated method stub
		int customerId=1;
		CustomerDTO customerdto=new CustomerDTO();
		customerdto.setCustomerId(customerId);
		customerdto.setCustomerName("rohith");
		customerdto.setMobileNo("63263233345");
		customerdto.setCustomerEmail("ro@gmail.com");
		return customerdto;
		
	}
	
	@Test
	void updateCustomer() {
		CustomerDTO customerdto=createCustomerDtoMockData();
		Optional<Customer> customer =Optional.of(createCustomerMockData());
		int customerId=1;
		when(customerRepository.findById(1)).thenReturn(customer);
		CustomerDTO dto=customerServices.updateCustomers(customerId, customerdto);
		assert(customer.get().getCustomerId()==dto.getCustomerId());
	}
	
}
