package com.example;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CalculateFrequencyUsingStreams {
    public static void main(String[] args) {
        String str = "hello world---------yamini garudachalam";
        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(result);

        List<Character> result1 = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("======================================================================");
        result1.forEach(System.out::println);

    }
}
