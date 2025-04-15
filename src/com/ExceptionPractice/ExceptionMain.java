package com.ExceptionPractice;

import java.io.*;

public class ExceptionMain {
    public static void main(String[] args) {
        boolean toUpp = false;
        if (args.length == 0) {
            System.err.println("Please provide a file name as an argument.");
        } else if (args[0].equalsIgnoreCase("-U")) {
            toUpp = true;
        }


        try (
                BufferedReader b = new BufferedReader(new FileReader("src/com/ExceptionPractice/DeclarationOfIndependence.txt"));
                BufferedWriter w = new BufferedWriter(new FileWriter("src/com/ExceptionPractice/result.txt"));
        ) {
            System.out.println("Reading from file:" + args[0]);
            String s;
            // 創建文件
            while ((s = b.readLine()) != null) {
                if (toUpp) {
                    s = s.toUpperCase();
                } else {
                    s = s.toLowerCase();
                }
                w.write(s);
                w.newLine();
            }
        } catch (IOException e) {
            System.err.println("An error occurred while processing the file: " + e.getMessage());
        }
    }
}
