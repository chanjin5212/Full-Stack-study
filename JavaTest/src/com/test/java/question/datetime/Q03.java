package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q03 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 태어난 년도 입력하기(버퍼드리더 생성)
		//2. 오늘 날짜 받기
		//3. get 이용하여 올해 나이 계산
		//4. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도:");
		
		int birth = Integer.parseInt(reader.readLine());
		
		Calendar now = Calendar.getInstance();
		
		int age = now.get(Calendar.YEAR) - birth + 1;
		
		System.out.printf("나이:%d세", age);
		
		
	}

}
