package com.gk.streamapi.parallelStreams;

import java.util.stream.IntStream;

/**
 * What is Java Parallel Streams ?
 * 
 * Java Parallel Streams is a feature of Java 8. It Meant for utilizing multiple
 * cores of the processor.
 * 
 * Normally any java code has one stream of processing, where it is executed
 * sequentially. Whereas by using parallel streams, we can divide the code into
 * multiple streams that are executed in parallel on separate cores and the
 * final result is the combination of the individual outcomes.
 * 
 * Note:- The Order of execution, however, is not under our control.
 * 
 * Response Wise Parallel Stream is better than Plain Stream as they take less
 * execution time .
 * 
 * Important:- Parallel Stream are beneficial when the order of execution is not
 * important.
 */
public class Parallel_Stream_Demo {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();
		IntStream.range(1, 100).forEach(System.out::println);
		long end = System.currentTimeMillis();
		System.out.println("Plain Stream takes time: " + (end - start));

		long start1 = System.currentTimeMillis();
		IntStream.range(1, 100).parallel().forEach(System.out::println);
		long end1 = System.currentTimeMillis();
		System.out.println("Parallel Stream takes time: " + (end1 - start1));

		IntStream.range(1, 10).forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.println("Thread : " + Thread.currentThread().getName() + " : " + x);
		});

		/*
		 * We Can Observe that in plain stream Thread are running sequentially but in
		 * parallel stream random thread are running.
		 */

	}

}
