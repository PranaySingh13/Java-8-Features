package com.gk.streamapi.map_reduce;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDao {

	public static List<Employee> getAllEmployees() {

		return Stream
				.of(new Employee(1, "Pranay", "A", 900000.00), new Employee(1, "Ashutosh", "A", 800000.00),
						new Employee(1, "Abhishek", "B", 300000.00), new Employee(1, "Amit", "c", 100000.00))
				.collect(Collectors.toList());
	}

}
