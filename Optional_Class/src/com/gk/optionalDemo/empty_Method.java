package com.gk.optionalDemo;

import java.util.Optional;

public class empty_Method {
	public static void main(String[] args) {

		// Static Method of Optional Class
		// It returns an empty Optional object. No value is present for this Optional.
		Optional<Object> empty = Optional.empty();
		System.out.println(empty);// Optional.empty
	}

}
