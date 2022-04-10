package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력:");
		String str = reader.readLine();
		
		String[] word = { "바보", "멍청이" }; //금지어 목록
		
		int count = 0; // 마스킹 한 횟수
		for (int i=0; i<word.length; i++) {
			if (str.contains(word[i])) {
				count += (str.length() - str.replace(word[i], "").length()) / word[i].length(); // 금지어 들어있는 갯수
				str = str.replace(word[i], m1(word[i]));
			}
		}
		System.out.println(str);
		System.out.printf("금지어를 %d회 마스킹했습니다.", count);
		
	}//main
	public static String m1(String a) { // 글자 갯수에 맞게 * 찍어주는 메소드
		
		String result = "";
		for (int i=0; i<a.length(); i++) {
			result += "*";	
		}
		return result;
		
		
		
	}
}
