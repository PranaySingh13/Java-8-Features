package com.gk.streamapi.map_reduce;

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

	}

}
