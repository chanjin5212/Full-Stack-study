package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Input {
	
	public static void main(String[] args) throws Exception { //예외 처리
		
		//Ex08_Input.java
		
		/*
		
			1. System.in.read()
				- System.out.print() 반대 기능
				- 기본 기능
				- 사용 불편함
				- 잘 안씀
			
			2. BufferedReader 클래스(***)
			
			3. Scanner 클래스
			
		
		*/
		
		//요구사항] 사용자에게 단어를 하나 입력받아 그대로 출력하시오.
		
		//BufferedReader reader: 변수 선언
		//reader -> 콘솔 입력 도구
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//System.out.println("시작");
		
		//일시 중지!! > 블럭 걸렸다. > 사용자가 키보드로 무언가를 입력하기를 기다리고 있는 중..
		//System.out.println("단어를 입력하세요.");
		
//		System.out.print("단어: "); //Label
//		String str = reader.readLine();
//		System.out.printf("입력한 내용: [%s]\n", str);
		
		//System.out.println("종료");
		
		
		//요구사항] 나이를 입력받아 문장을 출력하시오.
//		System.out.print("나이: ");
//		String age = reader.readLine();
//		System.out.printf("당신의 나이는 %s살입니다.\n", age);
		
		
		
		/*
		
			에러, Error
			- 오류, 버그(Bug), 예외(Exception) 등..
			
			1. 컴파일 에러
				- 컴파일 작업 중에 발생하는 에러
				- 컴파일러 발견!! > 번역하다가.. > 문법이 틀려서!!
				- 이클립스 편집기의 빨간 밑줄(x표)
				- 발생!! > 컴파일 작업 중단 > 프로그램 생성 불가 > 반드시 해결!!!!!!!!
				- 난이도 가장 낮음 > 발견이 쉽다!! > 고치기 쉽다.
				- 컴파일러가 에러 메시지를 보내준다.
				- 오타!!
				- 해결 방법: 에러 메시지 확인 > 코드 수정
			
			2. 런타임 에러
				- 컴파일 작업 중에는 없었는데.. 실행 중에 발생하는 에러
				- 문법에는 오류가 없는데.. 다른 원인으로 발생하는 에러
				- 예외(Exception)
				- 난이도 중간 > 발견 중간 > 발견 복불복 > 테스트 > 발견O > 코드 수정 > 발견X > 조치X
				- 게임 출시 > RPG > 소수의 개발자 모든 기능 테스트 > 모든 기능 테스트 불가능X > 클로즈드 알파, 클로즈드 베타 > 오픈 알파, 오픈 베타 > 수정..
				- 지구상의 모든 프로그램은 런타임 오류를 내재
				- 패치, 업그레이드..
				- 해결 방법: 다양한 테스트 > 발견된 오류에 한해서 수정				
			
			3. 논리 에러
				- 컴파일 성공! + 실행 성공! > 결과 중 일부 이상;;
				- 난이도 최상 > 발견 최악 + 수정 최악
			
			
			
			
			오류 노트 만들기
			- 제목 > 나누기 연산 중 발생하는 오류
			- 상황 > 사용자로부터 입력받은 숫자를 제수로 사용
			- 에러 메시지 > java.lang.ArithmeticException: / by zero
			- 에러 발생 코드 > System.out.printf("100 / %d = %d\n", num, 100 / num);
			- 해결책 > 제수를 0을 사용하면 안된다.
			
			
			
			GitHub
			- 개발자 취업 > GitHub
			- 오류 노트
			
			
		*/
		
		
		//요구사항] 사용자으로부터 숫자 입력 > 연산식 출력
		
		System.out.println("숫자를 입력하세요.(**** 반드시 0이 아닌 숫자를 입력하세요.)");
		int num = 0; //사용자 입력 숫자 
		System.out.printf("100 / %d = %d\n", num, 100 / num);
		
		
		int a = 10;
		int b = 5;
		
		System.out.println(a + b);
		
		
		
		
		
	}

}


























