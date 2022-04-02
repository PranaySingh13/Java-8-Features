package com.gk.streamapi.demo;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

		numbers.forEach(x -> System.out.println(x));

		/*
		 * Here, you don't actually need the name x in order to invoke println for each
		 * of the elements. That's where the method reference is helpful - the ::
		 * operator denotes you will be invoking the println method with a parameter,
		 * which name you don't specify explicitly:
		 * 
		 * It's called a "method reference" and it's a syntactic sugar for expressions
		 * like this:
		 */
		numbers.forEach(System.out::println);
	}

}
