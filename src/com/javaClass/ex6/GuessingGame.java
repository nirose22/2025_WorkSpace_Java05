package com.javaClass.ex6;

import java.util.Scanner;

public class GuessingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int random;
		int guessing;
		random = (int) (Math.random() * 5);
		while (true) {
			System.out.println("請輸入數字");
			String text = scanner.next();
			if (text.equalsIgnoreCase("help") || !text.matches("\\d")) {
				System.out.println("猜測內容需為數字 1 - 5");
			} else {
				guessing = Integer.parseInt(text);
				if (guessing > 5 || guessing < 1) {
					System.out.println("猜測內容需為數字 1 - 5");
					continue;
				} else if (guessing == random) {
					System.out.println("你猜對了!");
					break;
				} else {
					System.out.println("請繼續猜");
				}
			}
		}
		
	}
}
