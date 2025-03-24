package com.example2;

import lombok.Getter;
@Getter
public class Direct extends Manager {
    private double budget = 6666.6;

    public Direct(String name, String ssString, double salary) {
        super(name, ssString, salary);
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.println("Budget: " + numberFormat.format(budget));
    }
}
