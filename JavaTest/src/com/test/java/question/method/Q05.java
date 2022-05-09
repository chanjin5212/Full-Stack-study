package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 짝수, 홀수 반환 메소드 만들기
		//2. 입력받을 버퍼드리더 생성
		//3. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자:");
		int n = Integer.parseInt(reader.readLine());
		
		String result;
		result = getNumber(n); 
		System.out.printf("입력하신 숫자 '%d'는(은) '%s'입니다.\n", n, result);
	}
	
	public static String getNumber(int num) {
		
		String result = num % 2 == 0 ? "짝수" : "홀수";
		
		return result;
	}

}
