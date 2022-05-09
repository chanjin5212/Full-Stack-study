package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 성적 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 성적 입력
		
		//2. if문 사용하기
		//	2.1 유효성 검사를 위해 0~100 if문 만들기
		//	2.2 유효성 검사 if문 안에 점수 별로 성적 출력하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("점수:");
		int score = Integer.parseInt(reader.readLine());
		
		if (score <= 100 && score >= 0) {
			
			if (score >= 90) {
				System.out.printf("입력한 %d점은 성적 A입니다.", score);
			} else if (score >= 80) {
				System.out.printf("입력한 %d점은 성적 B입니다.", score);				
			} else if (score >= 70) {
				System.out.printf("입력한 %d점은 성적 C입니다.", score);								
			} else if (score >= 60) {
				System.out.printf("입력한 %d점은 성적 D입니다.", score);												
			} else {
				System.out.printf("입력한 %d점은 성적 F입니다.", score);																
			}
			
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100사이의 값을 입력하시오.");
		}
	}

}
