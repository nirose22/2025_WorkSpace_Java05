package com.example2;
import lombok.Data;

import java.text.NumberFormat;
import java.util.Objects;

@Data
public abstract class Employee {
    static int nextId = 101;
    private int empId;
    private String name;
    private String ssnString;
    private double salary;
    private Branch branch;
    NumberFormat numberFormat = NumberFormat.getInstance();

    public abstract double getPay();

    public void raiseSalary(double s) {
        if (s < 0) {
            System.out.println("請輸入正確值");
            return;
        }
        System.out.println(this.name + " 的薪水加薪 " + s);
        salary += s;
    }

    public Employee(String name, String ssnString, double salary, Branch branch) {
        this.empId = nextId++;
        this.name = name;
        this.ssnString = ssnString;
        this.salary = salary;
        this.branch = branch;
    }

    @Override
    public String toString() {
        String s = branch.getCurrency() + numberFormat.format(salary);
        return "-----------\n" +
                // 用 numberformat 方法 格式化金額
                String.format("員工編號:%d%n姓名:%s%n身分證字號:%s%n薪水:%s%n", empId, name, ssnString, s);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId && Objects.equals(ssnString, employee.ssnString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, ssnString);
    }
}
