package com.gk.streamapi.skip_limit;

import java.util.Arrays;
import java.util.List;

public class SkipLimitExample {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		/*
		 * The skip(n) method is an intermediate operation that discards the first n
		 * elements of a stream he n parameter can't be negative, and if it's higher
		 * than the size of the stream, skip() returns an empty stream.
		 */
		numbers.stream().skip(1).forEach(number -> System.out.print(number + " "));
		// 2 3 4 5 6 7 8 9 10
		System.out.println();

		/*
		 * The limit(n) method is another intermediate operation that returns a stream
		 * not longer than the requested size.the n parameter can't be negative.
		 */
		numbers.stream().limit(7).forEach(number -> System.out.print(number + " "));
		// 1 2 3 4 5 6 7
		System.out.println();

		numbers.stream().skip(1).limit(7).forEach(number -> System.out.print(number + " "));
		// 2 3 4 5 6 7 8
		System.out.println();

	}

}
