package com.test.java.question.array2;

public class Q09 {

	public static void main(String[] args) {

		int[][] nums = new int[5][5];
		int n = 1;
		
		int a = 0;
		int c = nums.length;
		
		int b = 0;
		int d = nums.length-2;
		while (n<=nums.length*nums.length) {
			
			for (int i=a; i<c; i++) { //0~4 1~3
				nums[a][i] = n;
				n++;
			}
			a++; // a = 1,2
			for (int i=a; i<c; i++) { //1~4 2~3
				nums[i][c-1] = n;
				n++;
			}
			c--; // c = 4,3
			for (int i=d; i>=b; i--) { //3~0 2~1
				nums[d+1][i] = n;
				n++;
			}
			b++; // b = 1,2
			for (int i=d; i>=b; i--) { //3~1 2
				nums[i][b-1] = n;
				n++;
			}
			d--;// d = 2,1
			
		}
		
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums.length; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
	}

}
