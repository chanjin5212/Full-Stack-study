package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 배열크기가 5인 조건 생성
		//3. for문 이용하여 5번 숫자 입력받아서 배열에 저장
		//4. for문 이용하여 배열 거꾸로 실행
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int[] nums = new int[5];
		
		for (int i=0; i<5; i++) {
			System.out.print("숫자:");
			int num = Integer.parseInt(reader.readLine());
			nums[i] = num;
		}
		
		for (int i=4; i>=0; i--) {
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
		}
		
	}

}
