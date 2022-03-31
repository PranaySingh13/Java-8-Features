package com.gk.functionalInterface.demo;

import java.util.function.Supplier;

/**
 * Supplier Functional Interface can be used in all contexts where there is no
 * input but an output is expected.
 * 
 * T get()
 * 
 * Consumer Interface and Supplier Interface works vice-versa.
 * 
 * Supplier is an anonymous function that accepts no argument and returns a
 * result.
 *
 */

//Traditional Approach
class SupplierDemoTradtional implements Supplier<String> {

	@Override
	public String get() {

		return "Hi! Pranay Singh";
	}

	public static void main(String[] args) {
		Supplier<String> supplier = new SupplierDemoTradtional();
		System.out.println(supplier.get());
	}

}

//With Lambda Expression
public class SupplierDemo {

	public static void main(String[] args) {
		Supplier<String> supplier = () -> "Hey! Pranay";
		System.out.println(supplier.get());
	}

}
