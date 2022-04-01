package com.gk.streamapi.map_flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerDao {

	public static List<Customer> getAllCustomers() {

		// The Stream.of is used to create sequential streams for the given elements.
		return Stream
				.of(new Customer(1, "Dhoni", "dhoni@gmail.com", Arrays.asList("9898989898", "8787878787")),
						new Customer(2, "Virat", "virat@gmail.com", Arrays.asList("7676767676", "6565656565")),
						new Customer(1, "Rohit", "rohit@gmail.com", Arrays.asList("5454545454", "4343434343")),
						new Customer(1, "Sachin", "sachin@gmail.com", Arrays.asList("3232323232", "2121212121")))
				.collect(Collectors.toList());
	}

}
