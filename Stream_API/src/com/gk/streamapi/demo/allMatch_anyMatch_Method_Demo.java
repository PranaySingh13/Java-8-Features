package com.gk.streamapi.demo;

import java.util.Arrays;
import java.util.List;

public class allMatch_anyMatch_Method_Demo {

	/**
	 * allMatch(Predicate<? super T> predicate)
	 * 
	 * Returns whether all elements of this stream match the provided predicate.
	 * 
	 * anyMatch(Predicate<? super T> predicate)
	 * 
	 * Returns whether any elements of this stream match the provided predicate.
	 * 
	 * Note : If the stream is empty then true is returned and the predicate is not
	 * evaluated.
	 * 
	 * Basically this functions are used to filtered out streams.
	 */
	public static void main(String[] args) {

		// to check whether all elements are divisible by 3.
		List<Integer> list1 = Arrays.asList(3, 4, 6, 12, 20);

		boolean answer1 = list1.stream().allMatch(num -> num % 3 == 0);
		System.out.println(answer1);// false

		boolean answer2 = list1.stream().anyMatch(num -> num % 3 == 0);
		System.out.println(answer2);// true

		// to check whether strings have length greater than 2.
		List<String> list2 = Arrays.asList("Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
		System.out.println(list2.stream().allMatch(str -> str.length() > 4));// false
		System.out.println(list2.stream().anyMatch(str -> str.length() > 4));// true

		// to check whether all strings have UpperCase character at 1st.
		System.out.println(list2.stream().allMatch(str -> Character.isUpperCase(str.charAt(0))));// false
		System.out.println(list2.stream().anyMatch(str -> Character.isUpperCase(str.charAt(0))));// true

	}

}
