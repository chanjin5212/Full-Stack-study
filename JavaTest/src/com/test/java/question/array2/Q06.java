package com.test.java.question.array2;

public class Q06 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		//1~16 대입
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				nums[i][j] = n;
				n++;
			}
		}
		
		//4행에 더한 값 대입
		for (int i=0; i<5; i++) {
			for (int j=0; j<4; j++) {
				nums[i][4] += nums[i][j];
			}
		}
		
		//4열에 더한 값 대입
		for (int i=0; i<5; i++) {
			for (int j=0; j<4; j++) {
				nums[4][i] += nums[j][i];
			}
		}
		
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}

}
