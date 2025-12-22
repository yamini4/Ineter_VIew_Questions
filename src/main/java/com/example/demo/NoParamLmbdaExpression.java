package com.example.demo;

public class NoParamLmbdaExpression {
	public interface Hello {
		void printHello();
	}

	static Hello printHello() {
		return () -> System.out.println("Hello");
	}

	public static void main(String[] args) {
		Hello obj = printHello();
		obj.printHello();
	}
}
