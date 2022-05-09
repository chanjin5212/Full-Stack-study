package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Test {

	public static void main(String[] args) throws Exception {
		
		//연산자 수업 연장 > 일부 테스트
		
		//요구사항] 사용자 키보드 입력 > 문자 1개 > 영어 소문자인지 검사?
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("영소문자 입력: ");
		String input = reader.readLine();
		
		System.out.println("입력된 문자: " + input);
		
		//입력한 문자의 문자코드값??
		//String -> int : 참조형과 값형끼리는 형변환 불가능
		//System.out.println((int)input);
		
		//String -> char -> int
		char c = input.charAt(0); //"a" -> 'a'
		
		int code = (int)c;
		
		System.out.println(code);
		System.out.println();
		
		//영소문자? > a(97) ~ z(122)
		System.out.println(code >= 97); //true
		System.out.println(code <= 122);//true
		
		System.out.println(code >= 97 && code <= 122); //true
		
		System.out.println(code >= (int)'a');
		System.out.println(code <= (int)'z');
		
		//char 자료형은 우위 비교가 가능하다. > 내부적으로 숫자라서..
		System.out.println('f' >= 'a');
		System.out.println('f' <= 'z');
		
		
		//String 자료형은 우위 비교가 불가능하다.
		//System.out.println("f" >= "a");
		
		
		
		
		
	}
	
}
























