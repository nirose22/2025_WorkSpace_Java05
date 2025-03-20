package com.javaClass.ex6;

public class PersonTest {
	public static void main(String[] args) {
		Person<String> p1 = new Person<>("Fernando Gonzalezz", "0298765432");
		p1.addLastName("Gonzalezz");
		p1.displayInfo();
	}
}
