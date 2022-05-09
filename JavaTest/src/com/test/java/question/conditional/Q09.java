package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 년도 입력받기
		//	1.1 버퍼드리더 생성
		//	1.2 년도 입력받기
		
		//2. if문 생성
		//	2.1 a 조건 if문 생성
		//	2.2 b 조건 if문 생성
		//	2.3 c 조건 if문 생성
		//3. 최종 값 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("년도 입력:");
		int year = Integer.parseInt(reader.readLine());
		
		if (year % 4 == 0) {
			
			if (year % 100 == 0) {
				
				if (year % 400 == 0) {
					System.out.printf("%d년은 '윤년'입니다.", year);
				} else {
					System.out.printf("%d년은 '평년'입니다.", year);
				}
			} else {
				System.out.printf("%d년은 '윤년'입니다.", year);
			}
			
		} else {
			System.out.printf("%d년은 '평년'입니다", year);
		}
		
	}//main

}
