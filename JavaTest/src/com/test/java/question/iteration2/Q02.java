package com.test.java.question.iteration2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 버퍼드리더 생성
		//2. while문 사용을 위한 변수 n 생성, 문자열 저장할 변수 num 생성
		//3. n < 10 조건으로 while문 생성
		//4. 숫자에 따른 조건 switch문으로 생성
		//5. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 0;
		String num = "";
		while (n < 10) {
			
			System.out.print("숫자:");
			String inputNum = reader.readLine();
			if (Integer.parseInt(inputNum) > 0 && Integer.parseInt(inputNum) < 10) {
				switch(inputNum) {
					case "1":
						num += "일";
						break;
					case "2":
						num += "이";
						break;
					case "3":
						num += "삼";
						break;
					case "4":
						num += "사";
						break;
					case "5":
						num += "오";
						break;
					case "6":
						num += "육";
						break;
					case "7":
						num += "칠";
						break;
					case "8":
						num += "팔";
						break;
					case "9":
						num += "구";
						break;
				}
				n++;	
			} else {
				System.out.println("1~9사이의 값이 아닙니다.");
				break;
			}
		}
		System.out.println(num);
		
	}

}
