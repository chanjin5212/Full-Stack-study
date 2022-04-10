package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("주민등록번호:");
		String jumin = reader.readLine();
		jumin = jumin.replace("-", ""); // "-" 를 먼저 제거해서 "-" 상관없이 하기
		
		int sum = 0;
		int a = 2;
		for (int i=0; i<12; i++) {
			sum += Integer.parseInt(jumin.substring(i, i+1)) * a;
			a++;
			if (a > 9) {
				a = 2;
			}
		}
		int b = 11 - (sum % 11);
		if(b >= 10) {
			b = b % 10;
		}
		
		if (b == Integer.parseInt(jumin.substring(jumin.length()-1, jumin.length()))) {
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
	}

}
