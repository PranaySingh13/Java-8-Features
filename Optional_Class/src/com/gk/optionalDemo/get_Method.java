package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class get_Method {

	public static void main(String[] args) {

		// Instance Method of Optional Class
		// If a value is present in this Optional, returns the value, otherwise throws
		// NoSuchElementException.

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		System.out.println(nameOptional.get());// Dhoni

		Optional<String> emailOptional = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional.get());// NoSuchElementException

	}

}
