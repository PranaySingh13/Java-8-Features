package com.gk;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.gk.dao.EmployeeDao;

/**
 * We can attach a callback to the CompletableFuture using thenApply(),
 * thenAccept() and thenRun() methods.
 * 
 * thenApply(Function)
 * 
 * thenAccept(Consumer)
 * 
 * thenRun(Runnable)
 * 
 * and many more...
 * 
 * Use case : Employee Training Reminder
 * 
 * 1. Get All Employees from database.
 * 
 * 2. Filter out all new joined employees.
 * 
 * 3. Check if the training activity is pending for employee.
 * 
 * 4. Get Employees email id.
 * 
 * 5. Send Reminder notification to employees.
 * 
 */
public class EmployeeReminderService {

	public CompletableFuture<Void> sendReminderToEmployee() {
		Executor executor1 = Executors.newFixedThreadPool(5);
		Executor executor2 = Executors.newFixedThreadPool(5);

		CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Fetch Employee:- " + Thread.currentThread().getName());
			return EmployeeDao.fetchEmployees();
		}, executor1).thenApplyAsync((employees) -> {
			System.out.println("Filter new joiner employees : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getNewJoiner()))
					.collect(Collectors.toList());
		}, executor1).thenApplyAsync((employees) -> {
			System.out.println("Filter Employees Training activity is pending : " + Thread.currentThread().getName());
			return employees.stream().filter(employee -> "TRUE".equals(employee.getLearningPending()))
					.collect(Collectors.toList());
		}, executor1).thenApplyAsync((employees) -> {
			System.out.println("Get Employees Email Id : " + Thread.currentThread().getName());
			return employees.stream().map(employee -> employee.getEmail()).collect(Collectors.toList());
		}, executor1).thenAcceptAsync((emails) -> {
			System.out.println("Send Reminder Email : " + Thread.currentThread().getName());
			emails.forEach(EmployeeReminderService::sendEmail);
		}, executor2);
		return completableFuture;
	}

	public static void sendEmail(String email) {
		System.out.println("sending training reminder email to : " + email);
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		EmployeeReminderService service = new EmployeeReminderService();
		service.sendReminderToEmployee().get();
	}

	/**
	 * If we use thenApply,thenAccept any of these kind of methods of
	 * CompletableFuture for method chaining all will execute in single thread even
	 * though we are using it concurrently they are not specifying our own executor
	 * so its taking from global thread pool.
	 * 
	 * Fetch Employee:- ForkJoinPool.commonPool-worker-1
	 * 
	 * Filter new joiner employees : ForkJoinPool.commonPool-worker-1
	 * 
	 * Filter Employees Training activity is pending :
	 * ForkJoinPool.commonPool-worker-1
	 * 
	 * Get Employees Email Id : ForkJoinPool.commonPool-worker-1
	 * 
	 * Send Reminder Email : ForkJoinPool.commonPool-worker-1
	 * 
	 * 
	 * What is the Multi-Threading concept here ?
	 * 
	 * As everything running on single thread,there is no use of thenApply or
	 * thenAsync Methods. For this to apply multithreading asynchronous approach,
	 * CompletableFuture Class has overloaded methods of these for ex:
	 * thenApplyAsync,thenAcceptAsync and many more which has Executors as
	 * parameters for own pool of thread.
	 * 
	 * Here we can see, separate thread is associate with every completablefuture
	 * object Fetch Employee:- pool-1-thread-1
	 * 
	 * Filter new joiner employees : pool-1-thread-2
	 * 
	 * Filter Employees Training activity is pending : pool-1-thread-3
	 * 
	 * Get Employees Email Id : pool-1-thread-4
	 * 
	 * Send Reminder Email : pool-2-thread-1
	 * 
	 * We can have N multiple Executors based on processor but it is not
	 * recommended.
	 *
	 */

}
