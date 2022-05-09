package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//문자 입력받기
		System.out.print("문자 입력: ");
		String ch = reader.readLine();
		
		//대문자 정수로 계산
		int large = (int)ch.charAt(0) - 32;
		
		//출력
		System.out.printf("소문자 '%c'의 대문자는 '%c'입니다.", ch.charAt(0), (char)large);
		
		
	}

}
