package com.gk.lambda.demo;

/**
 * The Lambda Expression is expression through which we can represent anonymous
 * function. Anonymous Functions are those who don't have any name or modifier.
 * 
 * Lambda Expression are only applicable for functional Interface.
 * 
 * Lambda Expression is just an anonymous(nameless) function. That means the
 * function which doesn’t have the name,return type and access modifiers.
 * 
 * If only one parameter is available and if the compiler can expect the type
 * then we can remove the type and parenthesis also.
 * 
 * Similar to method body lambda expression body also can contain multiple
 * statements.if more than one statements present then we have to enclose inside
 * within curly braces.if one statement present then curly braces are optional.
 * 
 * if one statement present then return keyword not required.
 *
 */

@FunctionalInterface
interface Calculator1 {
	void switchOn();
}

@FunctionalInterface
interface Calculator2 {

	void sum(int input1, int input2);
}

@FunctionalInterface
interface Calculator3 {

	int multiply(int input1, int input2);
}

/**
 * We don't need to implement Functional Interface we can represent in such way
 * with lambda exp.
 *
 */
public class CalculatorImpl {

	// Syntax of Lambda Expression
	// ()->{}

	public static void main(String[] args) {

		// Advantage Of Lambda Expression is to reduce code length.
		Calculator1 calculator1 = () -> System.out.println("Switch is On");

		calculator1.switchOn();

		// We don't need to give datatype of input in lambda function params it will
		// check by compiler
		Calculator2 calculator2 = (input1, input2) -> System.out.println(input1 + input2);

		calculator2.sum(4, 5);// 9

		// we don't need to write return keyword in lambda
		Calculator3 calculator3 = (input1, input2) -> input1 * input2;
		System.out.println(calculator3.multiply(4, 5));// 20

		Calculator3 calculator4 = (input1, input2) -> {
			if (input2 < input1)
				throw new RuntimeException("Input 2 is less than Input 1");
			else
				return input1 * input2;// Here we are using return keyword as there are multiple statements.
		};

		System.out.println(calculator4.multiply(4, 2));
	}

}
