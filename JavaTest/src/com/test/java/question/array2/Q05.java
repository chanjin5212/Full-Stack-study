package com.test.java.question.array2;

public class Q05 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		for (int i=0; i<5; i++) {
			
			if (i % 2 != 0) {
				for (int j=1; j<4; j++) {
					nums[i][j] = n;
					n++;
				}
			} else if (i == 0 || i == 4) {
				nums[i][2] = n;
				n++;
			} else {
				for (int j=0; j<5; j++) {
					nums[i][j] = n;
					n++;
				}
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
