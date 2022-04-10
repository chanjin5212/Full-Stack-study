package com.test.java.question.iteration;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 버퍼드리더 생성
		//2. 이름, 횟수 입력받기
		//3. for문 이용하여 횟수에 맞게 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름:");
		String name = reader.readLine();
		
		System.out.print("횟수:");
		int conut = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<conut; i++) {
			System.out.printf("%s님 안녕하세요~\n", name);
		}
		
	}

}
