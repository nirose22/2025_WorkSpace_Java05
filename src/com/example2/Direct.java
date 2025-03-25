package com.example2;

import lombok.Getter;

@Getter
public class Direct extends Manager {
    private double budget = 6666.6;

    public Direct(String name, String ssString, double salary) {
        super(name, ssString, salary);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Budget: " + numberFormat.format(budget);
    }
}
