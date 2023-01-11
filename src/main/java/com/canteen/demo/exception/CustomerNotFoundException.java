package com.canteen.demo.exception;

import lombok.AllArgsConstructor;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerNotFoundException extends RuntimeException {

	
	private static final long serialVersionUID =1L;
	private String message;

}



