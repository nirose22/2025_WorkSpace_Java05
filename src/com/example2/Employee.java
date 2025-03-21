package com.example2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.NumberFormat;
import java.util.Objects;

@Data
@NoArgsConstructor
public class Employee {
    static int nextId = 101;
    private int empId;
    private String name;
    private String ssnString;
    private double salary;

    public void displayInformation() {
        // 用 numberformat 方法 格式化金額
        NumberFormat f = NumberFormat.getCurrencyInstance();
        String s = f.format(salary);
        System.out.println("-----員工資料------");
        System.out.printf("員工編號:%d%n姓名:%s%n身分證字號:%s%n薪水:%s%n", empId, name, ssnString, s);
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
        salary += s;
    }


    public Employee(String name, String ssnString, double salary) {
        this.empId = nextId++;
        this.name = name;
        this.ssnString = ssnString;
        this.salary = salary;
    }
}
