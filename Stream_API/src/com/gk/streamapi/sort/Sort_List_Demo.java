package com.gk.streamapi.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.gk.streamapi.example.Employee;
import com.gk.streamapi.example.EmployeeDao;

public class Sort_List_Demo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Dell");
		list.add("Apple");
		list.add("Lenovo");
		list.add("Microsoft");

		// Traditional Approach
		Collections.sort(list);
		System.out.println(list);// [Apple, Dell, Lenovo, Microsoft]
		Collections.reverse(list);
		System.out.println(list);// [Microsoft, Lenovo, Dell, Apple]

		// With Stream API and Lambda
		list.stream().sorted().forEach(s -> System.out.print(s + " "));
		// Apple Dell Lenovo Microsoft

		System.out.println();
		// Sorted in Descending Order
		// For Providing Custom Sorting Logic we have Comparator Interface methods as an
		// arguments
		list.stream().sorted(Comparator.reverseOrder()).forEach(s -> System.out.print(s + " "));
		// Microsoft Lenovo Dell Apple

		System.out.println();

		List<Employee> empList = EmployeeDao.getEmployees();

		// Traditional Approach
		Collections.sort(empList, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {

				return (int) (o1.getSalary() - o2.getSalary());// ascending
				// return (int) (o2.getSalary() - o1.getSalary());// descending
			}

		});
		System.out.println(empList);

		// With Lambda Expression
		if (!empList.isEmpty())
			Collections.sort(empList, (e1, e2) -> (int) (e1.getSalary() - e2.getSalary()));// ascending

		System.out.println(empList);

		// With Stream API Lambda Expression Sorting by Salary
		empList.stream().sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary()))
				.forEach(e -> System.out.println(e));

		// With Stream API Optimized Lambda Expression Sorting by Department
		empList.stream().sorted(Comparator.comparing(emp -> emp.getDept())).forEach(e -> System.out.println(e));

		// With Stream API with Method reference Sorting by Name
		empList.stream().sorted(Comparator.comparing(Employee::getName)).forEach(e -> System.out.println(e));
	}

}
