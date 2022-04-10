package com.test.java.question.iteration;

public class Test {

	public static void main(String[] args) {
		
		//12의 약수: 1, 2, 3, 4, 6, 12
		//8의 약수: 1, 2, 4, 8
		//12와 8의 공약수: 1, 2, 4
		
		int a = 12;
		int b = 8;
		
		for (int i=1; i<=a; i++) {
			
			if (a % i == 0) {
				System.out.printf("%3d", i);
			}
			
		}
		System.out.println();
		
		for (int i=1; i<=b; i++) {
			
			if (b % i == 0) {
				System.out.printf("%3d", i);
			}
			
		}
		System.out.println();
		
		
		//8
		
		int min = a < b ? a : b;
		
		for (int i=1; i<=min; i++) { //두 숫자 중 작은 수(12 vs 8)
			
			if (b % i == 0 && a % i == 0) { //공약수
				
				System.out.printf("%3d", i);
			}
			
		}
		
		
	}
	
}
































