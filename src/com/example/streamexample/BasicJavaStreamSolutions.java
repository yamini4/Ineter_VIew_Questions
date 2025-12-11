package com.example.streamexample;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BasicJavaStreamSolutions {
    public static void main(String[] args) {
        // Given an int[] array, return even numbers
        int[] numbers = { 10, 15, 20, 25, 30, 33, 40 };
        Arrays.stream(numbers).filter(n -> n % 2 == 0).forEach(System.out::println);

        // Convert a list of strings to uppercase
        String[] names = { "yamini", "syed", "akhil", "rajesh" };
        Arrays.stream(names).map(n -> n.toUpperCase()).forEach(System.out::println);

        // Count strings starting with letter 'A'
        String[] words = { "Apple", "Banana", "Avocado", "Apricot", "Mango", "almond" };
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(n -> n.startsWith("A"))));
        System.out.println(Arrays.stream(words).collect(Collectors.groupingBy(n -> n.startsWith("A"))).size());

        // Find maximum value in an int[] using Streams
        int[] values = { 12, 99, 54, 7, 34, 88, 120, 3 };
        System.out.println(Arrays.stream(values).max().orElse(0));

        // Remove duplicate elements from int[]
        int[] listWithDup = { 1, 2, 3, 2, 4, 5, 1, 6, 4 };
        Arrays.stream(listWithDup).distinct().forEach(n -> System.out.print(n + " "));

        System.out.println();
        // Sort int[] in descending order
        List<Integer> nums = List.of(5, 12, 3, 19, 7, 1, 25, 9);
        nums.stream().sorted(Comparator.reverseOrder()).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Check if any number > 50
        List<Integer> marks = List.of(10, 20, 35, 42, 18, 55, 47, 67, 89);
        marks.stream().filter(n -> n > 50).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Convert int[] values to their squares
        int[] digits = { 2, 4, 6, 8, 10 };

        Arrays.stream(digits).map(n -> n * n).forEach(n -> System.out.print(n + " "));
        System.out.println();

        // Find first element in an int[] stream
        int[] valuesArr = { 100, 200, 300, 400 };
        System.out.println(Arrays.stream(valuesArr).findFirst().orElse(0));
        // peek -
        Arrays.stream(valuesArr).filter(e -> e > 200).peek(n -> System.out.print(2 * n + " = "))
                .forEach(System.out::println);

        Stream.of("one", "two", "three", "four", "five")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());

        // Count total number of elements in int[]
        List<Integer> arr = List.of(10, 20, 30, 40, 50, 60);
        System.out.println(arr.stream().count());

    }
}
