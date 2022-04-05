package com.gk.streamapi.demo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class limit_peek_skip_noneMatch_Method_Demo {

	/**
	 * limit(long maxSize)
	 * 
	 * Returns a stream consisting of the elements of this stream, truncated to be
	 * no longer than maxSize in length.
	 * 
	 * skip(long n)
	 * 
	 * Returns a stream consisting of the remaining elements of this stream after
	 * discarding the first n elements of the stream.
	 * 
	 * peek(Consumer<? super T> action)
	 * 
	 * Returns a stream consisting of the elements of this stream, additionally
	 * performing the provided action on each element as elements are consumed from
	 * the resulting stream.
	 * 
	 * This method exists mainly to support debugging, where you want to see the
	 * elements as they flow past a certain point in a pipeline. Using peek without
	 * any terminal operation does nothing.
	 * 
	 * noneMatch(Predicate<? super T> predicate)
	 * 
	 * Returns whether no elements of this stream match the provided predicate.
	 */
	public static void main(String[] args) {

		List<String> list = Arrays.asList("Geeks", "for", "GeeksQuiz", "GeeksforGeeks");
		System.out.println(list.stream().limit(2).collect(Collectors.toList()));// [Geeks, for]

		System.out.println(list.stream().skip(2).collect(Collectors.toList()));// [GeeksQuiz, GeeksforGeeks]

		list.stream().peek(System.out::println);
		// From the above output, we can perceive that this piece of code will produce
		// no output

		// Using peek with count() method,Method
		// which is a terminal operation
		list.stream().peek(System.out::println).count();

		boolean answer = list.stream().noneMatch(s -> s.startsWith("G"));// false
		System.out.println(answer);// false
	}
}
