package com.test.java.question.multipleloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 행갯수 입력받기
		//3. 다중 for문 이용하여 * 생성
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행:");
		int row = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<row; i++) {
			
			for (int j=0; j<i; j++) {
				System.out.print(" ");
				
			}
			for (int j=row; j>i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
