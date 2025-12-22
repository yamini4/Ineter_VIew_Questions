package com.example.demo.reallifesolutions;

import java.util.List;

public class Employee {
	int id;
	String name;
	String department;
	double salary;
	List<String> skills;

	Employee(int id, String name, String department, double salary, List<String> skills) {
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.skills = skills;
	}

}
