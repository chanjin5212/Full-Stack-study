package com.test.java.question.multipleloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		//1,2번 문제와 동일하게 진행하나 *찍는 부분을 2배로 늘린다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행:");
		int row = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<row; i++) {
			
			for (int j=row-1; j>i; j--) {
				System.out.print(" ");
			}
			for (int j=0; j<i*2+1; j++) {
				System.out.print("*");
			}
			System.out.println();
			
			
		}
		
	}

}
