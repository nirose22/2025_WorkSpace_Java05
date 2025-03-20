package com.javaClass.ex6;


class Person<T> {
	StringBuilder name;
	StringBuilder phoneNumber;
	T lastname;
	
	public Person(String n,String p) {
		this.name = new StringBuilder(n);
		this.phoneNumber = new StringBuilder(p);
	}
	
	public void addLastName(T l) {
		this.lastname = l;
		phoneNumber = (StringBuilder) phoneNumber;
		phoneNumber.insert(2, "-");
		phoneNumber.insert(7, "-");
	}
	
	
	public void displayInfo() {
		System.out.printf(
				"姓名:" + name + "%n"
				+ "姓氏:" + lastname + "%n"
				+ "電話" + phoneNumber + "%n"
				+ "姓名長度" + name.length() + "%n"
				+ "姓名容量" + name.capacity() + "%n"
		);
	}
}
