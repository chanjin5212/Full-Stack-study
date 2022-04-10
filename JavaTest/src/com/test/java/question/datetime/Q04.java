package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q04 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 값 입력받기(버퍼드리더 생성)
		//2. 입력받은 값으로 날짜 대입
		//3. 100, 200, 300, 500, 1000에 맞는 계산하기(add)
		//4. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름:");
		String manName = reader.readLine();
		
		System.out.print("여자 이름:");
		String womanName = reader.readLine();
		
		System.out.print("만난날(년):");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("만난날(월):");
		int month = Integer.parseInt(reader.readLine());
		
		System.out.print("만난날(일):");
		int date = Integer.parseInt(reader.readLine());
		
		System.out.printf("'%s'과(와) '%s'의 기념일\n",manName, womanName);
		
		time(year, month, date, 100);
		time(year, month, date, 200);
		time(year, month, date, 300);
		time(year, month, date, 500);
		time(year, month, date, 1000);
	}//main
	
	public static void time(int year, int month, int date, int time) { //메소드 생성
		
		Calendar dateTime = Calendar.getInstance();
		dateTime.set(year, month, date);
		
		dateTime.add(Calendar.DATE, time);
		System.out.printf("%d일:%tF\n", time, dateTime);
		
	}
	
}
