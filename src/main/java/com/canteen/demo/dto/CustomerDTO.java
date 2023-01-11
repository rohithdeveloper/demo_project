package com.canteen.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer customerId;
	

    @NotEmpty(message = "Enter customer name.")
	private String customerName;
	
	@Digits(message="Number should contain 10 digits.", fraction = 0, integer = 10)
	private String mobileNo;
	
	@Email
	private String customerEmail;
	
	private String userName;
	private String password;
	

	
	
	
}
