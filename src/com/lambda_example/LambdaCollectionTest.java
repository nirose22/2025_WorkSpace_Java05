package com.lambda_example;

import java.util.*;
import java.util.stream.Collectors;

public class LambdaCollectionTest {

    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        
        // 使用 Lambda Expression 定義以LastName來升冪排序
        System.out.println("======升冪排序=======");
        //personList.sort((Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName()));
        personList.sort(Comparator.comparing(Person::getLastName));
        personList.forEach((Person p) -> System.out.println(p.getLastName()));
    
        // 使用 Lambda Expression 定義以Age來降冪排序
        System.out.println("======降冪排序=======");
        personList.sort((Person p1, Person p2) -> p2.getAge() - p1.getAge());
        personList.forEach(p -> System.out.println(p.toString()));

        // 使用 Lambda Expression 定義移除所有女性成員
        System.out.println("======移除所有女性成員=======");
        List<Person> pl1 = personList;

        pl1.removeIf((Person p) -> p.getGender() == Gender.FEMALE);
        //List<Person> removed = personList.stream()
        //        .filter((Person p) -> p.getGender() == Gender.FEMALE)
        //        .toList();
        System.out.println("移除後剩餘成員數量：" + pl1.size());

        pl1.forEach(p -> System.out.println(p.toString()));


        // 使用 Lambda Expression 定義移除年齡小於35成員
        System.out.println("======移除年齡小於35成員=======");
        List<Person> pl2 = Person.createList();
        pl2.removeIf((Person p) -> p.getAge() > 35);
        //List<Person> removed2 = personList.stream()
        //        .filter((Person p) -> p.getAge() < 35)
        //        .toList();
        System.out.println("移除後剩餘成員數量：" + pl2.size());
        pl2.forEach(p -> System.out.println(p.toString()));

    }
}