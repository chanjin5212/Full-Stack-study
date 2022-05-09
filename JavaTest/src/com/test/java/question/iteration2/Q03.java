package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 최대숫자 입력받기
		//3. 최대숫자까지의 while문 생성(1씩 증가하는 i 변수 생성)
		//4. 369 규칙에 맞는 if문 생성
		//5. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("최대 숫자:");
		int num = Integer.parseInt(reader.readLine());
		
		int i = 1;
		while (i <= num) {
			
			if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9 || i / 10 == 3 || i / 10 == 6
					|| i / 10 == 9 || i / 100 == 3 || i / 100 == 6 || i / 100 == 9) {
				
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			}
			i++;
		}
		
	}//main

}
