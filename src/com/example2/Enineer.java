package com.example2;

public class Enineer extends Employee implements RegularStaff {
    private String[] skills;
    int skillCount;

    @Override
    public double getPay() {
        return this.getSalary() + skillCount * 3000;
    }

    public Enineer(String name, String ssString, double salary) {
        super(name, ssString, salary);
        skills = new String[5];
        skillCount = 0;
    }

    public void addSkills(String skill) {
        if (skillCount < 5) {
            System.out.println("加入技能: " + skill);
            skills[skillCount++] = skill;
        } else {
            System.out.println("技能已满");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        if (skillCount > 0) {
            sb.append("Skills: ");
            for (String skill : skills) {
                if (skill != null) {
                    sb.append(" ").append(skill);
                }
            }
        }
        return sb.toString();
    }

    @Override
    public double getBonus() {
        return getSalary() * calPerMultiplier();
    }
}
