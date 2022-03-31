package com.gk.functionalInterface.demo;

import java.util.function.Consumer;

/**
 * Consumer<T> Functional Interface is an in built functional interface
 * introduced in java8. Consumer can be used in all contexts where an object
 * need to be consumed. That is taken as input, and some operation is to be
 * performed on the object without returning any result.
 * 
 * void accept(T t)
 * 
 * Consumer is an anonymous function that accepts one argument and returns no
 * result.
 */

//Traditional Approach
class ConsumerDemoTraditional implements Consumer<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.print("Print: " + t + " ");
	}

	public static void main(String[] args) {

		Consumer<Integer> consumer = new ConsumerDemoTraditional();
		consumer.accept(10);// Print: 10

	}

}

//With Lambda Expression
public class ConsumerDemo {

	public static void main(String[] args) {

		Consumer<Integer> consumer = t -> System.out.print("Print: " + t + " ");

		consumer.accept(10);// Print: 10

	}

}
