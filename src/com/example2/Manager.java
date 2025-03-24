package com.example2;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Manager extends Employee {
    private String dept = "IT";
    private ArrayList<Employee> employees = new ArrayList<>();

    public Manager(String name, String ssString, double salary) {
        super(name, ssString, salary);
    }

    public boolean addEmployee(Employee employee) {
        if (employees.contains(employee)) {
            return true;
        } else {
            employees.add(employee);
            return false;
        }
    }

    public boolean removeEmployee(Employee employee) {
        if (employees.contains(employee)) {
            employees.remove(employee);
            return true;
        }
        return false;
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Department: " + dept);
        System.out.print("管理的人員有: ");
        this.printStaffDetails();
    }

    public void printStaffDetails() {
        for (Employee e : employees) {
            System.out.print(e.getName() + " ");
        }
        System.out.println();
    }
}
