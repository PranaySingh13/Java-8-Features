package com.gk;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * What is CompletableFuture ?
 * 
 * CompletableFuture is a new era of asynchronous programming.It's introduced as
 * a Java 8 Concurrency API improvement.
 * 
 * Asynchronous Computation in JAVA
 * 
 * The future interface was added in Java 5 to serve as a result of an
 * asynchronous computation, but it did not have any methods to combine these
 * computations or handle possible errors.
 * 
 * In Java8, the CompletableFuture class was introduced. Along with the Future
 * interface, it also implements the CompletionStage interface. This interface
 * defines the contract for an asynchronous computation step that can be
 * combined with other steps.
 * 
 * CompletableFuture is at the same time a building block and a framework with
 * different methods for composing, combining, executing asynchronous compuation
 * steps and handling errors.
 * 
 * Using Asynchronous programming we can write non blocking code where
 * concurrently we can run N no of task in separate thread without blocking main
 * thread.
 * 
 * When the task is complete, it notifies to the main thread (whether the task
 * was completed or failed).
 * 
 * Why CompletableFuture ?
 * 
 * There are different ways to implement asynchronous programming in Java using
 * any of the below mechanism for example we can use
 * Futures,ExecutorService,Callback Interfaces, Thread Pools etc.
 * 
 * It can not be manually completed.
 * 
 * Multiple Futures can not be chained together.
 * 
 * we can not combine multiple Futures together.
 * 
 * No Proper Exception Handling Mechanism.
 *
 */
public class Why_Not_Future {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);
		Future<List<Integer>> future1 = service.submit(() -> {
			// your doing api call
			System.out.println("Thread name: " + Thread.currentThread().getName());
			delay(1);
			return Arrays.asList(1, 2, 3, 4);
		});

		Future<List<Integer>> future2 = service.submit(() -> {
			// your doing api call
			System.out.println("Thread name: " + Thread.currentThread().getName());
			delay(1);
			return Arrays.asList(1, 2, 3, 4);
		});

		Future<List<Integer>> future3 = service.submit(() -> {
			// your doing api call
			System.out.println("Thread name: " + Thread.currentThread().getName());
			delay(1);
			System.out.println(10 / 0);
			return Arrays.asList(1, 2, 3, 4);
		});

		// We can run separate future object but can't chain multiple future objects.
		List<Integer> list1 = future1.get();
		List<Integer> list2 = future2.get();
		List<Integer> list3 = future3.get();
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);// no exception handling for future object

		// (future1*future2*future3).get() it's not possible.

		/**
		 * Here we can complete the thread manually and thread is not blocked.
		 */
		CompletableFuture<String> completableFuture = new CompletableFuture<>();
		completableFuture.get();
		completableFuture.complete("return some dummy data");

	}

	private static void delay(int min) {
		try {
			TimeUnit.MINUTES.sleep(min);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}
