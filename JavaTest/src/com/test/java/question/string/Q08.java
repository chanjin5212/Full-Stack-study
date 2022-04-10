package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("단어:");
		String word = reader.readLine(); // 65~90
		
		String[] result = word.split("[A-Z]"); //정규식 표현 [A-Z] 를 이용하여 A~Z까지를 찾을 수 있음.
		// -> StudentName 입력시 result = { tudent, ame };
		int[] result1 = new int[result.length-1]; 
		for (int i=1; i<result.length; i++) {
			result1[i-1] = word.indexOf(result[i])-1;
		}
		String result2 = "";
		for (int i=0; i<result1.length; i++) {
			if (i == result1.length-1) {
				result2 += word.substring(result1[i], word.length()) + " ";
			} else {
				result2 += word.substring(result1[i], result1[i+1]) + " ";				
			}
		}
		System.out.println("결과:" + result2 + "\b");
		
	}

}
