package com.test.java.question.method;

public class Q01 {
	
	public static void main(String[] args) {
		
		//1. 조건에 맞는 메소드 3개 생성
		//2. 메소드에 출력에 들어갈 문장 대입
		//3. 호출을 메인 메소드에 대입	
		
		hello();
		introduce();
		bye();
		
	}
	
	public static void hello() {
		System.out.println("안녕하세요.");
		
	}
	
	public static void introduce() {
		System.out.println("저는 홍길동입니다.");
		
	}
	public static void bye() {
		System.out.println("안녕히가세요.");
		
	}
	

}
