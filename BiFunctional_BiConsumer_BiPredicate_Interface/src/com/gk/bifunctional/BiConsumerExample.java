package com.gk.bifunctional;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/*
 * @FunctionalInterface
 * public interface Consumer<T> {
 * void accept(T t);
 * }
 * 
 * @FunctionalInterface
 * public interface BiConsumer<T,U> {
 * void accept(T t,U u);
 * }
 * 
 * Note:- T and U are the first two parameters.
 * 
 * When to use Consumer Interface and BiConsumer Interface ?
 * 
 * The main difference between two interface is that use the consumer interface whenever 
 * you want to take one argument and returning no result when we want to 
 * take two argument and returning no result we go for BiConsumer Interface.
 * */
public class BiConsumerExample implements BiConsumer<String, Integer> {

	@Override
	public void accept(String i1, Integer i2) {
		System.out.println("Input 1: " + i1 + " Input2: " + i2);
	}

	public static void main(String[] args) {
		BiConsumer<String, Integer> biConsumer1 = new BiConsumerExample();
		biConsumer1.accept("Pranay Singh", 100);
		// Input 1: Pranay Singh Input2: 100

		BiConsumer<String, Integer> biConsumer2 = new BiConsumer<String, Integer>() {

			@Override
			public void accept(String i1, Integer i2) {
				System.out.println("Input 1: " + i1 + " Input2: " + i2);
			}
		};
		biConsumer2.accept("Pranay Singh", 100);
		// Input 1: Pranay Singh Input2: 100

		BiConsumer<String, Integer> biConsumer3 = (i1, i2) -> System.out.println("Input 1: " + i1 + " Input2: " + i2);
		biConsumer3.accept("Pranay Singh", 100);
		// Input 1: Pranay Singh Input2: 100

		// RealTime Use case
		Map<String, Integer> map = new HashMap<>();
		map.put("Pranay", 100);
		map.put("Dipti", 80);
		map.put("Apoorva", 110);
		map.forEach((i1, i2) -> System.out.println("Input 1: " + i1 + " Input2: " + i2));
		/*
		 * Input 1: Pranay Input2: 100
		 * 
		 * Input 1: Apoorva Input2: 110
		 * 
		 * Input 1: Dipti Input2: 80
		 */
	}

}
