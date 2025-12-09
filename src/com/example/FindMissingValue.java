package com.example;

public class FindMissingValue {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 4, 5, 6 };

        long n = arr.length;
        Long sumOfN = (n * (n + 1)) / 2;
        // System.out.println(sumOfN);
        long sumOfNValues = 0;

        for (int i = 0; i < n; i++) {
            sumOfNValues += arr[i];
        }
        // System.out.println(sumOfNValues);

        if (sumOfNValues > sumOfN) {
            System.out.println((n + 1) - (sumOfNValues - sumOfN));
        }
    }
}
