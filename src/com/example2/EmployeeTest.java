package com.example2;


public class EmployeeTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("qqq", "wqeqewqe", 55.5);
		Employee e2 = new Employee("zzzzzz", "1221321312", 2225.5);
		Manager m1 = new Manager("zzzzzz", "1221321312", 5555);
		Direct d1 = new Direct("zzzzzz", "1221321312", 2225.5);
		e1.setName("UUU");
		e1.raiseSalary(500);
		e1.displayInformation();
		e2.displayInformation();
		m1.displayInformation();
		d1.displayInformation();
	}
}
