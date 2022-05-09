package com.test.java.question.arrays;

public class Q03 {
	
	public static void main(String[] args) {
		
		//1. dump 메소드 생성
		//2. 입력받는 배열을 []식으로 반환하는 메소드 생성
		//3. 호출 입력후 출력
		
		int[] list = new int[4];

		list[0] = 10;
		list[1] = 20;
		list[2] = 30;
		list[3] = 40;

		String result = dump(list);
		System.out.printf("nums = %s\n", result);
		
		
	}//main
	
	public static String dump(int[] list) {
		
		String result = "";
		for (int i=0; i<list.length; i++) {
			
			result += list[i] + ", ";
		}
		return "[" + result + "\b\b" + "]";
	}

}
