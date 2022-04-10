package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		//섭씨 온도 입력받아 정수로 바꾸기
		System.out.print("섭씨(℃) : ");
		String c_temperature = reader.readLine();
		int c_temperature1 = Integer.parseInt(c_temperature);
		
		//화씨 온도 구하기
		double f_temperature = c_temperature1 * 1.8 + 32;
		
		//출력
		System.out.printf("섭씨 %d℃는 화씨 %.1f℉입니다.", c_temperature1, f_temperature);
	
	
	
	
	
	
	
	
	}

}
