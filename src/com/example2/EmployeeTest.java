package com.example2;

import java.util.ArrayList;

public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("qqq", "1", 55.5));
        employees.add(new Employee("zzzz", "2", 2225.5));
        employees.add(new Employee("wwww", "3", 5555));
        employees.add(new Manager("Manager", "5", 5555));
        employees.add(new Direct("direct", "6", 2225.5));
        employees.add(new Enineer("engineer", "7", 2225.5));

        employees.get(0).raiseSalary(500);
        // 多態父類別引用子類別物件
        if (employees.get(5) instanceof Enineer eg1) {
            eg1.addSkills("java");
            eg1.addSkills("c++");
            eg1.addSkills("python");
        }

        System.out.println("＝＝＝＝部門分配＝＝＝＝");
        if (employees.get(3) instanceof Manager m1) {
            m1.addEmployee(employees.get(0));
            m1.addEmployee(employees.get(1));
            m1.addEmployee(employees.get(2));
        }

        if (employees.get(4) instanceof Manager d1) {
            d1.addEmployee(employees.get(3));
        }

        System.out.println("＝＝＝＝員工資料＝＝＝＝");
        for (Employee e : employees) {
            e.displayInformation();
        }
    }
}
