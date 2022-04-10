package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//태어난 년도 입력받아 정수로 바꾸기
		System.out.print("태어난 년도:");
		String age = reader.readLine();
		int age1 = Integer.parseInt(age);
		
		//출력
		System.out.println("나이:" + (2022 - age1 + 1));
		
		
	}

}
