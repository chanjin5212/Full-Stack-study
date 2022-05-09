package com.test.java.question.iteration;

public class Q07 {
	
	public static void main(String[] args) {
		
		//1. 더한값을 입력받는 sum 변수 생성
		//2. 숫자를 더하는 for문 생성
		//3. 1000이 넘었을때 종료하는 if문 생성
		
		int sum = 0;
		
		for (int i=1; ; i++) {
			
			sum += i;
			
			if (sum > 1000) {
				System.out.printf("%d = %d", i, sum);
				break;
			} else {
				System.out.printf("%d + ", i);
			}
		}
		
	}

}
