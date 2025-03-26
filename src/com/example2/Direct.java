package com.example2;

import lombok.Getter;

@Getter
public class Direct extends Manager {
    private double budget = 6666.6;
    double baseBonus = 100000;

    public Direct(String name, String ssString, double salary) {
        super(name, ssString, salary);
    }

    @Override
    public double getPay() {
        return this.getSalary() + employees.size()*10000;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Budget: " + numberFormat.format(budget);
    }
    @Override
    public double getBonus() {
        return super.getBonus() + budget*0.1;
    }
}
