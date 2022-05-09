package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 날짜 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 년,월,일 입력받기
		
		//2. 입력한 날짜의 요일 구하기
		//	2.1 Calendar 이용하여 그날의 요일 구하기
		//	2.2 해당하는 주의 토요일 구하기
		//	2.3 토,일요일이면 결과 없음 출력
		
		//3. 완성된 값 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년:");
		int year = Integer.parseInt(reader.readLine());
		System.out.print("월:");
		int month = Integer.parseInt(reader.readLine());
		System.out.print("일:");
		int date = Integer.parseInt(reader.readLine());
		
		Calendar dateTime = Calendar.getInstance();
		dateTime.set(year, month - 1, date);
		
		int dateWeek = dateTime.get(Calendar.DAY_OF_WEEK);
		if (dateWeek >= 2 && dateWeek <= 6) {
			System.out.println("입력하신 날짜는 '평일'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
			dateTime.add(Calendar.DAY_OF_WEEK, 7 - dateWeek);
			System.out.printf("이동한 날짜는 '%tF'입니다.", dateTime);
		} else {
			System.out.println("입력하신 날짜는 '휴일'입니다.");
			System.out.println("결과가 없습니다.");
		}
		
	}

}
