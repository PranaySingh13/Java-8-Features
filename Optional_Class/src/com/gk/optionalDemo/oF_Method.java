package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class oF_Method {

	public static void main(String[] args) {

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		// Static Method of Optional Class
		// It returns an Optional with the specified present non-null value.
		Optional<String> emailOptional = Optional.of(customer.getEmail());
		System.out.println(emailOptional);// Null Pointer Exception

		customer.setEmail("dhoni@gmail.com");
		Optional<String> emailOptional1 = Optional.of(customer.getEmail());
		System.out.println(emailOptional1);// Optional[dhoni@gmail.com]

	}
}
