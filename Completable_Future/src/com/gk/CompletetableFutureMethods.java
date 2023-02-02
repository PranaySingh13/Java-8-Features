package com.gk;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * complete(T value)
 * 
 * If not already completed, sets the value returned by {@link #get()} and
 * related methods to the given value.
 * 
 * cancel(boolean mayInterruptIfRunning)
 * 
 * If not already completed, completes this CompletableFuture with a
 * CancellationException.
 * 
 * completedFuture(U value)
 * 
 * Returns a new CompletableFuture that is already completed with the given
 * value.
 *
 */
public class CompletetableFutureMethods {

	public static CompletableFuture<String> calculateAsync() {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();

		List<String> list = new ArrayList<>();
		list.add("KK");
		list.add("PK");
		list.add("GK");

		Executors.newCachedThreadPool().submit(() -> {
			try {
				Thread.sleep(5000);
				String joinStr = String.join(",", list);
				System.out.println("Thread : " + Thread.currentThread().getName());
				// Thread : pool-1-thread-1

				/*
				 * If we comment this line then you will get
				 * java.util.concurrent.CancellationException.
				 */
				completableFuture.complete(joinStr);

				completableFuture.cancel(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		});
		return completableFuture;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture = CompletetableFutureMethods.calculateAsync();

		try {
			String result = completableFuture.get();
			System.out.println(result);// KK,PK,GK
			System.out.println(Thread.currentThread().getName());// main
			System.out.println("------------------------------------");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		CompletableFuture<String> completableFuture1 = CompletableFuture.completedFuture("Hello World");
		System.out.println(completableFuture1.get());
	}

}
