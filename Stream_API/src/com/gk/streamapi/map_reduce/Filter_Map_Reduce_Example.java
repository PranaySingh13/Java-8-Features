package com.gk.streamapi.map_reduce;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Evaluate average salary of grade A employees
public class Filter_Map_Reduce_Example {

	public static void main(String[] args) {

		// 1. getEmployee whose grade is A
		// 2. getSalary of grade A employees
		// 3. convert salary stream into doublestream
		// 4. call average method of doublestream
		double averageSalaryGradeAEmp = EmployeeDao.getAllEmployees().stream()
				.filter(emp -> emp.getGrade().equalsIgnoreCase("A")).map(emp -> emp.getSalary()).mapToDouble(i -> i)
				.average().getAsDouble();
		System.out.println(averageSalaryGradeAEmp);// 850000.0

		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(4, 5, 6);
		List<Integer> list3 = Arrays.asList(7, 8, 9);

		int list1sum = list1.stream().reduce(Integer::sum).get();
		int list2sum = list2.stream().reduce(Integer::sum).get();
		int list3sum = list3.stream().reduce(Integer::sum).get();

		int maximumSumOfAllList = Arrays.asList(list1sum, list2sum, list3sum).stream().mapToInt(i -> i).max().getAsInt();
		System.out.println(maximumSumOfAllList);
	}

}
