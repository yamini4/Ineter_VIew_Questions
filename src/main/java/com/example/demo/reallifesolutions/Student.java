package com.example.demo.reallifesolutions;

import java.util.List;

public class Student {
    int roll;
    String name;
    int marks;
    List<Integer> subjectMarks;

    Student(int roll, String name, int marks, List<Integer> subjectMarks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
        this.subjectMarks = subjectMarks;
    }
}
