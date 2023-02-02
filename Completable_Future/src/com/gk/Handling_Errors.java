package com.gk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFuture provides three methods to handle them: handle(),
 * whenComplete(), and exceptionally().
 * 
 *
 */
public class Handling_Errors {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		String name1 = null;
		CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
			if (name1 == null) {
				throw new RuntimeException("Computation Error!!!");
			}
			return "Hello," + name1;
		}).handle((s, t) -> s != null ? s : "Hello, Stranger !!");
		System.out.println(completableFuture.get());// Hello, Stranger !!

		String name2 = "Sean";
		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> {
			if (name2 == null) {
				throw new RuntimeException("Computation Error!!!");
			}
			return "Hello," + name2;
		});

		try {
			System.out.println(completableFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			System.out.println(e.getMessage());
		}
	}

}
