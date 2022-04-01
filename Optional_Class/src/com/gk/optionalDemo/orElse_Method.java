package com.gk.optionalDemo;

import java.util.Arrays;
import java.util.Optional;

public class orElse_Method {

	public static void main(String[] args) {
		// Instance Method of Optional Class
		// It returns the value if present, otherwise returns other.

		Customer customer = new Customer(1, "Dhoni", null, Arrays.asList("9898989898", "8787878787"));

		Optional<String> emailOptional = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional.orElse("dhoni@gmail.com"));// dhoni@gmail.com

		customer.setEmail("msd@gmail.com");
		Optional<String> emailOptional1 = Optional.ofNullable(customer.getEmail());
		System.out.println(emailOptional1.orElse("dhoni@gmail.com"));// msd@gmail.com

	}

}
