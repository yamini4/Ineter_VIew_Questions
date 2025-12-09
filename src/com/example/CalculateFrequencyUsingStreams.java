package com.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

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

        Map<String, Integer> charMap = Map.of("yamini", 3, "yamini2", 1, "yamini3", 2);

        Set<String> keyList = charMap.keySet();
        System.out.println(keyList);

        for (Map.Entry<String, Integer> charMapVal : charMap.entrySet()) {
            String keyValue = charMapVal.getKey();
            if (charMapVal.getKey().contains("2")) {
                System.out.println("Key: " + keyValue + ", Value: " + charMapVal.getValue());
            }
        }

        charMap.entrySet().stream().map(Map.Entry::getValue).forEach(System.out::println);

        charMap.entrySet().stream().filter(value -> value.getValue() > 2).forEach(System.out::println);

        // ----------------------------------------------------
        charMap.entrySet().stream().filter(key -> "yamini".equals(key.getKey())).map(Map.Entry::getKey)
                .forEach(System.out::println);
        System.out.println("======================================================================");

        MultiValuedMap<String, String> multiMap = new ArrayListValuedHashMap<>();

        multiMap.put("A", "Apple");
        multiMap.put("A", "Ant");
        multiMap.put("B", "Ball");

        System.out.println(multiMap.get("A"));
    }
}
