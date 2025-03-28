package com.example2;

import java.util.ArrayList;

public class EmployeeTest {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Admin("qqq", "1", 55.5, 180, Branch.Tokyo));
        employees.add(new Admin("王小明", "2", 100.5, 120, Branch.Taipei));
        employees.add(new Manager("Manager", "5", 5555, Branch.London));
        employees.add(new Direct("direct", "6", 3000, Branch.Taipei));
        employees.add(new Enineer("engineer", "7", 2225.5, Branch.NewYork));

        employees.get(0).raiseSalary(500);
        // 多態父類別引用子類別物件
        if (employees.get(4) instanceof Enineer eg1) {
            eg1.addSkills("java");
            eg1.addSkills("c++");
            eg1.addSkills("python");
        }

        if (employees.get(2) instanceof Manager m1) {
            m1.addEmployee(employees.get(0));
            m1.addEmployee(employees.get(1));
        }

        if (employees.get(3) instanceof Manager d1) {
            d1.addEmployee(employees.get(2));
        }

        System.out.println("＝＝＝＝員工資料＝＝＝＝");
        for (Employee e : employees) {
            Branch b = e.getBranch();
            String currency = b.getCurrency();
            System.out.println(e + "\n本月薪資總共是：" + currency + e.getPay());
            if (e instanceof RegularStaff) {
                System.out.print("摸彩結果為: ");
                System.out.println(RegularStaff.getLuckyGift());
                System.out.print("獎金是: ");
                System.out.println(currency + ((RegularStaff) e).getBonus());
            }
        }
    }
}
