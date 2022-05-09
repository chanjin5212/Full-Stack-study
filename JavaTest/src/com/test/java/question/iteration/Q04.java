package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//3. 짝수, 홀수 더하는 값 변수 생성
		//4. 짝수, 홀수 구분하는 if생성
		//5. for문 이용하여 값 더하기
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 횟수:");
		int count = Integer.parseInt(reader.readLine());
		
		int even = 0;
		int odd = 0;
		int evenSum = 0;
		int oddSum = 0;
		
		for (int i=0; i<count; i++) {
			System.out.print("숫자:");
			int num = Integer.parseInt(reader.readLine());
			
			if (num % 2 == 0) {
				even += 1;
				evenSum += num;
			} else {
				odd += 1;
				oddSum += num;
			}
			
		}
		System.out.printf("짝수 %d개의 합 : %d\n", even, evenSum);
		System.out.printf("홀수 %d개의 합 : %d\n", odd, oddSum);
		
		
	}

}
