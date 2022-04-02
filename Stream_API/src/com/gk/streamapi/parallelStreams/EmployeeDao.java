package com.gk.streamapi.parallelStreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDao {

	public static List<Employee> getAllEmployees() {

		List<Employee> employees = new ArrayList<Employee>();
		for (int i = 1; i <= 1000; i++) {
			employees.add(new Employee(i, "employee" + i, "A", Double.valueOf(new Random().nextInt(1000 * 100))));
		}

		return employees;
	}

}
