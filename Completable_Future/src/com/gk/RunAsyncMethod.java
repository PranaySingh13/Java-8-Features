package com.gk;

import java.io.File;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gk.dto.Employee;

/**
 * If we want to run some background task asynchronously and do not want to
 * return anything from that task, then use CompletableFuture.runAsync() method.
 * It takes a Runnable object and returns CompletableFuture<void>.
 *
 * CompletableFuture.runAsync(Runnable)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the {@link ForkJoinPool#commonPool()} after it runs the given
 * action.
 * 
 * CompletableFuture.runAsync(Runnable,Executor)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the given executor after it runs the given action.
 */
public class RunAsyncMethod {

	public Void saveEmployees(File jsonFile) throws InterruptedException, ExecutionException {

		/**
		 * What is ObjectMapper?
		 * 
		 * ObjectMapper is one of the most important class available in the Jackson
		 * library. It is used to read and write JSON data. It is responsible for
		 * reading data from or to POJO file
		 */
		ObjectMapper mapper = new ObjectMapper();
		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
				});
				// write logic t save list of employees to database
				System.out.println("Thread : " + Thread.currentThread().getName());
				// Thread : ForkJoinPool.commonPool-worker-1 i.e; global thread pool

				// employees.stream().forEach(System.out::println);

				System.out.println(employees.size());
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		return runAsync.get();

	}

	public Void saveEmployeesCustomExecutor(File jsonFile) throws InterruptedException, ExecutionException {

		/**
		 * What is ObjectMapper?
		 * 
		 * ObjectMapper is one of the most important class available in the Jackson
		 * library. It is used to read and write JSON data. It is responsible for
		 * reading data from or to POJO file
		 */
		ObjectMapper mapper = new ObjectMapper();
		Executor executor = Executors.newFixedThreadPool(5);
		CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> {
			try {
				List<Employee> employees = mapper.readValue(jsonFile, new TypeReference<List<Employee>>() {
				});
				// write logic t save list of employees to database
				System.out.println("Thread : " + Thread.currentThread().getName());
				// Thread : pool-1-thread-1 i.e; own thread pool

				// employees.stream().forEach(System.out::println);

				System.out.println(employees.size());
			} catch (Exception e) {
				e.printStackTrace();
			}

		}, executor);

		return runAsync.get();

	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		RunAsyncMethod runAsyncMethod = new RunAsyncMethod();
		runAsyncMethod.saveEmployees(new File("employees.json"));
		runAsyncMethod.saveEmployeesCustomExecutor(new File("employees.json"));
	}

}
