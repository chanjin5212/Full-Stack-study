package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 숫자 입력받기
		//3. 시작,종료 숫자의 크기가 어떤것이 더 큰지 if문으로 확인
		//4. for문 이용하여 숫자 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("시작 숫자:");
		int startNum = Integer.parseInt(reader.readLine());
		System.out.print("종료 숫자:");
		int endNum = Integer.parseInt(reader.readLine());
		System.out.print("증감치:");
		int count = Integer.parseInt(reader.readLine());
		
		if (startNum < endNum) {
			
			for (int i=startNum; i<=endNum; i=i+count) {
				System.out.println(i);
			}
			
		} else {
			
			for (int i=startNum; i>=endNum; i=i+count) {
				System.out.println(i);
			}
				
		}
		
	}//main

}
