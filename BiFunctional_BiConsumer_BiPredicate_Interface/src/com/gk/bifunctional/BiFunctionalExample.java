package com.gk.bifunctional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * @FunctionalInterface
 * public interface Function<T,R> {
 * R apply(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BiFunction<T,U,R> {
 * R apply(T t,U u);
 * }
 * 
 * Note:- T and U are the first two parameters and R is result.
 * 
 * When to use Functional Interface and BiFunctional Interface ?
 * 
 * The main difference between two interface is that use the funtional interface whenever 
 * you want to take one argument and do some business logic and return some result. But when we want to 
 * take two argument and return some result after some business logic we go for BiFunctional Interface.
 * */
public class BiFunctionalExample implements BiFunction<List<Integer>, List<Integer>, List<Integer>> {

	@Override
	public List<Integer> apply(List<Integer> list1, List<Integer> list2) {

		return Stream.of(list1, list2).flatMap(List::stream).distinct().collect(Collectors.toList());
	}

	public static void main(String[] args) {

		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction1 = new BiFunctionalExample();
		List<Integer> list1 = Stream.of(1, 3, 4, 6, 7, 9, 19).collect(Collectors.toList());
		List<Integer> list2 = Stream.of(11, 3, 43, 6, 7, 19).collect(Collectors.toList());
		System.out.println("Traditional Apporach:- " + biFunction1.apply(list1, list2));
		// Traditional Apporach:- [1, 3, 4, 6, 7, 9, 19, 11, 43]

		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction2 = new BiFunction<List<Integer>, List<Integer>, List<Integer>>() {

			@Override
			public List<Integer> apply(List<Integer> l1, List<Integer> l2) {
				// TODO Auto-generated method stub
				return Stream.of(l1, l2).flatMap(List::stream).distinct().collect(Collectors.toList());
			}
		};
		System.out.println("Anonymous Approach:- " + biFunction2.apply(list1, list2));

		BiFunction<List<Integer>, List<Integer>, List<Integer>> biFunction3 = (l1, l2) -> {
			return Stream.of(l1, l2).flatMap(List::stream).distinct().collect(Collectors.toList());
		};

		Function<List<Integer>, List<Integer>> sortedFunction = (lists) -> lists.stream().sorted()
				.collect(Collectors.toList());

		System.out.println("Lambda Expression Approach:- " + biFunction3.andThen(sortedFunction).apply(list1, list2));
		// Lambda Expression Approach:- [1, 3, 4, 6, 7, 9, 11, 19, 43]

		// RealTime Use case
		Map<String, Integer> map = new HashMap<>();
		map.put("Pranay", 100);
		map.put("Dipti", 80);
		map.put("Apoorva", 110);

		BiFunction<String, Integer, Integer> increaseSalaryBiFunction = (key, value) -> value + 50;
		map.replaceAll(increaseSalaryBiFunction);
		System.out.println(map);// {Pranay=150, Apoorva=160, Dipti=130}
	}

}
