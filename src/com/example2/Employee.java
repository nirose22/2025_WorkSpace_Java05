package com.example2;


import java.text.NumberFormat;
import java.util.Objects;

public class Employee {
    static int nextId = 101;
    private int empId;
    private String name;
    private String ssnString;
    private double salary;
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    public void displayInformation() {
        // 用 numberformat 方法 格式化金額
        String s = numberFormat.format(salary);
        System.out.println("-----------");
        System.out.printf("員工編號:%d%n姓名:%s%n身分證字號:%s%n薪水:%s%n", empId, name, ssnString, s);
    }

    public String getName() {
        return name;
    }

    public void setName(String n) {
        if (Objects.equals(n, "") || n == null) {
            System.out.println("請輸入正確值");
            return;
        }
        name = n;
    }

    public void raiseSalary(double s) {
        if (s < 0) {
            System.out.println("請輸入正確值");
            return;
        }
        System.out.println(this.name + " 的薪水加薪 " + s);
        salary += s;
    }

    public Employee(String name, String ssnString, double salary) {
        this.empId = nextId++;
        this.name = name;
        this.ssnString = ssnString;
        this.salary = salary;
    }
}
