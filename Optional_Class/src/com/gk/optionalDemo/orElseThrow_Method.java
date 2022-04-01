package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class orElseThrow_Method {

	public static void main(String[] args) {
		// Instance Method of Optional Class

		/*
		 * It returns the contained value, if present, otherwise throw an exception to
		 * be created by the provided supplier.
		 */

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		System.out.println(nameOptional.orElseThrow(() -> new IllegalArgumentException("Name is not present")));
		// Dhoni

		Optional<String> emailOptional1 = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional1.orElseThrow(() -> new IllegalArgumentException("Email is not present")));
		// IllegalArgumentException: Email is not present

	}

}
