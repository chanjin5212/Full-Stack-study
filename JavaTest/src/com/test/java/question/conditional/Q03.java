package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 문자 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 문자 입력하기
		
		//2. 유효성 검사 if문 생성
		//	2.1 생성된 if문 안에 조건에 맞는 if문 생성
		//	2.2 else 생성
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문자:");
		String str = reader.readLine();
		
		if (str.equals("f") || str.equals("F") || str.equals("m") || str.equals("M") || str.equals("s") || str.equals("S") ||
				str.equals("b") || str.equals("B")) {
			
			if (str.equals("f") || str.equals("F")) {
				System.out.println("Father");
			} else if (str.equals("m") || str.equals("M")) {
				System.out.println("Mother");
			} else if (str.equals("s") || str.equals("S")) {
				System.out.println("Sister");
			} else if (str.equals("b") || str.equals("B")) {
				System.out.println("Brother");
			}
			
		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		}
		
		
	}

}
