package com.example2;

import java.lang.invoke.VarHandle;
import java.util.Arrays;

public class Enineer extends Employee{
    private String[] skills;
    int skillCount;

    public Enineer(String name, String ssString, double salary) {
        super(name, ssString, salary);
        skills = new String[5];
        skillCount = 0;
    }

    public void addSkills(String skill) {
        if (skillCount<5) {
            System.out.println("加入技能: " + skill);
            skills[skillCount++] = skill;
        } else {
            System.out.println("技能已满");
        }
    }

    @Override
    public void displayInformation() {
        super.displayInformation();
        System.out.print("技能: ");
        for (String skill : skills) {
            if (skill != null) {
                System.out.print(skill + " ");
            }
        }
    }
}
