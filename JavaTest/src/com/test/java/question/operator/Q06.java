package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q06 {
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//수입 입력받아 정수로 바꾸기
		System.out.print("한달 수입 금액(원) : ");
		String income = reader.readLine();
		int income1 = Integer.parseInt(income);
		
		//계산하면서 출력
		System.out.printf("세후 금액(원) : %,.0f원\n", income1 * 0.967);
		System.out.printf("세금(원) : %,.0f원", income1 * 0.033);
	}

}
