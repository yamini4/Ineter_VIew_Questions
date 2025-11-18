package com.example;

import java.util.HashSet;
import java.util.Set;

public class DuplicateUsingSet {
	public static void main(String[] args) {

		String[] arr = { "red", "green", "red", "blue", "green", "red", "green", "red", "green" };

		Set<String> seen = new HashSet<>();
		Set<String> duplicates = new HashSet<>();

		for (String s : arr) {
			if (!seen.add(s)) {
				duplicates.add(s);
			}
		}
		System.out.println("Duplicates:Using forEach");

		duplicates.forEach(System.out::println);

	}
}
