package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 시간 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 들어온 시간 입력
		//	1.3 나간 시간 입력
		
		//2. 30분 이상 초과되는 금액 구하기 if문 작성
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("[들어온 시간]");
		System.out.print("시:");
		int inHour = Integer.parseInt(reader.readLine());
		System.out.print("분:");
		int inMin = Integer.parseInt(reader.readLine());
		
		System.out.println("[나간 시간]");
		System.out.print("시:");
		int outHour = Integer.parseInt(reader.readLine());
		System.out.print("분:");
		int outMin = Integer.parseInt(reader.readLine());
		
		if (outMin - inMin < 0) {
			int time = (outHour - inHour - 1) * 60 + (outMin - inMin + 60);
			amount(time);
		} else {
			int time = (outHour - inHour) * 60 + (outMin - inMin);
			amount(time);
		}
	}//main
	
	public static void amount(int time) {
		
		if (time >=0 && time <= 30) {
			System.out.println("주차 요금은 0원입니다.");
		} else {
			int amount = (time - 30) / 10 * 2000;
			System.out.printf("주차 요금은 %,d원입니다.", amount);				
		}
		
	}

}
