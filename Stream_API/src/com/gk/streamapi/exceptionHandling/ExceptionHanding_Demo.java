package com.gk.streamapi.exceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExceptionHanding_Demo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("44", "373", "xyz");

		List<Integer> intList = list.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
		System.out.println(intList);// [44, 373, 123]

		List<Integer> intList1 = list.stream().map(Integer::parseInt).collect(Collectors.toList());
		System.out.println(intList1);// [44, 373, 123]

		list.forEach(s -> System.out.println(Integer.parseInt(s)));
		// NumberFormatException: For input string: "xyz"

		// Not Recommended Way Approach 1 Try Catch Block
		list.forEach(s -> {
			try {
				System.out.println(Integer.parseInt(s));
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		});

		/*
		 * 44 373 Exception: For input string: "xyz"
		 */

		/*
		 * Not Recommended Way Approach 2 To create a method to handle exception and use
		 * it as method reference.
		 */

		list.forEach(ExceptionHanding_Demo::printList);

		/*
		 * 44 373 Exception: For input string: "xyz"
		 */

		/*
		 * Not Recommended Way Approach 3 To create a Consumer method to handle
		 * exception and which is returning consumer object use it as method
		 */
		list.forEach(handleExceptionIfAny(s -> System.out.println(Integer.parseInt(s))));
		/*
		 * 44 373 Exception: For input string: "xyz"
		 */

		/**
		 * But this method handleExceptionIfAny will fail to handle exception if we have
		 * list of other primitive data type other than string.
		 * 
		 * 
		 * Best Way
		 * 
		 * Therefore, We will Create a consumer method which is type generic to handle
		 * Exception.
		 */

		list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), NumberFormatException.class));
		/*
		 * 44 373 Exception: For input string: "xyz"
		 */

		list.forEach(handleGenericException(s -> System.out.println(Integer.parseInt(s)), ArithmeticException.class));
		/*
		 * 44 373 Exception: For input string: "xyz"
		 * 
		 * Exception in thread "main" java.lang.ClassCastException: Cannot cast
		 * java.lang.NumberFormatException to java.lang.ArithmeticException
		 * 
		 * Therefore we have to give correct exception class.
		 * 
		 */

		// Handling Exception for Checked Exception
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		list1.forEach(handleCheckedExceptionConsumer(i -> {
			Thread.sleep(i);
			System.out.println(i);
		}));

	}

	/*
	 * For Checked Exception
	 * 
	 * Type Generic as Target.
	 * 
	 * It will have one argument of functional interface we created to handle
	 * checked exception of the consumer of any type.
	 * 
	 */
	static <Target> Consumer<Target> handleCheckedExceptionConsumer(
			CheckedExceptionHandlerConsumer<Target, Exception> handlerConsumer) {
		return obj -> {
			try {
				// If No Checked Exception is present
				handlerConsumer.accept(obj);
			} catch (Exception e) {
				// Checked exception is present
				throw new RuntimeException(e);
			}
		};
	}

	/*
	 * For Unchecked Exception
	 * 
	 * Type Generic as Target.
	 * 
	 * An Exception Object ExObj .
	 * 
	 * It will have two arguments one is the consumer of any type and second is
	 * Which kind of exception class we are handling
	 * 
	 * Class<ExObj> because ExObj extends Exception.
	 */
	static <Target, ExObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer,
			Class<ExObj> exObjClass) {
		return obj -> {
			try {
				targetConsumer.accept(obj);
			} catch (Exception e) {
				// We have to validate that the exception which our application is throwing is
				// correct or not.
				try {
					// Correct Exception
					ExObj exObj = exObjClass.cast(e);
					System.out.println("Exception: " + exObj.getMessage());
				} catch (ClassCastException ecx) {
					// In-Correct Exception
					throw ecx;
				}
			}
		};

	}

	static Consumer<String> handleExceptionIfAny(Consumer<String> payload) {
		return obj -> {
			try {
				payload.accept(obj);
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
			}
		};
	}

	public static void printList(String s) {
		try {
			System.out.println(Integer.parseInt(s));
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}

}
