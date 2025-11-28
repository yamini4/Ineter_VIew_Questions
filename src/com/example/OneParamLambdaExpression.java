package com.example;

public class OneParamLambdaExpression {
    interface MultiplyByFive {
        int multBy5(int n);
    }

    // static MultiplyByFive iMultiplyByFive() {
    //     return val -> val * 5;
    // }

    public static void main(String[] args) {
        MultiplyByFive obj = val -> val * 5;
        System.out.println(obj.multBy5(6));
    }
}
