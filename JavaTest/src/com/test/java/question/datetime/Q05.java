package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q05 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 값 입력받기(버퍼드리더 생성)
		//2. 입력받은 아빠의 날짜 대입
		//3. 입력받은 딸의 날짜 대입
		//4. getTimeInMillis() 이용하여 일수 계산
		//5. 출력
		
		
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년):");
		int dadYear = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(월):");
		int dadMonth = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(일):");
		int dadDate = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(년):");
		int daughterYear = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(월):");
		int daughterMonth = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(일):");
		int daughterDate = Integer.parseInt(reader.readLine());
		
		Calendar dadTime = Calendar.getInstance();
		dadTime.set(dadYear, dadMonth, dadDate);
		
		Calendar daughterTime = Calendar.getInstance();
		daughterTime.set(daughterYear, daughterMonth, daughterDate);
		
		long time = (daughterTime.getTimeInMillis() - dadTime.getTimeInMillis()) / 1000 / 60 / 60 / 24;
		
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", time);
		
	}
}
