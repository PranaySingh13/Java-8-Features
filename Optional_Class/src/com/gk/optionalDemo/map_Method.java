package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class map_Method {

	public static void main(String[] args) {
		// Instance Method of Optional Class
		/*
		 * If a value is present, apply the provided mapping function to it, and if the
		 * result is non-null, return an Optional describing the result. Otherwise
		 * return an empty Optional.
		 */

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		System.out.println(nameOptional.map(String::toUpperCase));// Optional[DHONI]

		Optional<String> emailOptional = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional.map(String::toUpperCase));// Optional.empty

	}

}
