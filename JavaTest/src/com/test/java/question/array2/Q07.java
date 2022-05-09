package com.test.java.question.array2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q07 {
	
	public static void main(String[] args) throws Exception {
	
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String[][] score = new String[10][3];
		
		System.out.print("국어 점수:");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수:");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수:");
		int math = Integer.parseInt(reader.readLine());
		
		for (int i=0; i<3; i++) {
			switch(i) {
				case 0:
					for (int j=(10-kor/10); j<10; j++) {
						score[j][i] = "■";
					}
					break;
				case 1:
					for (int j=(10-eng/10); j<10; j++) {
						score[j][i] = "■";
					}
					break;
				case 2:
					for (int j=(10-math/10); j<10; j++) {
						score[j][i] = "■";
					}
					break;
			}
		}
		
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<3; j++) {
				if (score[i][j] == null) {
					System.out.printf("%5s", "");
					
				} else {
					
					System.out.printf("%5s", score[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("   -------------");
		System.out.println("   국어  영어  수학");
		
		
	}//main
	
	

}
