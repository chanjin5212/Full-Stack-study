package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws Exception{
		

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//너비, 높이 입력받아 정수로 바꾸기
		System.out.print("너비(cm):");
		String width = reader.readLine();
		int width1 = Integer.parseInt(width);
		System.out.print("높이(cm):");
		String height = reader.readLine();
		int height1 = Integer.parseInt(height);
		
		//출력
		System.out.printf("사각형의 넓이는 %dcm²입니다.\n", width1 * height1);
		System.out.printf("사각형의 둘레는 %dcm입니다.\n", 2 * (width1 + height1));
	}

}
