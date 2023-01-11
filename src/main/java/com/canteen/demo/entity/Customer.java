package com.canteen.demo.entity;

import javax.persistence.Column;






import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customerId")
	private Integer customerId;
	

	@Column(name="customerName")
	private String customerName;
	
//	@Digits(message="number should be 10 digits", fraction = 0, integer = 10)
	@Column(name="mobileNo")
	private String mobileNo;
	
//	@Email(message="email should be valid")
	@Column(name="customerEmail")
	private String customerEmail;

	private String userName;
	private String password;

}
