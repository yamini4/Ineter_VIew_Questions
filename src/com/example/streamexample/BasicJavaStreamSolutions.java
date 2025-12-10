package com.example.streamexample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Arrays.stream(listWithDup).distinct().forEach(System.out::print);
        ;
    }
}
