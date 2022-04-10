package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력:"); 
		String str = reader.readLine();
		
		str = str.replace(" ", "");
		String[] result = str.split("\\+|-|/|\\*|%"); //정규식 표현 (+ 와 *는 원래의 뜻이 있기때문에 \\ 붙이기)
		
		if (!str.contains("+")  
			&& !str.contains("-")  
			&& !str.contains("*") 
			&& !str.contains("/") 
			&& !str.contains("%") ) {
			System.out.println("연산자가 올바르지 않습니다.");
			
		} else if (result.length < 2 || result[0].equals("")) {
			System.out.println("피연산자가 부족합니다.");
			
		} else {
			int resNum = 0;
			if (str.contains("+")) {
				resNum = Integer.parseInt(result[0]) + Integer.parseInt(result[1]);
				System.out.printf("%s + %s = %d\n", result[0], result[1], resNum);
				
			} else if (str.contains("-")) {
				resNum = Integer.parseInt(result[0]) - Integer.parseInt(result[1]);
				System.out.printf("%s - %s = %d\n", result[0], result[1], resNum);
				
			} else if (str.contains("*")) {
				resNum = Integer.parseInt(result[0]) * Integer.parseInt(result[1]);
				System.out.printf("%s * %s = %d\n", result[0], result[1], resNum);
				
			} else if (str.contains("/")) {
				resNum = Integer.parseInt(result[0]) / Integer.parseInt(result[1]);
				System.out.printf("%s / %s = %d\n", result[0], result[1], resNum);
				
			} else if (str.contains("%")) {
				resNum = Integer.parseInt(result[0]) % Integer.parseInt(result[1]);
				System.out.printf("%s %% %s = %d\n", result[0], result[1], resNum);			
			}	
		}	
	}

}
