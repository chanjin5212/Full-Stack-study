package com.test.java.question.array2;

public class Q08 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		//1~15
		for(int i=0; i<5; i++) {
			int a = i;
			for (int j=0; j<=i; j++) {
				nums[j][a] = n;
				n++;
				a--;
			}
		}
		//16~25
		for (int i=1; i<5; i++) {
			int a = 4;
			for (int j=i; j<=4; j++) {
				nums[j][a] = n;
				n++;
				a--;
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
