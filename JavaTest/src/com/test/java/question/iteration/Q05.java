package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 시작, 종료 숫자 입력받기
		//3. sum 변수 만들어서 더하는 값 받기
		//4. for 이용하여 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자:");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자:");
		int endNum = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (int i=startNum; i<=endNum; i++) {
			
			if (i == endNum) {
				System.out.printf("%d = ", i);
				sum += i;
			} else {
				System.out.printf("%d + ", i);
				sum += i;
			}
		}
		
		System.out.print(sum);
		
		
	
	}

}
