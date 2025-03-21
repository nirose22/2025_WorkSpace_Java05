package com.example2;

import lombok.Getter;

@Getter
public class Manager extends Employee {
    private String dept = "IT";

    public Manager(String name, String ssString, double salary) {
        super(name, ssString, salary);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Department: " + dept);
    }
}
