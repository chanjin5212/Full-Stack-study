package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		
		//1. 근무년수 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 근무년수 입력
		
		//2. 유효성 검사 if문 생성(1 미만 예외)
		//	2.1 if문 안에 경력별 개발자 계급 생성
		//	2.2 초급,중급,고급 각각에 달성하는 년수 입력
		//	2.3 else 생성 후 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("근무 년수:");
		int year = Integer.parseInt(reader.readLine());
		
		if (year >= 1) {
			
			if (year < 5) {
				System.out.printf("%d년차 초급 개발자입니다.\n", year);
				System.out.printf("앞으로 %d년 더 근무를 하면 중급 개발자가 됩니다.", 5 - year);
			} else if (year >=5 && year < 10) {
				System.out.printf("%d년차 중급 개발자입니다.\n", year);
				System.out.printf("당신은 %d년전까지 초급개발자였습니다.\n", year - 4);
				System.out.printf("앞으로 %d년 더 근무를 하면 고급 개발자가 됩니다.", 10 - year);
			} else if (year >= 10) {
				System.out.printf("%d년차 고급 개발자입니다.\n", year);
				System.out.printf("당신은 %d년전까지 중급개발자였습니다.", year - 9);
			}
		} else {
			System.out.println("입력한 값이 올바르지 않습니다. 1이상의 값을 입력하시오.");
		}
		
	}

}
