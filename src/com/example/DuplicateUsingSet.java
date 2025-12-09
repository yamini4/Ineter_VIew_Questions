package com.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


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

		Set<String> seen1 = new HashSet<>();

		Set<String> duplicates1 = Arrays.stream(arr).filter(n -> !seen1.add(n)).collect(Collectors.toSet());
		System.out.println("Duplicates:Using stream");
		duplicates1.forEach(System.out::println);

		// {red=4, green=4, blue=1}
		System.out.println(Arrays.stream(arr)
				.collect(Collectors.groupingBy(e -> e, Collectors.counting())));

		// {b=[blue], r=[red, red, red, red], g=[green, green, green, green]}
		System.out.println(Arrays.stream(arr)
				.collect(Collectors.groupingBy(e -> e.charAt(0))));
	}
}
