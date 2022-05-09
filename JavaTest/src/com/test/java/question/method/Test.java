package com.test.java.question.method;

public class Test {
	
	public static void main(String[] args) {
		
		int kor = 100;
		int eng = 100;
		int math = 10;
		
		//System.out.println((kor + eng + math) / 3);

		
		//Type A.
		int result = 0; //초기값
		
		result += (((kor + eng + math) / 3 > 60) ? 1 : 0); //첫번째 조건
		
		result += (kor >= 40 && eng >= 40 && math >= 40) ? 1 : 0; //두번째 조건
		
		
		//System.out.println(result); //2
		
		System.out.println((result == 2) ? "합격" : "불합격");
		
		
		
		//Type B.
		System.out.println((kor >= 40 && eng >= 40 && math >= 40) ? (((kor + eng + math) / 3 > 60) ? "합격" : "불합격") : "불합격");
		
	}

}


















