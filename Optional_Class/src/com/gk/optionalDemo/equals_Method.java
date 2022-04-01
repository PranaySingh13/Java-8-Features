package com.gk.optionalDemo;

import java.util.Optional;

public class equals_Method {

	public static void main(String[] args) {
		/*
		 * Indicates whether some other object is "equal to" this Optional or not. The
		 * other object is considered equal if:
		 * 
		 * It is also an Optional.
		 * 
		 * Both instances have no value present.
		 * 
		 * The present values are "equal to" each other via equals().
		 */

		Optional<String> optional = Optional.ofNullable("Java8");
		boolean isEqual = optional.equals("Java8");
		System.out.println(isEqual);// false

		Optional<String> optional3 = Optional.ofNullable("Java8");
		Optional<String> optional4 = Optional.ofNullable("Java8");
		boolean isOptionalEqual = optional3.equals(optional4);
		System.out.println(isOptionalEqual);// true

	}

}
