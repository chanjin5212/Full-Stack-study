package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자:");
		String num = reader.readLine();
		
		int a = num.length() / 3;
		int b = num.length() % 3;
		if (b == 0) {
			b = b + 3;
			a = a - 1;
		}
		String num1 = "";
		for (int i=0; i<=a; i++) {
			if (i == 0) {
				num1 += num.substring(0, b) + ",";	
			} else if (i == a) {
				num1 += num.substring(b, b+3);
			} else {
				num1 += num.substring(b, b+3) + ",";
				b += 3;
			}	
		}
		System.out.println(num1);
	}

}
