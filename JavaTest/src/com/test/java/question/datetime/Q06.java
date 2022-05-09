package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q06 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 값 입력받기(버퍼드리더 생성)
		//2. 입력받은 시간 대입
		//3. 짜장면, 치킨, 피자에 맞는 계산식 생성
		//4. 출력
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시간");
		System.out.print("시:"); // 오후 11시 이후로 에러메시지 띄우기
		int hour = Integer.parseInt(reader.readLine());
//		String error = hour >= 23 ? "영업 시간이 지났습니다." : "";
//		System.out.println(error);
		System.out.print("분:");
		int min = Integer.parseInt(reader.readLine());
		
		
		
		Calendar time = Calendar.getInstance();
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, min);
		
//		int jajangHour = (min - 10) < 0 ? hour - 1 : hour;
//		int jajangMin = (min - 10) < 0 ? min + 60 - 10 : min - 10;
//		
//		int chickenHour = (min - 18) < 0 ? hour - 1 : hour;
//		int chickenMin = (min - 18) < 0 ? min + 60 - 18 : min - 18;
//		
//		int pizzaHour = (min - 25) < 0 ? hour - 1 : hour;
//		int pizzaMin = (min - 25) < 0 ? min + 60 - 25 : min - 25;
		
		time.add(Calendar.MINUTE, -10);
		System.out.printf("짜장면:%d시 %d분\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
		
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, min);
		time.add(Calendar.MINUTE, -18);
		System.out.printf("치킨:%d시 %d분\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
		
		time.set(Calendar.HOUR_OF_DAY, hour);
		time.set(Calendar.MINUTE, min);
		time.add(Calendar.MINUTE, -25);
		System.out.printf("피자:%d시 %d분\n", time.get(Calendar.HOUR_OF_DAY), time.get(Calendar.MINUTE));
		
		
		
	}

}
