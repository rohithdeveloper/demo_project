package com.canteen.demo.controllers;

import static org.mockito.Mockito.doNothing;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.canteen.demo.controller.CustomerController;
import com.canteen.demo.dto.CustomerDTO;
import com.canteen.demo.service.ICustomerServices;

@ExtendWith(MockitoExtension.class)
public class TestControllers {
	
	@InjectMocks
	CustomerController customerController;
	
	@Mock
	ICustomerServices customerService;

	
	
	@Test
	void getAllCustomers() {
		List<CustomerDTO> customerdto= createCustomerDtoMockData();
		when(customerService.viewCustomersList()).thenReturn(customerdto);
		List<CustomerDTO> customerdto1=customerController.viewCustomersList();
		assert(customerdto.size()==customerdto1.size());
	}
	private List<CustomerDTO> createCustomerDtoMockData() {
		// TODO Auto-generated method stub
		List<CustomerDTO> customers=new ArrayList<>();
		CustomerDTO customerDto=new CustomerDTO();
		customerDto.setCustomerId(1);
		customerDto.setCustomerName("hero");
		customerDto.setCustomerEmail("roh@gmail.com");
		customerDto.setMobileNo("3427684587");
		return customers;
	}
	@Test
	void addCustomers() {
		CustomerDTO customerdto=createCustomerDtoMockData1();
		when(customerService.addCustomer(customerdto)).thenReturn(customerdto);
		CustomerDTO customerdto1=customerController.addCustomer(customerdto);
		assert(customerdto.getCustomerId()==customerdto1.getCustomerId());
	}
	
	private CustomerDTO createCustomerDtoMockData1() {
		// TODO Auto-generated method stub
		CustomerDTO customerDto=new CustomerDTO();
		customerDto.setCustomerId(1);
		customerDto.setCustomerName("hero");
		customerDto.setCustomerEmail("roh@gmail.com");
		customerDto.setMobileNo("3427684587");
		return customerDto;
	
	}
	
	@Test
	void updateCustomers() {
		CustomerDTO customerdto=updateCustomerDtoMockData();
		when(customerService.updateCustomers(1, customerdto)).thenReturn(customerdto);
		CustomerDTO customerdto1=customerController.updateCustomers(1, customerdto);
		assert(customerdto.getCustomerId()==customerdto1.getCustomerId());
		
	}
	private CustomerDTO updateCustomerDtoMockData() {
		// TODO Auto-generated method stub
		CustomerDTO customerDto=new CustomerDTO();
		customerDto.setCustomerId(1);
		customerDto.setCustomerName("hero");
		customerDto.setCustomerEmail("roh@gmail.com");
		customerDto.setMobileNo("3427684587");
		return customerDto;
	
	}
	
	@Test
	void deleteCustomers() {
		int customerId=1;
		String msg="customer deleted Succesfully";
		doNothing().when(customerService).deleteCustomers(customerId);
		String message=customerController.deleteCustomers(customerId);
		assert(message.equals(msg));
		
	}
	
}
