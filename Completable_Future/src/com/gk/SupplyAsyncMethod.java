package com.gk;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

import com.gk.dao.EmployeeDao;
import com.gk.dto.Employee;

/**
 * If we want to run some background task asynchronously and want to return
 * anything from that task, then use CompletableFuture.supplyAsync() method. It
 * takes a Supplier<T> and returns CompletableFuture<T> where T is the type of
 * the value obtained by calling the given supplier.
 * 
 * CompletableFuture.supplyAsync(Supplier<T>)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the {@link ForkJoinPool#commonPool()} with the value obtained by
 * calling the given Supplier.
 * 
 * CompletableFuture.supplyAsync(Supplier<T>,Executor)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the given executor with the value obtained by calling the given
 * Supplier.
 *
 */
public class SupplyAsyncMethod {

	public List<Employee> getEmployees() throws InterruptedException, ExecutionException {
		CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			// Thread : ForkJoinPool.commonPool-worker-1 i.e; global thread pool

			return EmployeeDao.fetchEmployees();
		});
		return completableFuture.get();
	}

	public List<Employee> getEmployeesCustomExecutor() throws InterruptedException, ExecutionException {
		Executor executor = Executors.newFixedThreadPool(5);
		CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			// Thread : pool-1-thread-1 i.e; own thread pool

			return EmployeeDao.fetchEmployees();
		}, executor);
		return completableFuture.get();
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SupplyAsyncMethod method = new SupplyAsyncMethod();
		List<Employee> employees1 = method.getEmployees();
		List<Employee> employeesCustomExecutor = method.getEmployeesCustomExecutor();
		System.out.println(employees1.size());
		System.out.println(employeesCustomExecutor.size());
	}
}
