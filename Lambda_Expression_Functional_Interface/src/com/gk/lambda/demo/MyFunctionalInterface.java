package com.gk.lambda.demo;

/**
 * The interface who contains only one abstract method but can have multiple
 * default and static methods is called Functional Interface. Example:-
 * Runnable, Callable, Comparable, Comparator etc.
 *
 */

@FunctionalInterface
public interface MyFunctionalInterface {

	// abstract Method
	void m1();

	default void m2() {
		System.out.println("Default Method 1");
	}

	default void m3() {
		System.out.println("Default Method 2");
	}

	static void m4() {
		System.out.println("Static Method");
	}

}
