package com.example.demo;

import java.util.Arrays;

public class OneParamLambdaExpression {

	interface MultiplyByFive {
		int multBy5(int n);
	}

	interface AddTwoValues {
		public int addParameters(int a, int b);
	}

	// static MultiplyByFive iMultiplyByFive() {
	// return val -> val * 5;
	// }

	public static int sumUsingStreams(int[] arr) {
		return Arrays.stream(arr).sum();
	}

	public static int sumUsingStreams(Integer[] arr) {
		return Arrays.stream(arr).mapToInt(Integer::intValue).sum();
	}

	public static void main(String[] args) {
		MultiplyByFive obj = val -> val * 5;
		System.out.println(obj.multBy5(6));
		AddTwoValues obj1 = (a, b) -> a + b;
		System.out.println(obj1.addParameters(1879, 456));
		System.out.println("Sum using streams: " + sumUsingStreams(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println("Sum using streams: " + sumUsingStreams(new Integer[] { 1, 34, 23, 23, 45 }));
	}
}
