package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class oFNullable_Method {

	public static void main(String[] args) {
		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		// Static Method of Optional Class
		// It returns an Optional describing the specified value, if non-null, otherwise
		// returns an empty Optional.

		// ofNullable=empty+of
		Optional<String> emailOptional1 = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional1);// Optional.empty

		customer.setEmail("dhoni@gmail.com");
		Optional<String> emailOptional2 = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional2);// Optional[dhoni@gmail.com]

	}

}
