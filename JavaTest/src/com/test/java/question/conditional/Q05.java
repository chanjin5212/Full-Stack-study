package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 숫자 2개 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 숫자 입력받기
		
		//2. 유효성 검사 if문 생성(산술 연산자)
		//	2.1 입력받은 연산자에 따른 if문 생성
		//	2.2 if문에 계산식 생성
		//	2.3 else 생성하고 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자:");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자:");
		int num2 = Integer.parseInt(reader.readLine());
		System.out.print("연산자:");
		String operator = reader.readLine();
		
		if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/") || operator.equals("%")) {
			
			if (operator.equals("+")) {
				System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
			} else if (operator.equals("-")) {
				System.out.printf("%d - %d = %d", num1, num2, num1 - num2);				
			} else if (operator.equals("*")) {
				System.out.printf("%d * %d = %d", num1, num2, num1 * num2);								
			} else if (operator.equals("/")) {
				System.out.printf("%d / %d = %.1f", num1, num2, (double)num1 / num2);												
			} else if (operator.equals("%")) {
				System.out.printf("%d %% %d = %d", num1, num2, num1 % num2);								
			}
		} else {
			System.out.println("연산이 불가능합니다.");
		}
		
		
		
	}

}
