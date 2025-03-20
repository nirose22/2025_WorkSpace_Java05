package com.javaClass;

import java.util.Scanner;

class Test0319_1 {
	public static void main(String[] args) {
		System.out.println("請輸入字");
		Scanner sc = new Scanner(System.in);
		String text = sc.next();
		String cont;
		while(!text.equalsIgnoreCase("q")) {
			if (isPalidrome(text)) {
				cont = String.format("%s是迴文", text);
			} else {
				cont = String.format("%s不是迴文", text);
			}
			System.out.println(cont);
			System.out.println("請輸入Q exit");
			text = sc.next();
		}
		sc.close();
	}
	
	public static boolean isPalidrome(String text) {
		int start = 0;
		int end = text.length() -1;
		while(start < end) {
			if (text.charAt(start) != text.charAt(end)) {
				return false;
			}
			end--;
			start++;
		}
		return true;
	}
}

