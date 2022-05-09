package com.test.java.question.multipleloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자:");
		int firstNum = Integer.parseInt(reader.readLine()); 
		System.out.print("두번째 숫자:");
		int secondNum = Integer.parseInt(reader.readLine());
		
		String firstDivisor = "";
		String secondDivisor = "";
		String divisor = "";
		for (int i=1; i<=firstNum; i++) {
			if (firstNum % i == 0) {
				firstDivisor += i + ", ";
			}
		}
		
		for (int i=1; i<=secondNum; i++) {
			if (secondNum % i == 0) {
				secondDivisor += i + ", ";
			}
		}
		
		if (firstNum > secondNum) {
			for (int i=1; i<=secondNum; i++) {
				if (firstNum % i == 0 && secondNum % i == 0) {
					divisor += i + ", ";
				}
			}
		} else if (secondNum > firstNum) {
			for (int i=1; i<=firstNum; i++) {
				if (firstNum % i == 0 && secondNum % i == 0) {
					divisor += i + ", ";
				}
			}
		}
		System.out.printf("%d의 약수: %s\n", firstNum, firstDivisor + "\b\b");
		System.out.printf("%d의 약수: %s\n", secondNum, secondDivisor + "\b\b");
		System.out.printf("%d와 %d의 공약수: %s\n", firstNum, secondNum, divisor + "\b\b");
	}

}
