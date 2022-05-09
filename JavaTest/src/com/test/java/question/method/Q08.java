package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q08 {
	
	public static void main(String[] args) throws Exception{
		
		//1. 사과 열리는 갯수를 구하는 메소드 생성
		//2. 입력받을 버퍼드리더 생성
		//3. 출력
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날:");
		int sunny = Integer.parseInt(reader.readLine());
		System.out.print("흐린 날:");
		int foggy = Integer.parseInt(reader.readLine());
		
		int result = getApple(sunny, foggy);
		System.out.printf("사과가 총 %d개 열렸습니다.", result);
		
	}
	
	public static int getApple(int sunny, int foggy) {
		
		int tree = (sunny * 5) + (foggy * 2);
		int apple = tree < 100 ? 0 : (tree - 100) / 10;
		
		return apple;
		
	}

}
