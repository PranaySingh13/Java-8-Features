package com.gk.streamapi.demo;

import java.util.Arrays;

public class findAny_findFirst_Method_Demo {

	public static void main(String[] args) {

		/*
		 * Stream findAny() and findFirst() returns an Optional (a container object
		 * which may or may not contain a non-null value) describing some element of the
		 * stream, or an empty Optional if the stream is empty.
		 */

		/*
		 * Using Stream findAny(). Executing the source code multiple times may not
		 * return the same result. Every time you may get a different Integer which is
		 * divisible by 4.
		 */
		System.out.println(Arrays.asList(4, 6, 8, 12, 15, 16).stream().filter(s -> s % 4 == 0).findAny().get());

		/*
		 * there might be a case where we require the first element of a filtered stream
		 * to be fetched. When the stream being worked on has a defined encounter
		 * order(the order in which the elements of a stream are processed), then
		 * findFirst() is useful which returns the first element in a Stream.
		 */
		System.out.println(Arrays.asList(4, 6, 8, 12, 15, 16).stream().filter(s -> s % 4 == 0).findFirst().get());

	}

}
