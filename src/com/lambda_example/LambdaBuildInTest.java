package com.lambda_example;
import java.util.List;
import java.util.function.*;
/**
    // 定義 Predicate，用於判斷字串是否以 "a" 開頭
    Predicate<String> startsWithA = s -> s.startsWith("a");

    // 定義 Function，用於將字串轉換為大寫
    Function<String, String> toUpperCase = s -> s.toUpperCase();

    // 定義 Consumer，用於消費字串，也就是將字串印出到控制台
    Consumer<String> printer = s -> System.out.println("Result: " + s);

    // 使用 Stream API，依次：
    // 1. 利用 filter() 方法過濾出符合條件的字串。
    // 2. 利用 map() 方法將符合條件的字串轉換為大寫。
    // 3. 利用 forEach() 方法消費每一個結果，印出到控制台。
    words.stream()
         .filter(startsWithA)
         .map(toUpperCase)
         .forEach(printer);
 */
public class LambdaBuildInTest {
    public static void main(String[] args) {
        List<Person> personList = Person.createList();
        /*
         * Function 的主要抽象方法是：
         * R apply(T t);
         * 返回一個新的結果
         * T：輸入類型
         * R：返回類型
         * 這個介面非常適合用於對數據進行轉換的情況。ˇ
         */
        // 使用 Lambda Expression 定義以Function 函式介面,傳回稱謂(姓名前加上Ms./Mr.)
        System.out.println("===== 姓名前加上Ms./Mr.=====");
        Function<Person, String> personToTitle = person -> person.getGender() == Gender.MALE ? "Mr." + person.getFirstName() : "Ms." + person.getFirstName();
        personList.forEach(p -> System.out.println(personToTitle.apply(p)));

        /*
         * Predicate 的主要抽象方法是：
         * boolean test(T t);
         * 返回布林值
         * 這個介面非常適合用於過濾數據的情況。
         */
        // 使用 Lambda Expression 定義Predicate 函式介面,篩選列印30歲以下的Person資訊
        System.out.println("===== 30歲以下的Person資訊=====");
        Predicate<Person> personToAge = person -> person.getAge() < 30;
        personList.forEach(p -> {
            if (personToAge.test(p)) {
                System.out.println(p.getFirstName() + "(" + p.getAge() + ")");
            }
        });

        /*
         * Consumer 的主要抽象方法是：
         * void accept(T t);
         * 無返回值
         * 這個介面非常適合用於需要「消費」數據並執行副作用（如輸出、儲存、修改外部狀態）的情況。
         */
        // 使用 Lambda Expression 定義以Comsumer 函式介面以FirstName(age)格式來列印Person資訊
        System.out.println("===== FirstName(age)格式來列印Person資訊=====");
        Consumer<Person> personToFirstName = person -> System.out.println(person.getFirstName() + "(" + person.getAge() + ")");
        personList.forEach(personToFirstName);


    }

}
