package com.test.java;

public class Ex16_Method {
	
	public static void main(String[] args) {
		
		//Ex16_Method.java
		
		//Swap
		//- 2개의 공간안의 값을 서로 교환하는 작업
		
		int a = 10;
		int b = 20;
				
		swap(a, b); 	
		
		
		
		String s1 = "홍길동";
		String s2 = "아무개";
		
		
		swap(s1, s2);
		
		
		
		boolean b1 = true;
		boolean b2 = false;
		
		swap(b1, b2);
		
		
		
		
		//Swap 로직
		//1. 빈 공간 추가로 사용 > 잘사용O
		//2. 비트 연산자 > 잘사용X > 정수값 적용 가능
		
		int c = 10;
		int d = 20;
		
		c = c ^ d;
		d = c ^ d;
		c = c ^ d;
		
		System.out.printf("c: %d, d: %d\n", c, d);
		
	}
	
	public static void swap(int a, int b) {
		
		System.out.printf("a: %d, b: %d\n", a, b);
		
		int temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.printf("a: %d, b: %d\n", a, b);
		
	}
	
	
	public static void swap(String a, String b) {
		
		System.out.printf("a: %s, b: %s\n", a, b);
		
		String temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.printf("a: %s, b: %s\n", a, b);
		
	}
	
	
	public static void swap(boolean a, boolean b) {
		
		System.out.printf("a: %b, b: %b\n", a, b);
		
		boolean temp;
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.printf("a: %b, b: %b\n", a, b);
		
	}

}











































