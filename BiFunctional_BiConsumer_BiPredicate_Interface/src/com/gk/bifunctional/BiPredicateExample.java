package com.gk.bifunctional;

import java.util.function.BiPredicate;

/*
 * @FunctionalInterface
 * public interface Predicate<T> {
 * boolean test(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BiPredicate<T,U> {
 * boolean test(T t,U u);
 * }
 * 
 * Note:- T and U are the first two parameters.
 * 
 * When to use Predicate Interface and BiPredicate Interface ?
 * 
 * The main difference between two interface is that use the consumer interface whenever 
 * you want to take one argument and returning some boolean result when we want to 
 * take two argument and returning some boolean result we go for BiConsumer Interface.
 * */
public class BiPredicateExample implements BiPredicate<String, String> {

	@Override
	public boolean test(String s1, String s2) {

		return s1.equals(s2);
	}

	public static void main(String[] args) {

		BiPredicate<String, String> biPredicate1 = new BiPredicateExample();
		System.out.println("Traditional Approach: " + biPredicate1.test("Pranay", "PRANAY"));
		// Traditional Approach: false

		BiPredicate<String, String> biPredicate2 = new BiPredicate<String, String>() {

			@Override
			public boolean test(String t, String u) {
				// TODO Auto-generated method stub
				return t.equals(u);
			}
		};
		System.out.println("Anonymous Approach: " + biPredicate2.test("Pranay", "PRANAY"));
		// Anonymous Approach: false

		BiPredicate<String, String> equalsBiPredicate = (s1, s2) -> s1.equals(s2);
		BiPredicate<String, String> lengthBiPredicate = (s1, s2) -> s1.length() == s2.length();

		System.out.println(lengthBiPredicate.and(equalsBiPredicate).test("Pranay", "Pranay"));
		// true

		System.out.println(lengthBiPredicate.or(equalsBiPredicate).test("abc", "Pranay"));
		// false

		System.out.println(equalsBiPredicate.test("abc", "abc"));
		// true
	}

}
