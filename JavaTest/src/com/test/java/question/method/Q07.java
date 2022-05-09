package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 탑승 소요시간을 구하는 메소드 생성
		//2. 입력받을 버퍼드리더 생성
		//3. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수:");
		int station = Integer.parseInt(reader.readLine());
		System.out.print("환승역의 횟수:");
		int change = Integer.parseInt(reader.readLine());
		System.out.print("시간대(1.평상시, 2.출근시, 3.퇴근시):");
		int time = Integer.parseInt(reader.readLine());
		
		int result = getTime(station, change, time);
		System.out.printf("총 소요 시간은 %d분입니다.", result);
		
		
	}
	
	public static int getTime(int station, int change, int time) {
		
		String change_time = time == 1 ? "3" : time == 2 ? "4" : time == 3 ? "5" : "잘못 입력"; 
		
		int result = (station * 2) + (change * Integer.parseInt(change_time));
		
		return result;
		
	}

}
