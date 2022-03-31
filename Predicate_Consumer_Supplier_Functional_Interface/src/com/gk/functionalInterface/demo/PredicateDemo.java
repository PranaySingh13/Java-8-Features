package com.gk.functionalInterface.demo;

import java.util.function.Predicate;

/**
 * 
 * Predicate Functional Interface used for conditional check. Where you think,
 * we can use these true/false returning functions in day to day programming we
 * should choose predicate
 * 
 * boolean test(T t)
 * 
 * Predicate is an anonymous function that accepts one argument and returns a
 * result.
 */

//Traditional Approach
class PredicateDemoTraditional implements Predicate<Integer> {

	@Override
	public boolean test(Integer t) {
		if (t % 2 == 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		Predicate<Integer> predicate = new PredicateDemoTraditional();
		System.out.println(predicate.test(8));// true
	}

}

//With Lambda Expression
public class PredicateDemo {

	public static void main(String[] args) {

		Predicate<Integer> predicate = t -> (t % 2 == 0) ? true : false;

		System.out.println(predicate.test(8));// true
		System.out.println(predicate.test(9));// false
	}

}
