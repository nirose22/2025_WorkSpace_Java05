package com;

import java.util.*;

public class CarStore {
    static List<String> carList = new ArrayList<>();
    static Set<String> carBrand = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            while (carList.size() < 5) {
                System.out.println("請輸入要新增的汽車品牌");
                String car = sc.next();
                addCar(car);
                System.out.println(2); 
            }
            showCar();
            while (carList.size() > 4) {
                System.out.println("請輸入要購買的汽車品牌");
                String car = sc.next();
                buyCar(car);
            }
            showCar();
        }
    }

    public static void addCar(String car) {
        carBrand.add(car);
        carList.add(car);
    }

    public static void buyCar(String car) {
        if (carBrand.contains(car)) {
            int index = carList.indexOf(car);
            System.out.println("請移置 " +  (index + 1) + " 車庫賞車");
            System.out.println("已銷售:" + car);
            carList.remove(car);
            if (!carList.contains(car)) {
                carBrand.remove(car);
            }
        } else {
            System.out.println("查無此" + car + "品牌");
        }
    }

    // 展示
    public static void showCar() {
        System.out.println("=======================================");
        System.out.println("現有車輛:" + carList);
        System.out.println("銷售品牌:" + carBrand);
        System.out.println("=======================================");
    }
}
