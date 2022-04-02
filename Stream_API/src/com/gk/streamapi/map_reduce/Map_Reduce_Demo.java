package com.gk.streamapi.map_reduce;

import java.util.Arrays;
import java.util.List;

/*Map-Reduce is a functional programming model it serves our two purpose.
 * Map -> Transforming Data
 * 
 * Reduce -> Aggregating Data(combine elements of stream and produces a single value)
 * 
 * Reduce Method
 * 
 * T reduce(T identity, BinaryOperator<T> accumulator);
 * 1. identity is initial value of type T
 * 2. accumulator is a function for combining two values.
 * */

public class Map_Reduce_Demo {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(2, 4, 6, 9, 1, 3, 8);

		// Traditional Approach
		int sum = 0;
		for (int n : numbers)
			sum = sum + n;
		System.out.println(sum);

		// With Stream API Lambda Expression
		Integer sumResult = numbers.stream().mapToInt(i -> i).sum();
		System.out.println(sumResult);// 33

		// With Stream API reduce
		Integer sumResult1 = numbers.stream().reduce(0, (a, b) -> a + b);
		System.out.println(sumResult1);// 33

		// With Stream API reduce Method Reference
		System.out.println(numbers.stream().reduce(Integer::sum).get());// 33

		System.out.println(numbers.stream().reduce(1, (a, b) -> a * b));// 10368

		System.out.println(numbers.stream().reduce(0, (a, b) -> a > b ? a : b));// 9

		System.out.println(numbers.stream().reduce(Integer::max).get());// 9

		List<String> list1 = Arrays.asList("corejava", "spring", "hibernate");

		// Longest String
		System.out.println(list1.stream().reduce((a, b) -> a.length() > b.length() ? a : b).get());// hibernate
	}

}
