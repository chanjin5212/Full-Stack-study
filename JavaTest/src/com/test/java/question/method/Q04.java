package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 계산할 메소드 생성
		//2. 입력받을 버퍼드리더 생성
		//3. 입력 후 호출
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자:");
		int n1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자:");
		int n2 = Integer.parseInt(reader.readLine());
		
		String result;
		result = add(n1, n2); 
		System.out.println(result);
		
		result = subtract(n1, n2);
		System.out.println(result);

		result = multiply(n1, n2);
		System.out.println(result);

		result = divide(n1, n2);
		System.out.println(result);

		result = mod(n1, n2);
		System.out.println(result);
	
		
	}
	
	public static String add(int n1, int n2) {
		
		int result = n1 + n2;
		
		return n1 + " + " + n2 + " = " + result;
		
	}
	public static String subtract(int n1, int n2) {
		
		int result = n1 - n2;
		
		return n1 + " - " + n2 + " = " + result;
		
	}
	public static String multiply(int n1, int n2) {
		
		int result = n1 * n2;
		
		return n1 + " * " + n2 + " = " + result;
	
	}

	public static String divide(int n1, int n2) {
		
		double result = ((double)n1 / n2) * 10; // 소수점 출력은 String.format 사용 가능하나 아직 배우지 않음. 첫째 자리까지 표현하는 방법은 무엇인가?
		double result1 = (int)result / 10.0; // 소수점 첫째자리까지 표시가 가능하나 반올림은 불가
		
		return n1 + " / " + n2 + " = " + result1;
	
	}
	
	public static String mod(int n1, int n2) {
		
		int result = n1 % n2;
		
		return n1 + " % " + n2 + " = " + result;
	
	}

}
