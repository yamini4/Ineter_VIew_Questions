package com.example.demo.reallifesolutions;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class EmployeeService {

	private List<Employee> employees;

	@PostConstruct
	public void initEmployees() {
		employees = List.of(new Employee(1, "Yamini", "IT", 55000, List.of("Java", "Spring", "SQL")),
				new Employee(2, "Syed", "HR", 45000, List.of("Communication", "Recruitment")),
				new Employee(3, "Akhil", "IT", 65000, List.of("Java", "Angular", "Docker")),
				new Employee(4, "Ravi Kumar", "Finance", 48000, List.of("Excel", "SAP")),
				new Employee(5, "Meena", "IT", 72000, List.of("AWS", "DevOps", "Kubernetes")),
				new Employee(6, "Kalyan", "Marketing", 40000, List.of("SEO", "Content Writing")),
				new Employee(7, "Divya", "IT", 60000, List.of("React", "NodeJS", "MongoDB")),
				new Employee(8, "Rohit", "HR", 47000, List.of("HRMS", "Payroll", "Communication")),
				new Employee(9, "Lavanya", "Finance", 52000, List.of("Tally", "Excel", "Auditing")),
				new Employee(10, "Sanjay", "IT", 68000, List.of("Java", "Microservices", "Kafka")),
				new Employee(11, "Harsha", "Support", 35000, List.of("Troubleshooting", "Customer Handling")),
				new Employee(12, "Sneha", "Support", 38000, List.of("Email Handling", "Ticketing Tools")),
				new Employee(13, "Praveen", "Marketing", 56000, List.of("Branding", "Campaign Management")),
				new Employee(14, "Kiran", "IT", 59000, List.of("Python", "Django", "REST API")),
				new Employee(15, "Ananya", "Finance", 75000, List.of("Investment", "Risk Analysis", "SAP")));
	}

	@Override
	public String toString() {
		return "EmployeeService [employees=" + employees + "]";
	}

}
