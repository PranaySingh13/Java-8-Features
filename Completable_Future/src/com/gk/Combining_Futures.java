package com.gk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Combining Futures using CompletableFuture in Java 8
 * 
 * The best part of the CompletableFuture API is the ability to combine
 * CompletableFuture instances in a chain of computation steps.
 * 
 * The result of this chaining is itself a CompletableFuture that allows further
 * chaining and combining. This approach is in functional language.
 * 
 * Combining is a process where a BiFunction/BiConsumer is used for combining
 * the results from two stages into one, whereas composing is the process where
 * the result of the first stage is fed into the second stage to get a composite
 * result.
 *
 *
 */
public class Combining_Futures {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<String> completableFuture1 = CompletableFuture.supplyAsync(() -> "Hello,")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World !"));
		System.out.println(completableFuture1.get());// Hello, World !

		CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "Hello,")
				.thenCombine(CompletableFuture.supplyAsync(() -> "World..."), (s1, s2) -> s1 + s2);

		System.out.println(completableFuture2.get());// Hello,World...

		CompletableFuture.supplyAsync(() -> "Hello,").thenAcceptBoth(
				CompletableFuture.supplyAsync(() -> "World!!!!..."), (s1, s2) -> System.out.println(s1 + s2));// Hello,World!!!!...

	}
}
