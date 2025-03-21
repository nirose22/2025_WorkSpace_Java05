package com.example2;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee {
	static int nextId = 101;
	private int empId;
	private String name;
	private String ssnString;
	private double salary;

	public void displayInformation() {
		System.out.printf("員工編號:%d%n 姓名:%s%n 身分證字號:%s%n 薪水:%.1f%n", empId, name, ssnString, salary);
	}
	
	
	
	public void setName(String n) {
		if (n.toString() == "" || n == null) {
			System.out.println("請輸入正確值");
			return;	
		}
		name = n;
		
	}
	
	public void raiseSalary(double s) {
		if (s < 0) {
			System.out.println("請輸入正確值");
			return;
		}
		salary+=s;
	}



	public Employee(String name, String ssnString, double salary) {
		this.empId = nextId++;
		this.name = name;
		this.ssnString = ssnString;
		this.salary = salary;
	}
}
