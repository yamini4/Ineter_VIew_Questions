package com.example.streamexample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntermediateJavaStreamSolutions {
    public static void main(String[] args) {
        // Find numbers starting with digit 1
        List<Integer> numsList = List.of(10, 12, 23, 45, 17, 19, 88, 1, 134);
        numsList.stream().map(String::valueOf).filter(n -> n.startsWith("1")).forEach(System.out::println);

        List<String> strList = List.of("10", "12", "23", "45", "17", "19", "88", "1", "134");
        strList.stream().map(Integer::parseInt).forEach(n -> System.out.print(n * 2 + " "));

        // Convert int[] to List<Integer> (without using loops) int[]
        int[] values = { 2, 4, 6, 8, 10 };
        IntStream.of(values).forEach(System.out::println);
        Arrays.stream(values).forEach(System.out::println);

        System.out.println();
        List<Integer> marksList = List.of(10, 20, 35, 50, 75, 42, 18);
        marksList.stream().filter(n -> n > 20 && n < 70).peek(n -> System.out.printf("%d ", n))
                .collect(Collectors.toList());

        System.out.println();
        // Convert List<String> into List<Integer> (length of each) String[]
        List<String> words = List.of("Apple", "Banana", "Cherry", "Date");
        words.stream().map(e -> e.length()).forEach(System.out::println);

        System.out.println(words.stream().collect(Collectors.groupingBy(e -> e.length())));

        System.out.println();
    }
}
