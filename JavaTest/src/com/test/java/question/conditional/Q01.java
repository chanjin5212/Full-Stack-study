package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws Exception {
		
		//1. 숫자 2개를 입력받는다.
		//	1.1 버퍼드리더 생성
		//	1.2 숫자 2개 입력받기
		
		//2. if문 사용하기
		//	2.1 num1 이 num2보다 클때 계산하고 출력하기
		//	2.2 num2 이 num1보다 클때 계산하고 출력하기
		
		//3. else로 같은 값 출력하기
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자:");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자:");
		int num2 = Integer.parseInt(reader.readLine());
		
		if (num1 > num2) {
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다.", num1, num2, num1 - num2);
		} else if (num2 > num1) {
			System.out.printf("큰수는 %d이고, 작은수는 %d입니다. 두 숫자는 %d(가)이 차이납니다.", num2, num1, num2 - num1);			
		} else {
			System.out.println("두 숫자는 동일합니다.");
		}
		
	}

}
