package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception{
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//횟수 입력받아 정수로 바꾸기
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		String num = reader.readLine();
		int num1 = Integer.parseInt(num);
		
		//거리 계산
		double num2 = num1 * 3.141 * 0.6604; // 26인치 = 0.6604m

		//출력
		System.out.printf("사용자가 총 %d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", num1, num2);
		
		
	}

}
