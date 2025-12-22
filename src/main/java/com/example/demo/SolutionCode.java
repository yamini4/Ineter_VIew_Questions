package com.example.demo;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

class Pair {
	char alphabet;
	int count;

	Pair(char ch, int x) {
		this.alphabet = ch;
		this.count = x;
	}
}

public class SolutionCode {

	public static void main(String[] args) {
		duplicate_char("abcabcdabd", 10);
	}

	public static void duplicate_char(String s, int n) {
		ArrayList<Pair> pair = new ArrayList<>();
		char[] chars = s.toCharArray();
		Map<Character, Integer> charMap = new TreeMap<>();
		for (int i = 0; i < n; i++) {
			if (charMap.containsKey(chars[i])) {
				charMap.put(chars[i], charMap.getOrDefault(chars[i], 1) + 1);
			} else {
				charMap.put(chars[i], 1);
			}
		}
		for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {

			if (entry.getValue() > 1) {
				pair.add(new Pair(entry.getKey(), entry.getValue()));
			}
		}
		pair.stream().forEach(data -> System.out.println(data.alphabet + "====" + data.count));

	}
}