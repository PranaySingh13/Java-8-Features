package com.gk.streamapi.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Collect Elements of a Stream into a Collection.
 * 
 * Elements from a Stream can be easily collected into
 * a container by using the Stream.collect operation.
 * 
 * Now After getting container it can be converted into 
 * Other Collection instances, such as a List,Set,Map etc.
 * can be made by using other Collectors built-in methods
 * 
 * Collectors.toList()
 * Collectors.toSet()
 * Collectors.toMap()
 * */
public class Collect_Method_Demo {

	public static void main(String[] args) {
		System.out.println(Arrays.asList("apple", "banana", "banana", "kiwi", "orange").stream()
				.filter(fruit -> fruit.contains("a")).collect(Collectors.toList()));
		// [apple, banana, banana, orange]

		System.out.println(Arrays.asList("apple", "banana", "banana", "kiwi", "orange").stream()
				.filter(fruit -> fruit.contains("a")).collect(Collectors.toSet()));

		// [banana, orange, apple]
	}

}
