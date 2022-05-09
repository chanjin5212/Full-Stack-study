package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//	2.1 더한값 저장할 sum 과 문자열 num 생성
		//3. if 문으로 짝수,홀수 구분
		//4. 짝수나 홀수에 맞게 for문 더하기
		//5. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int sum = 0;
		
		String num = "";
		
		while (sum < 100) {
			
			System.out.print("숫자:");
			int inputNum = Integer.parseInt(reader.readLine());
			
			if (inputNum % 2 ==0) {
				sum += inputNum;
				if (inputNum == sum) {
					num += String.format("%d", inputNum);
				} else {					
					num += String.format(" + %d", inputNum);
				}
			} else {
				sum -= inputNum;
				if (-inputNum == sum) {
					num += String.format("%d", inputNum);
				} else {
					num += String.format(" - %d", inputNum);					
				}
			}
			
		}
		
		System.out.printf("%s = %d", num, sum);
		
	}

}
