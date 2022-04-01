package com.gk.optionalDemo;

import java.util.List;

/*Java introduced a new class Optional in jdk8. 
 *It is a public final class and used to deal with NullPointerException 
 *in Java application. You must import java.util package to use this class. 
 *It provides methods which are used to check the presence of value for particular 
 *variable.*/
public class Optional_With_Stream_API_Example {

	public static Customer getCustomerByEmailId(String email) throws Exception {
		List<Customer> customers = CustomerDao.getAllCustomers();

		/*
		 * Stream findAny() returns an Optional (a container object which may or may not
		 * contain a non-null value) describing some element of the stream, or an empty
		 * Optional if the stream is empty.
		 */
		return customers.stream().filter(customer -> customer.getEmail().equals(email)).findAny()
				.orElseThrow(() -> new Exception("No Customers is present with this email"));
	}

	public static void main(String[] args) throws Exception {

		System.out.println(getCustomerByEmailId("virat@gmail.com"));
		/*
		 * Customer [id=2, name=Virat, email=virat@gmail.com, phoneNumbers=[7676767676,
		 * 6565656565]]
		 */

		getCustomerByEmailId("pqr");// No Customers is present with this email

	}

}
