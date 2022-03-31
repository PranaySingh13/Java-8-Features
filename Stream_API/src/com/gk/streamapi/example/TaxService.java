package com.gk.streamapi.example;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

	public static List<Employee> evaluateTaxUsers(String input) {

		return (input.equalsIgnoreCase("tax"))
				? EmployeeDao.getEmployees().stream().filter(emp -> emp.getSalary() > 500000)
						.collect(Collectors.toList())
				: EmployeeDao.getEmployees().stream().filter(emp -> emp.getSalary() < 500000)
						.collect(Collectors.toList());

	}

	public static void main(String[] args) {

		System.out.println(evaluateTaxUsers("tax"));
		/*
		 * [Employee [id=1, name=Roshan, dept=IT, salary=600000], Employee [id=2,
		 * name=Bikash, dept=CIVIL, salary=900000], Employee [id=5, name=Prakash,
		 * dept=SOCIAL, salary=1200000]]
		 */

		System.out.println(evaluateTaxUsers("non tax"));
		// [Employee [id=4, name=Sourav, dept=CORE, salary=400000]]
	}

}
