package com.gk.dao;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gk.dto.Employee;

public class EmployeeDao {

	public static List<Employee> fetchEmployees() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File("employees.json"), new TypeReference<List<Employee>>() {
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
