package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자:");
		String num = reader.readLine();
		
		int sum = 0;
		System.out.print("결과:");
		for (int i=0; i<num.length(); i++) {
			System.out.print(num.charAt(i) + " + ");
			sum += Integer.parseInt(num.substring(i, i+1));
		} // charAt(i)로 계산하려면 - '0' 해주기
		System.out.printf("\b\b= %d", sum);
	}

}
