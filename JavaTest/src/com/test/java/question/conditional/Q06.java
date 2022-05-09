package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		//A~z 65 ~ 122 a = 97 A = 65
		
		//1. 문자 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 문자 입력받기
		
		//2. 유효성 검사 if문 생성(A~z 가 65~122)
		//	2.1 if문 안에 출력할 if문 생성
		//	2.2 else 생성하고 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자:");
		int str = reader.readLine().charAt(0);
		
		if (str >= 65 && str <= 122) {
			
			if (str >= 65 && str < 97) {
				System.out.printf("'%c'의 소문자는 '%c'입니다.", str, str + 32);
			} else if (str >= 97 && str <= 122) {
				System.out.printf("'%c'의 대문자는 '%c'입니다.", str, str - 32);				
			}
		} else {
			System.out.println("영문자만 입력하시오.");
		}
		
	}

}
