package com.example2;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin extends Employee {
    private int hours;

    public Admin(String name, String ssString, double salary, int hours, Branch branch) {
        super(name, ssString, salary, branch);
        this.hours = hours;
    }

    @Override
    public double getPay() {
        return this.getSalary()/160 * hours;
    }
}