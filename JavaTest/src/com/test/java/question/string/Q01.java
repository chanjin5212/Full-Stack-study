package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q01 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력:");
		String str = reader.readLine();
		
		
		System.out.print("\"");
		for (int i=str.length()-1; i>=0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.print("\"");
		
	}
	
	

}
