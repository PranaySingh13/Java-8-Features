package com.gk.streamapi.map_flatmap;

import java.util.List;
import java.util.stream.Collectors;

/*Java 8 Stream API provides map() and flatmap() method
 * Both these methods are intermediate methods and returns another stream
 * as part of the output.
 * 
 * map() method
 * It processes stream of values.
 * It does only mapping.
 * It is used only for data transformation(mapping).
 * Data Transformation: From Stream to Stream.
 * map() method takes Stream<T> as input and return Stream<R>
 * 
 * Stream<R> map(Stream<T> input){}
 * 
 * Use of Map Method
 * When mapper function produces single value for each input value.
 * Hence it is also called One-To-One Mapping.
 * 
 * 
 * 
 * flatmap() method
 * 
 * It processes stream of stream of values.
 * It is used for data transformation(mapping) and flattering.
 * flatmap()=map()+flattering.
 * 
 * Data Transformation: From Stream<Stream> to Stream.
 * flatMap() method takes Stream<Stream<T>> as input and return Stream<R>.
 * 
 * Stream<R> flatMap(Stream<Stream<T>> input){}
 * 
 * Use of flatmap Method
 * When mapper function produces multiple value for each input value.
 * Hence it is also called One-To-Many Mapping.
 * 
 * Flattening is Converting Stream of Streams into combine a new Single Stream.
 * */

public class Map_Vs_Flatmap_Method_Example {

	public static void main(String[] args) {

		List<Customer> customers = CustomerDao.getAllCustomers();

		// With Stream API
		// List<Customer> convert to List<String> -> Data Transformation
		// Mapping: customer->customer.getEmail() -> One-To-One Mapping
		List<String> customersEmails = customers.stream().map(customer -> customer.getEmail())
				.collect(Collectors.toList());
		System.out.println(customersEmails);
		// [dhoni@gmail.com, virat@gmail.com, rohit@gmail.com, sachin@gmail.com]

		List<List<String>> customersPhoneNumers = customers.stream().map(customer -> customer.getPhoneNumbers())
				.collect(Collectors.toList());
		System.out.println(customersPhoneNumers);

		/*
		 * [[9898989898, 8787878787], [7676767676, 6565656565], [5454545454,
		 * 4343434343], [3232323232, 2121212121]]
		 * 
		 * Here we are getting results as List of Stream of Streams.It means data is in
		 * non- flattend structure.
		 * 
		 * Our desired output is to get List<String> of phoneNumbers not
		 * List<List<String>>. Therefore, We can't use map() method here.
		 */

		// With Stream API
		// List<Customer> convert to List<String> -> Data Transformation
		// Mapping: customer->customer.getPhoneNumbers() -> One-To-Many Mapping
		List<String> phoneNumbers = customers.stream().flatMap(customer -> customer.getPhoneNumbers().stream())
				.collect(Collectors.toList());
		System.out.println(phoneNumbers);

		/*
		 * [9898989898, 8787878787, 7676767676, 6565656565, 5454545454, 4343434343,
		 * 3232323232, 2121212121]
		 * 
		 * Here we are getting results as List of Stream.It means data is in flattend
		 * structure i.e; into a single stream.
		 */

		/*
		 * It works well, but the code doesn't look elegant. I'd really like to replace
		 * it with code that uses method references which usually looks more readable
		 * and more compact.
		 * 
		 * You can split the flatMap call into two calls - map and flatMap - each
		 * receiving a method reference:
		 */
		List<String> phoneNumbersList = customers.stream().map(Customer::getPhoneNumbers).flatMap(List::stream)
				.collect(Collectors.toList());
		System.out.println(phoneNumbersList);

		// The joining() method of Collectors Class, in Java, is used to join various
		// elements of a character or string array into a single string object.
		String str = "select * from CUSTOMERS where id in ("
				+ customers.stream().map(Customer::getId).map(Object::toString).collect(Collectors.joining(", ")) + ")";
		System.out.println(str);
		// select * from CUSTOMERS where id in (1, 2, 1, 1)

	}

}
