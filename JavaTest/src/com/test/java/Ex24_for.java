package com.test.java;

import java.util.ArrayList;

public class Ex24_for {
	
	public static void main(String[] args) {
		
		//Ex24_for.java
		
		//m1();
		//m2();
		//m3();
		
		//지역변수
		//m4();
		
		//m5();
		
		//m6();
		//m7();
		
		m8();
		
		
		
		
	}//main

	private static void m8() {
		
		//별찍기(5x5)
		for (int i=0; i<5; i++) { //행 만들기
			for (int j=0; j<5; j++) { //열 만들기
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
		
		for (int i=0; i<5; i++) { //행(변화X)
			for (int j=i; j<5; j++) { //열(변화O 5 -> 1)
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
		
		for (int i=0; i<5; i++) { //행 만들기
			for (int j=0; j<=i; j++) { //열 만들기(1 -> 5)
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i=0; i<5; i++) { //행 만들기
			
			for (int j=0; j<(4-i); j++) {
				System.out.print(" ");
			}
			
			for (int j=0; j<=i; j++) { //열 만들기
				System.out.print("*");	
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void m7() {
		
		for (int i=0; i<10; i++) {
			
			for (int j=0; j<10; j++) {
				
				if (i == 5 || j == 5) {
					//break, continue는 자신이 직접 포함된 제어문만 탈출한다.
					break; 
				}
				
				System.out.printf("i: %d, j: %d\n", i, j);
				
			}
			
		}
		
	}

	private static void m6() {
		
		for (int i=0; i<10; i++) {
			
			for (int j=0; i<10; j++) {
				
				System.out.printf("i: %d, j: %d\n", i, j);
				
			}
			
		}
		
	}

	private static void m5() {
		
		//구구단
		//- 2단 ~ 9단 출력
		
		for (int dan=2; dan<=9; dan++) {
		
			//int dan = 2;
			
			System.out.println("==========");
			System.out.printf("    %d단\n", dan);
			System.out.println("==========");
			
			for (int i=1; i<=9; i++) {
				
				System.out.printf("%d x %d = %2d\n", dan, i, dan * i);
				
			}
			
			System.out.println();
			
		}
		
		
	}

	private static void m4() {
		
		//지역 변수
		//- 메소드와 제어문내에서 선언한 변수
		
		if (true) {
			int a = 10;
			System.out.println(a); //10
		}
		
		if (true) {
			int a = 20;
			System.out.println(a); //20
		}
		
		//System.out.println(a);
		
	}

	private static void m3() {
		
		//학교
		
		for (int k=1; k<=3; k++) { //학년 루프
		
			for (int j=1; j<=10; j++) { //반 루프
			
				for (int i=1; i<=30; i++) { //학생 루프
					
					System.out.printf("%d학년 %d반 %d번 학생\n", k, j, i);
					
				}
				
			}
			
		}

		
	}

	private static void m2() {
		
		/*
		
			제어문 중첩
			- 모든 제어문은 종류에 상관없이 서로 중첩할 수 있다.
			
			
			for문(반복문)끼리 중첩
			- 다중 반복문
			- 단일 for문
			- 2중 for문
			- 3중 for문
		
		*/
		
		//단일 for문
		for (int i=0; i<10; i++) {
			System.out.println("i: " + i);
		}
		
		
		//2중 for문
		for (int i=0; i<10; i++) { //대회전
			
			for (int j=0; j<10; j++) { //소회전
			
				//System.out.println("안녕하세요."); //몇번 실행?
				System.out.printf("i: %d, j: %d\n", i, j);
				
			}
			
		}
		
		
		//3중 for문
		for (int i=0; i<24; i++) { //시침
			
			for (int j=0; j<60; j++) { //분침
				
				for (int k=0; k<60; k++) { //초침
					
					System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
					
				}					
				
			}
			
		}
		
		
		
	}

	private static void m1() {

		//do while문
		
		/*
		 
		  
		  	int num = 10;
		  	
		  	
		  	//선조건 후반복(실행)
		
			while (num < 0) {
				실행문;
			}
			
			
			//선실행(반복) 후조건
			
			do {
				실행문;
			} while (num < 0);
			
					
		*/
		
		int num = 100;
		
		do {
			
			System.out.println(num);
			num++;
			
		} while (num < 10);
		
	} //m1

}


































