package com.test.java.question.overload;

public class Q02 {

	public static void main(String[] args) {
		
		//인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.
		position("홍길동");
		System.out.println();
		
		position("홍길동", "유재석");
		System.out.println();
		
		position("홍길동", "유재석", "박명수");
		System.out.println();
		
		position("홍길동", "유재석", "박명수", "정형돈");
		System.out.println();
		
	}//main
	
	public static void position(String name1) {
		System.out.println("사원: " + name1);
	}
	
	public static void position(String name1, String name2) {
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
	}
	
	public static void position(String name1, String name2, String name3) {
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
		System.out.println("과장: " + name3);
	}
	
	public static void position(String name1, String name2, String name3, String name4) {
		System.out.println("사원: " + name1);
		System.out.println("대리: " + name2);
		System.out.println("과장: " + name3);
		System.out.println("부장: " + name4);
	}
	
}
