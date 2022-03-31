package com.gk.streamapi.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Filter Method is used for conditional check
 * 
 * Stream<T> filter(Predicate<? super T> predicate);
 * 
 *  It takes Predicate reference as an argument. 
 *  
 *  Predicate is a functional interface. 
 *  
 *  So, you can also pass lambda expression here.
 *  
 *  This method takes predicate as an argument and 
 *  returns a new stream of consisting of resulted elements.
 * 
 * */
public class Filter_Method_Demo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Dell");
		list.add("Apple");
		list.add("Ajio");
		list.add("Lenovo");
		list.add("Microsoft");

		// Traditional Approach
		for (String s : list) {
			if (s.startsWith("A"))
				System.out.print(s + " ");// Apple Ajio
		}

		System.out.println();

		// With Lambda Expression
		list.stream().filter(s -> s.startsWith("A")).forEach(t -> System.out.print(t + " "));
		// Apple Ajio

		System.out.println();

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Dell");
		map.put(2, "Apple");
		map.put(3, "Lenovo");
		map.put(4, "Microsoft");

		map.entrySet().stream().filter(s -> s.getKey() % 2 == 0).forEach(obj -> System.out.print(obj + " "));
		//2=Apple 4=Microsoft 
	}

}
