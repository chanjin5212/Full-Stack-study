package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q05 {

	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 최대,최소 범위 입력받기
		//3. 4번과 비슷하나 마지막에 if문을 이용하여 최대,최소 범위내 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위:");
		int max = Integer.parseInt(reader.readLine());
		System.out.print("최소 범위:");
		int min = Integer.parseInt(reader.readLine());

		int[] random = new int[20];

		for (int i=0; i<random.length; i++) {

			random[i] = (int) (Math.random() * 20 + 1);

		}
		System.out.print("원본 : ");
		for (int i=0; i<random.length; i++) {
			System.out.printf("%d, ", random[i]);

		}
		System.out.print("\b\b\n");
		
		System.out.print("결과 : ");
		for (int i=0; i<random.length; i++) {
			
			if (random[i] >= min && random[i] <= max) {
				System.out.printf("%d, ", random[i]);
				
			}
		}
		System.out.print("\b\b");
		
	}//main

}
