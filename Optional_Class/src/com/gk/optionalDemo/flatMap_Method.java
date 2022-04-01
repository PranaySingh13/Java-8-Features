package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class flatMap_Method {
	public static void main(String[] args) {
		// Instance Method of Optional Class
		/*
		 * If a value is present, apply the provided Optional-bearing mapping function
		 * to it, return that result, otherwise return an empty Optional.
		 * 
		 * This method is similar to map(Function), but the mapping function is one
		 * whose result is already an Optional, and if invoked, flatMap does not wrap it
		 * within an additional Optional.
		 */
		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> nameOptional = Optional.ofNullable(customer.getName());
		Optional<Optional<String>> optional = Optional.ofNullable(nameOptional);
		System.out.println(optional.flatMap(s -> s.map(String::toUpperCase)));// Optional[DHONI]
	}

}
