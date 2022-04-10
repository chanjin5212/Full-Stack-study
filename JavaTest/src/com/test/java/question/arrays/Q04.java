package com.test.java.question.arrays;

import java.util.Arrays;

public class Q04 {
	
	public static void main(String[] args) {
		
		//1. 20 크기의 배열 생성
		//2. for 문 이용하여 20개의 난수 배열에 대입
		//3. 배열 오름차순으로 정리
		//4. 배열[0] 최소값 배열[배열의 최대크기] 최대값으로 출력
		
		int[] random = new int[20];
		
		for(int i=0; i<random.length; i++) {
			
			random[i] = (int)(Math.random() * 20 + 1);
			
		}
		System.out.print("원본 : ");
		for (int i=0; i<random.length; i++) {
			System.out.printf("%d, ", random[i]);
		
		}
		System.out.print("\b\b\n");
		Arrays.sort(random);
		
		System.out.printf("최대값 : %d\n", random[random.length - 1]);
		System.out.printf("최소값 : %d\n", random[0]);
		
	}
}