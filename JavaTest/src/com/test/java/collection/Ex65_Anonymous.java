package com.test.java.collection;

public class Ex65_Anonymous {
	
	public static void main(String[] args) {
		
		//com.test.java.obj > Ex65_Anonymous.java
		
		/*

			익명 객체, Anonymous Object
			- 익명 클래스, Anonymous Class
			- 이름없는 클래스(객체)
			- 반드시 인터페이스가 필요하다.(자바 특성. 문법 한계)
			
		*/
		
		
		//요구사항] 인터페이스를 구현한 클래스의 객체 생성
		//1. 본인 타입으로 참조 변수 만들기
		BBB b1 = new BBB();
		b1.aaa();
		b1.bbb();
		System.out.println();
		
		//2. 부모 타입(인터페이스)으로 참조 변수 만들기
		//- 업캐스팅
		AAA b2 = new BBB();
		b2.aaa();
		//b2.bbb(); > 안보임(자식 클래스 고유 멤버)
		((BBB)b2).bbb(); //고유 멤버 접근이 필요하면 다운캐스팅
		System.out.println();
		
		//3.
		//AAA b3 = new AAA();
		//b3.aaa(); //불가능 > 구현부 없는 메소드
		
		
		//The type new AAA(){} must implement the inherited abstract method AAA.aaa()
		AAA b3 = new AAA() {

			//*** 익명 객체의 멤버는 인터페이스 멤버와 동일하다.
			@Override
			public void aaa() {
				System.out.println("추상 메소드 구현");
			}
			
			//익명 객체는 자신의 멤버를 만들지 않습니다. > 부모 인터페이스 참조 변수를 통해서 호출 불가능 + 다운 캐스팅 불가능
			//public void ccc() {
			//	System.out.println("자신만의 메소드 구현");
			//}
			
		};
		
		b3.aaa();
		System.out.println();
		
		
		//b2 vs b3
		//- 공통점: AAA 인터페이스를 구현한 클래스의 객체다.
		b2.aaa();
		b3.aaa();
		
		//- 차이점: b2 > 일반 클래스의 객체 > 다운캐스팅 가능
		//       : b3 > 익명 클래스의 객체 > 다운캐스팅 불가능 > 타입의 이름이 없어서..
		
		((BBB)b2).bbb();
		//(???)b3
		
		
		
		
		
		//*** 모든 코드를 통들어 단 1개의 객체가 필요한 경우
		//1. 클래스 선언 > 객체 N개 생성
		//2. 클래스 없이 > 객체 1개 생성 > 익명 클래스
		
		//1회용 객체 생성 > 익명 클래스의 역할!!!
		
		
		
		
		
		
		
	}//main

}//Ex65


interface AAA {
	void aaa();
}

//The type BBB must implement the inherited abstract method AAA.aaa()
class BBB implements AAA {
	
	@Override
	public void aaa() {
		System.out.println("추상 메소드 구현");
	}
	
	public void bbb() {
		System.out.println("자신만의 메소드 구현");
	}
	
}



























































