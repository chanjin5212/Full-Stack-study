package com.test.java.obj;

public class Ex30_Class {

	public static void main(String[] args) {
		
		/*
		
			클래스, Class
			
			
			1. 객체, Object
			
			2. 클래스, Class
			
			3. 인스턴스, Instance
			
			4. 추상화
			
			5. 정보 은닉(화)
			
			6. 인터페이스
			
			7. 프로퍼티, 속성, 특성
			
			8. 행동
			
			9. 상속
		
			
			
			변수 사용
			1. 변수 선언하기
			2. 변수 사용 > 공간 역할
			
			메소드 사용
			1. 메소드 선언하기
			2. 메소드 사용 > 호출 > 재사용
			
			클래스 사용
			1. 클래스 선언하기(정의)
			
				class 클래스명 {
					클래스 멤버 구현
					a. 멤버 변수
					b. 멤버 메소드
				}
			
			2. 클래스 사용 -> 객체 생성
				
				클래스명 객체명 = new 생성자();
			
		
		*/
		
		
		//요구사항] 지도 > 우리집 > 좌표 > 저장 > 호출 + 출력
		
		//Case 1.
		//- 간편, 즉시 생성
		//- 식별자 문제 > 같은 성질의 식별자가 서로 다른 이름을 사용
		//             > 물리적인 제약이 존재하지 않음 > 사용자 경험 근거 > 구조 불안정 
		//- 생산성, 유지보수성 낮음
		
		//우리집 좌표
		int x = 100;
		int y = 200;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", x, y);
		
		//마트 좌표
		int x2 = 300;
		int y2 = 400;
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", x2, y2);
		
		
		
		
		//Case 2.
		//- 배열 사용
		//- 데이터 저장의 구조 생성 > 관리 수월(용이) > 가독성 향상
		//- 동일 성질의 데이터 > 동일한 식별자 사용(방번호)
		//- 배열 단점 > 요소간의 성질을 구분하기 힘들다. > 첨자 사용 > *** 배열은 서로 다른 성질의 데이터를 넣으면 안된다.
		
		
		//1명의 점수(5과목)
		int[] score = { 100, 90, 80, 70, 60 }; //서로 다른 성질의 데이터
		
		int[] kors = { 100, 90, 80 }; //같은 성질의 데이터
		
		
		
		
		//우리집
		int[] a1 = { 100, 200 };
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", a1[0], a1[1]);
		
		
		//마트
		int[] a2 = { 300, 400 };
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", a2[0], a2[1]);
		
		
		
		
		//Case 3.
		//- 클래스 사용
		//- 클래스를 사용해서 정의된 내용을 메모리에 실체화 시키는 행동
		//- 객체 생성하기(*******)
		//- 클래스는 자료형의 역할을 한다. > 변수를 만들 수 있다.
		//- 데이터 저장의 구조 생성 > 관리 수월(용이) > 가독성 향상
		//- 각 요소의 이름 부여 > 각각의 데이터가 어떤 데이터인지 식별이 용이
		//- 요소의 이름이 동일하다.
		
		//자료형 변수명;
		int n1 = 10;
		
		
		//우리집
		Point p1 = new Point();
		
		//객체.멤버 > "." > 멤버 접근 연산자
		p1.x = 100;
		p1.y = 200;
		
		System.out.printf("우리집은 [%d, %d]에 위치합니다.\n", p1.x, p1.y);
		
		
		//마트
		Point p2 = new Point();
		
		p2.x = 300;
		p2.y = 400;
		
		System.out.printf("마트는 [%d, %d]에 위치합니다.\n", p2.x, p2.y);
		
		
		
		
		
		//자바의 자료형
		//1. 기본 부품(단일 레고 블럭) > 원시형, 값형 x 8종류
		//2. 조합 부품(블럭 조합) > 새로운 모양 창조 > 참조형(문자열, 배열, 클래스) x 무한대
		
		
		int a;
		int b;
		
		
		//요구사항] 크기 저장 > 너비(width) + 높이(height)
		
		Size s1 = new Size();
		
		s1.name = "모니터";
		s1.width = 100;
		s1.height = 200;
		
		System.out.println(s1.name);
		System.out.println(s1.width);
		System.out.println(s1.height);
		
		
		Size s2 = new Size();
		
		s2.name = "키보드";
		s2.width = 50;
		s2.height = 30;
		
		System.out.println(s2.name);
		System.out.println(s2.width);
		System.out.println(s2.height);
		
		
		
		//성적 처리] 국영수
		Score m1 = new Score();
		
		m1.name = "홍길동";
		m1.kor = 100;
		m1.eng = 90;
		m1.math = 80;
		
		
		Score m2 = new Score();
		
		m2.name = "아무개";
		m2.kor = 95;
		m2.eng = 85;
		m2.math = 77;
		
		
		
		
		
		
		
	}//main
		
		
}//class


//성적
class Score {
	
	public String name; //학생명
	public int kor;		//국어
	public int eng; 	//영어
	public int math;	//수학
	
}


//크기 저장
class Size {

	public String name;
	public int width;
	public int height;
	
}


//자바의 변수
//1. 클래스 멤버 변수
//2. 지역 변수


//클래스 선언하기 > 클래스명 > 파스칼 표기법

//설계도
class Point {
	
	//멤버 선언하기(변수, 메소드) > 클래스 멤버 변수
	public int x;
	public int y;
	
}











//클래스 + 객체(인스턴스)
//- 붕어빵틀(클래스) + 붕어빵(객체)
















































