package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력:");
		String str = reader.readLine();   //'0'~'9'  48~57
		
		int sum = 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) >= 48 && str.charAt(i) <= 57) {
				sum += str.charAt(i) - '0';
			} else {
				continue;
			}
		}
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %d 입니다.", sum);
	}
	

}
