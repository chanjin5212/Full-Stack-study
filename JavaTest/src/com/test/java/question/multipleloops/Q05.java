package com.test.java.question.multipleloops;

public class Q05 {
	
	public static void main(String[] args) {
		
		//1. 2중 for문 사용
		
		for (int i=1; i<=9; i++) {
			
			for (int j=2; j<=9; j++) {
				System.out.printf("%d x %d = %d\t", j, i, j * i);
			}
			System.out.println();
		}
		
	}

}
