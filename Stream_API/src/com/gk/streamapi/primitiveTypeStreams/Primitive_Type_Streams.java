package com.gk.streamapi.primitiveTypeStreams;

import java.util.Arrays;
import java.util.List;

/**
 * Streams primarily work with collections of objects and not primitive types.
 * 
 * Fortunately, to provide a way to work with the three most used primitive
 * types – int, long and double – the standard library includes three
 * primitive-specialized implementations: IntStream, LongStream, and
 * DoubleStream.
 * 
 * Primitive streams are limited mainly because of boxing overhead and because
 * creating specialized streams for other primitives isn't' that useful in many
 * cases.
 * 
 * To convert streams into primitive type stream we have methods:-
 * 
 * IntStream mapToInt(ToIntFunction<? super T> mapper);
 * 
 * LongStream mapToLong(ToLongFunction<? super T> mapper);
 * 
 * DoubleStream mapToDouble(ToDoubleFunction<? super T> mapper);
 *
 * IntStream flatMapToInt(Function<? super T, ? extends IntStream> mapper);
 * 
 * LongStream flatMapToLong(Function<? super T, ? extends LongStream> mapper);
 * 
 * DoubleStream flatMapToDouble(Function<? super T, ? extends DoubleStream>
 * mapper);
 */
public class Primitive_Type_Streams {

	public static void main(String[] args) {
		// Arithmetic Operations

		List<String> list = Arrays.asList("3", "10", "15", "6", "8");
		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).sum());// 42
		
		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).sum());// 42
		
		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).sum());// 42

		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).count());// 5

		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).min().getAsInt());// 3

		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).max().getAsInt());// 15

		System.out.println(list.stream().mapToInt(num -> Integer.parseInt(num)).average().getAsDouble());// 8.4

		list.stream().mapToInt(num -> Integer.parseInt(num)).sorted().forEach(System.out::println);
		// 3 6 8 10 15

		List<String> list1 = Arrays.asList("3.12", "10.12", "15.12", "6.12", "8.12");

		System.out.println(list1.stream().mapToDouble(num -> Double.parseDouble(num)).sum());// 42.599999999999994

		System.out.println(list1.stream().mapToDouble(num -> Double.parseDouble(num)).count());// 5

	}

}
