package com.test.java.question.datetime;

import java.util.Calendar;

public class Q02 {
	
	public static void main(String[] args) {
		
		//1. 오늘의 날짜 입력
		//2. 오늘의 날짜에 100일 더하는 add 생성 후 출력
		//3. 오늘의 날짜에 1년 더하는 add 생성 후 출력
		
		Calendar now = Calendar.getInstance();
		
		now.add(Calendar.DATE, 100);
		
		System.out.printf("백일:%tF\n", now);
				
		now = Calendar.getInstance();
		
		now.add(Calendar.YEAR, 1);
		
		System.out.printf("첫돌:%tF\n", now);
	}

}
