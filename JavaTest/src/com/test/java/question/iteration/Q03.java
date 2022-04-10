package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//3. sum 변수 생성하여 더하는 숫자 저장
		//4. for문 이용하여 숫자 더하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자:");
		int num = Integer.parseInt(reader.readLine());
		
		int sum = 0;
		
		for (int i=1; i<=num; i++) {
			sum += i;
		}
		
		System.out.printf("1~%d = %d", num, sum);
	}

}
