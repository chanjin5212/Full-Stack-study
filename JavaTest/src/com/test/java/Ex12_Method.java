package com.test.java;

public class Ex12_Method {
	
	
	//main 메소드
	//- 특수 메소드
	//- 이름이 예약된 메소드(main)
	//- 프로그램이 시작되면 자바가 자동으로 호출(실행)하는 메소드
	//- 프로그램의 시작(Entry Point)
	
	public static void main(String[] args) {
		
		//Ex12_Method.java
		
		/*
		
			메소드, Method
			- 메소드(Method), 함수(Function), 프로시저(Procedure), 서브 루틴(Sub Routine)
			- 코드의 집합
			- 같은 목적을 가진 코드의 집합 > 1가지 목적을 위해 실행하는 코드들의 집합
			- 코드 재사용의 단위(****************)
			
			
			메소드 사용 단계
			1. 메소드 선언하기(정의하기)
				- 단 1회
			
			2. 메소드 호출하기(사용하기)
				- 1회 ~ 무한대
				
				
			메소드 장점
			1. 생산성이 높다. > 처음 만들때 비용이 싸다. > 반복 코드 제거
			2. 유지보수가 쉽다. > 메소드 선언부만 수정하면 > 호출부 그대로..
			3. 가독성이 높다. > 주제별로 코드를 분리해서 관리하기 때문에...
			
			
			요구사항] "안녕하세요" x 5회 출력
			수정사항] "반갑습니다" 수정하기
			
			
			
			
			
			메소드 검색 
			1. outline
			2. 호출부 > F3
			3. 호출부 > Ctrl + 마우스오버 > Open
			4. Quick Search
			
			
			
			
			
			프로그램에서 실행되는 코드의 흐름
			- 위 -> 아래
			
			
			
			
			이클립스 코드 실행 방법
			1. Ctrl + F11 > Break Point 동작X
			2. F11(Debug) > Break Point 동작O
				a. F5 : 현재 라인에 메소드가 있다면 메소드 정의부로 이동
				b. F6 : 현재 라인을 실행하고 다음줄로 이동
			
			
		*/

		//1. 초기생산 비용 고가 > 하드 코딩 > 저수준 방식
		//2. 유지보수 비용 고가 > 초기생산 비용 == 유지보수 비용
		
		//***** 프로그램내에 같은 일을 하는 코드가 2군데 이상 동일한게 발견되면 절대 안된다.!!!
		//     > 질 낮은 프로그램 > 관리 불량(비용 발생 심함)
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		System.out.println("반갑습니다.");
		
		
		//메소드 호출하기(실행하기, 사용하기)
		// -> hello라는 메소드가 가지는 코드를 실행해라!!
		hello(); //페이지 이동
		System.out.println("중간 출력");
		hello();
		hello();
		hello();
		hello();
		
		
		
		//요구사항] 숫자를 출력하시오.
		//1. 1~5까지
		//2. 하나~다섯까지
		//3. 6~10까지
		//4. 여섯~열까지
		
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");		
		System.out.println("4");
		System.out.println("5");
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");		
		System.out.println("다섯");
		System.out.println("6");
		System.out.println("7");		
		System.out.println("8");
		System.out.println("9");		
		System.out.println("10");
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");	
		
		
		//1. 1~5까지
		//2. 하나~다섯까지
		//3. 6~10까지
		//4. 여섯~열까지
		
		printNumberOneToFive();
		printKoreanNumberOneToFive();
		printNumberSixToTen();
		printKoreanNumberSixToTen();
		
		
	} //main
	
	public static void printNumberOneToFive() {
		System.out.println("1");
		System.out.println("2");
		System.out.println("3");		
		System.out.println("4");
		System.out.println("5");
	}
	
	public static void printNumberSixToTen() {
		System.out.println("6");
		System.out.println("7");		
		System.out.println("8");
		System.out.println("9");		
		System.out.println("10");
	}
	
	public static void printKoreanNumberOneToFive() {
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");		
		System.out.println("다섯");
	}
	
	public static void printKoreanNumberSixToTen() {
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");	
	}
	
	
	//메소드 선언하기
	//- 메소드는 클래스의 자식 위치에 선언한다.
	
	//public     static     void       hello    () 
	//접근지정자  정적키워드  반환자료형  메소드명  인자리스트
	
	//제어가 이동한다.
	public static void hello() {
		
		//해당 메소드가 하려는 업무 구현
		System.out.println("반갑습니다.");
		
	}
	
	

} //Ex12_Method




















