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

    public String getStaffDetails() {
        StringBuilder sb = new StringBuilder();
        if (!employees.isEmpty()) {
            sb.append(getName()).append("管理的人員有：");
            for (Employee e : employees) {
                sb.append(String.format(" %s(%d)", e.getName(), e.getEmpId()));
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return super.toString() +
        "Department: " + dept + "\n" +
        this.getStaffDetails();
    }
}
