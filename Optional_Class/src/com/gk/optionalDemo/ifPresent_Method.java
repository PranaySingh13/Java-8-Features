package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class ifPresent_Method {

	public static void main(String[] args) {
		// Instance Method of Optional Class
		// If a value is present, invoke the specified consumer with the value,
		// otherwise do nothing.

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));// DHONI

		Optional<String> emailOptional = Optional.ofNullable(customer.getEmail());
		emailOptional.ifPresent(s -> System.out.println(s.toUpperCase()));//
	}

}
