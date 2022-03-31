package com.gk.streamapi.example;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

	public static List<Employee> getEmployees() {
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1, "Roshan", "IT", 600000));
		empList.add(new Employee(2, "Bikash", "CIVIL", 900000));
		empList.add(new Employee(3, "Bimal", "DEFENCE", 500000));
		empList.add(new Employee(4, "Sourav", "CORE", 400000));
		empList.add(new Employee(5, "Prakash", "SOCIAL", 1200000));

		return empList;
	}

}
