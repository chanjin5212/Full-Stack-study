package com.test.java.question.multipleloops;

public class Q09 {
	
	public static void main(String[] args) {
		
		//1. 10씩 커지는 for문 생성
		//2. 더한 값 저장할 sum 변수 생성
		//3. 다중 for문으로 i 까지의 더한값 구하기
		//4. 출력
		
		for (int i=10; i<=100; i+=10) {
			int sum = 0;
			for (int j=1; j<=i; j++) {
				sum += j;
			}
			System.out.printf("1 ~ %3d : %4d\n", i, sum);
		}
		
		
	}

}
