package com.test.java.question.method;

public class Q02 {
	
	public static void main(String[] args) {
		
		//1. 님을 붙이는 메소드 만들기
		//2. 호출
		
		String result;
		
		result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
		
	}
	
	public static String getName(String name) {
		
		return name + "님";
		
	}

}
