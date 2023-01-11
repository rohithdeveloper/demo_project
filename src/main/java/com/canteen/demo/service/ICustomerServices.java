package com.canteen.demo.service;



import java.util.List;



import com.canteen.demo.dto.CustomerDTO;



public interface ICustomerServices {

	CustomerDTO addCustomer(CustomerDTO customer);



	CustomerDTO updateCustomers(Integer customerId, CustomerDTO customerdto);

	void deleteCustomers(Integer customerId);

	CustomerDTO viewCustomers(Integer customerId);

	List<CustomerDTO> viewCustomersList();



	
}

