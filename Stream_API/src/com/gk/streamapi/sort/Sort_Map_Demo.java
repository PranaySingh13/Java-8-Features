package com.gk.streamapi.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.gk.streamapi.example.Employee;

public class Sort_Map_Demo {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("eight", 8);
		map.put("four", 4);
		map.put("ten", 10);
		map.put("two", 2);

		// Traditional Approach
		/*
		 * The java.util.Map.entrySet() method in Java is used to create a set out of
		 * the same elements contained in the map
		 */
		List<Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
		Collections.sort(entries, new Comparator<Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {

				return o1.getKey().compareTo(o2.getKey());
			}
		});

		for (Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("*************");

		// Lambda Expression
		Collections.sort(entries, (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
		for (Entry<String, Integer> entry : entries) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

		System.out.println("*************");

		// With Stream API
		// Comparing By Key
		map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(s -> System.out.println(s));

		System.out.println("*************");

		// Comparing By Value
		map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(s -> System.out.println(s));

		System.out.println("*************");

		// Comparing By Key Descending
		map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
				.forEach(s -> System.out.println(s));

		System.out.println("*************");

		// Comparing By Value Descending
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEach(s -> System.out.println(s));

		System.out.println("*************");

		// If Map Contains Key as Object
		// Lambda Expression
		Map<Employee, Integer> employeeMap = new TreeMap<>((o1, o2) -> (int) (o1.getSalary() - o2.getSalary()));
		employeeMap.put(new Employee(176, "Roshan", "IT", 600000), 60);
		employeeMap.put(new Employee(388, "Bikash", "CIVIL", 900000), 90);
		employeeMap.put(new Employee(470, "Bimal", "DEFENCE", 500000), 50);
		employeeMap.put(new Employee(624, "Sourav", "CORE", 400000), 40);
		employeeMap.put(new Employee(284, "Prakash", "SOCIAL", 1200000), 120);
		System.out.println(employeeMap);

		System.out.println("*************");

		// If Map Contains Key as Object
		// Stream API
		employeeMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName)))
				.forEach(s -> System.out.println(s));

		System.out.println("*************");

		// Comparing By Key Descending
		employeeMap.entrySet().stream()
				.sorted(Map.Entry.comparingByKey(Comparator.comparing(Employee::getName).reversed()))
				.forEach(s -> System.out.println(s));

		// We can Use here Map.Entry.comparingByValue if map contains value as object.

	}

}
