package com.gk.streamapi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * Stream API is used to process collections of objects.
 * 
 * It Can be applied only on List or Array.
 * 
 * A Stream is a sequence of objects that supports various methods which can be
 * pipelined to produce the desired result.
 * 
 * A Stream is not a Data Structure instead it takes input from the Collections,
 * Arrays or I/O Channels.
 * 
 * Stream don't change the original data structure, they only provide the result
 * as per the pipeline methods.
 * 
 * 
 * Why We Need Stream API ?
 * 
 * Functional Programming, Code Reduce, Bulk Operation
 * 
 * forEach Method is used for iteration.Performs an action for each element of
 * this stream.
 * 
 * void forEach(Consumer<? super T> action);
 */
public class For_Each_Method_Demo {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("Dell");
		list.add("Apple");
		list.add("Lenovo");
		list.add("Microsoft");

		// Simple Operation getting the input and printing it one by one iteratively.

		// Traditional Approach
		for (String s : list) {
			System.out.print(s + " ");// Dell Apple Lenovo Microsoft
		}

		System.out.println();

		// with Stream API and Lambda Expression
		list.stream().forEach(s -> System.out.print(s + " "));// Dell Apple Lenovo Microsoft

		// Internal Working of forEach method in Stream API
		Consumer<String> consumer = s -> System.out.print(s + " ");
		for (String s : list) {
			consumer.accept(s);
		}
		// Dell Apple Lenovo Microsoft

		System.out.println();

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Dell");
		map.put(2, "Apple");
		map.put(3, "Lenovo");
		map.put(4, "Microsoft");

		map.entrySet().stream().forEach(obj -> System.out.println(obj));
		/*
		 * 1=Dell 2=Apple 3=Lenovo 4=Microsoft
		 */
	}

}
