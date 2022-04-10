package com.test.java.question.multipleloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. 행 입력받기
		//3. 다중for문 사용하여 *출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행:");
		int row = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<row; i++) {
			
			for (int j=row-1; j>i; j--) {
				System.out.print(" ");
			}
			for (int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
