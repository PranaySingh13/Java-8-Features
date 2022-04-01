package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class isPresent_Method {

	public static void main(String[] args) {
		// Instance Method of Optional Class
		// It returns true if there is a value present, otherwise false.

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		if (nameOptional.isPresent())// true
			System.out.println(nameOptional.get());// Dhoni
		else
			System.out.println(nameOptional.get());

	}

}
