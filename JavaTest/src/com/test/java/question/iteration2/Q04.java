package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//3. while문을 1부터 9까지 실행
		//4. 각 자릿수와 짝수의 합, 홀수의 합을 담을 변수 생성
		//5. inputNum / (int)Math.pow(10, num - 1) % 10 을 이용하여 각 자릿수 획득
		//6. 짝수, 홀수 판단하는 if문 생성하여 합 계산
		//7. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력:");
		int inputNum = Integer.parseInt(reader.readLine());
		int num = 1;
		int division = 0;
		int evenSum = 0;
		int oddSum = 0;
		while (num <= 9) {
			
			division = inputNum / (int)Math.pow(10, num - 1) % 10;
			
			if (division % 2 == 0) {
				evenSum += division;
			} else {
				oddSum += division;
			}
			
			num++;
		}
		System.out.printf("짝수의 합 : %d\n", evenSum);
		System.out.printf("홀수의 합 : %d\n", oddSum);
		
	}//main
	

}
