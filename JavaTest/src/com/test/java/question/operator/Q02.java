package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		
		//숫자 2개 입력 받아 정수로 바꾸기
		System.out.print("첫번째 숫자:");
		String num1 = reader.readLine();
		int num1_1 = Integer.parseInt(num1);
		System.out.print("두번째 숫자:");
		String num2 = reader.readLine();
		int num2_2 = Integer.parseInt(num2);
		
	
		//출력
		System.out.printf("%d + %d = %d\n", num1_1, num2_2, num1_1 + num2_2);
		System.out.printf("%d - %d = %d\n", num1_1, num2_2, num1_1 - num2_2);
		System.out.printf("%d * %d = %d\n", num1_1, num2_2, num1_1 * num2_2);
		System.out.printf("%d / %d = %.1f\n", num1_1, num2_2, (double)num1_1 / num2_2);
		System.out.printf("%d %% %d = %d\n", num1_1, num2_2, num1_1 % num2_2);
		
		
		
		
	}

}
