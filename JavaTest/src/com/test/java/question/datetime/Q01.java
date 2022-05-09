package com.test.java.question.datetime;

import java.util.Calendar;

public class Q01 {
	
	public static void main(String[] args) {
		
		//1. 첫번째 메소드에 시간 구하는 메소드 생성
		//2. 두번째 메소드에 오전,오후 구분하는 시간 구하는 메소드 생성
		//3. 출력
		
		nowTime();
		nowTime1();
		
	}
	
	public static void nowTime() {
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%d시 %d분 %d초\n", now.get(Calendar.HOUR)
										   , now.get(Calendar.MINUTE)
										   , now.get(Calendar.SECOND));
		
	}
	
	public static void nowTime1() {
		
		Calendar now = Calendar.getInstance();
		
		System.out.printf("%s %d시 %d분 %d초\n",now.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
								             , now.get(Calendar.HOUR)
				                             , now.get(Calendar.MINUTE)
				                             , now.get(Calendar.SECOND));
		
	}

}
