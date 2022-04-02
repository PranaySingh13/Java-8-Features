package com.gk.streamapi.parallelStreams;

import java.util.List;

//Evaluate average salary of employees
public class Parallel_Stream_Example {

	public static void main(String[] args) {

		List<Employee> employees = EmployeeDao.getAllEmployees();

		long start = System.currentTimeMillis();
		// 1. Get Employee Salary Stream
		// 2. convert stream into doublestream
		// 3. call average function of doublestream
		double averageSalaryWithStream = employees.stream().map(Employee::getSalary).mapToDouble(i -> i).average()
				.getAsDouble();
		System.out.println(averageSalaryWithStream);
		long end = System.currentTimeMillis();
		System.out.println("Plain Stream takes time: " + (end - start) + " ms.");
		// Plain Stream takes time: 165 ms.

		long start1 = System.currentTimeMillis();
		double averageSalaryWithParallelStream = employees.parallelStream().map(Employee::getSalary).mapToDouble(i -> i)
				.average().getAsDouble();
		System.out.println(averageSalaryWithParallelStream);
		long end1 = System.currentTimeMillis();
		System.out.println("Parallel Stream takes time: " + (end1 - start1) + " ms.");
		// Parallel Stream takes time: 9 ms.
	}

}
