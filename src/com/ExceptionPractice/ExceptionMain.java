package com.ExceptionPractice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {
    public static void main(String[] args) {
        try (
                BufferedReader b = new BufferedReader(new FileReader(args[0]));
            ) {
            System.out.println("Reading from file:" + args[0]);
            String s;
            while ((s = b.readLine()) != null) {
                System.out.println(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
