package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 점수 평균 내는 메소드 만들기
		//2. 입력받을 버퍼드리더 생성
		//3. 출력

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어:");
		int kor = Integer.parseInt(reader.readLine());
		
		System.out.print("영어:");
		int eng = Integer.parseInt(reader.readLine());
		
		System.out.print("수학:");
		int math = Integer.parseInt(reader.readLine());
		
		String result = test(kor, eng, math);
		System.out.println(result);
		
		
	}
	
	public static String test(int kor, int eng, int math) {
		
		String result =  (kor < 40 || eng < 40 || math < 40) ? "불합격입니다." : (kor + eng + math) / 3 >=60 ? "합격입니다" : "불합격입니다."; 
		
		return result;
		
	}
}
