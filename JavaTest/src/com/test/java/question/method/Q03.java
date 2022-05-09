package com.test.java.question.method;

public class Q03 {
	
	public static void main(String[] args) {
		
		//1. 숫자 메소드 입력
		//2. 출력
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
	}
	
	public static void digit(int num) {
		
		System.out.printf("%d → %04d\n", num, num);
		
	}
}
