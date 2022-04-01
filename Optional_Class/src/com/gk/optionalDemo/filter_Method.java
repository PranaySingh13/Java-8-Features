package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class filter_Method {

	public static void main(String[] args) {

		// Instance Method of Optional Class
		// If a value is present, and the value matches the given predicate, return an
		// Optional describing the value, otherwise return an empty Optional.

		// case 1
		Customer customer1 = new Customer(12, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<Integer> idOptional1 = Optional.ofNullable(customer1.getId());
		System.out.println(idOptional1.filter(s -> s % 2 == 0));// Optional[12]

		// case 2
		Customer customer = new Customer(11, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<Integer> idOptional = Optional.ofNullable(customer.getId());
		System.out.println(idOptional.filter(s -> s % 2 == 0));// Optional.empty

	}

}
