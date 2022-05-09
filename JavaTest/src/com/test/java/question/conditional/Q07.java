package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 숫자 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 숫자 입력받기
		
		//2. 홀수인지 짝수인지 구분하기
		//	2.1 짝수 count 홀수 count 생성
		//	2.2 짝수와 홀수 입력에 따라 count +=1 하기
		//	2.3 조건에 맞는 if문 생성
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자 입력:");
		int num1 = Integer.parseInt(reader.readLine());
		check(num1);
		System.out.print("숫자 입력:");
		int num2 = Integer.parseInt(reader.readLine());
		check(num2);
		System.out.print("숫자 입력:");
		int num3 = Integer.parseInt(reader.readLine());
		check(num3);
		System.out.print("숫자 입력:");
		int num4 = Integer.parseInt(reader.readLine());
		check(num4);
		System.out.print("숫자 입력:");
		int num5 = Integer.parseInt(reader.readLine());
		check(num5);
		
		int countEven = 0;
		int countOdd = 0;
		
		countEven += even(num1);
		countOdd += odd(num1);
		
		countEven += even(num2);
		countOdd += odd(num2);
		
		countEven += even(num3);
		countOdd += odd(num3);
		
		countEven += even(num4);
		countOdd += odd(num4);
		
		countEven += even(num5);
		countOdd += odd(num5);
		
		System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", countEven, countOdd);
		
		if (countEven > countOdd) {
			System.out.printf("짝수가 홀수보다 %d개 많습니다.", countEven - countOdd);
		} else if (countOdd > countEven) {
			System.out.printf("홀수가 짝수보다 %d개 많습니다.", countOdd - countEven);			
		} else {
			System.out.println("홀수와 짝수의 갯수가 같습니다.");
		}
		
	}
	
	public static int even(int num) {
		
		if (num % 2 ==0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static int odd(int num) {
		
		if (num % 2 != 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void check(int num) {
		if (num > 0 && num <= 10) {
			return;
		} else {
			System.out.println("1~10 사이의 정수만 입력하시오.");
		}
	}
	

}
