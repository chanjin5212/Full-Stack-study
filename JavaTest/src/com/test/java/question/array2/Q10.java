package com.test.java.question.array2;

public class Q10 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[3][3];
		
		int n = 1;
		int x = 1;
		int y = 2;
		nums[x][y] = n++;
		
		while (n<=nums.length*nums.length) {
			
			int moveX = (x - 1 + nums.length) % nums.length;
			int moveY = (y + 1) % nums.length;
			
			if (nums[moveX][moveY] != 0) {
				y = (y - 1 + nums.length) % nums.length;
				
			} else {
				x = moveX;
				y = moveY;
			}
			nums[x][y] = n++;
		}
		
		while (n<=nums.length*nums.length) {
			int moveX = x - 1;
			int moveY = y + 1;
			
			if(moveX < 0 && moveY > nums.length-1) {
				moveX += nums.length;
				moveY -= nums.length;
			} else if (moveX < 0) {
				moveX += nums.length;
			} else if (moveY > nums.length-1) {
				moveY -= nums.length;
			}
			if (nums[moveX][moveY] != 0) {
				y--;
				if (y < 0) {
					y += nums.length;
				}
			} else {
				x = moveX;
				y = moveY;
			}
			nums[x][y] = n++;
		}
		
		for (int i=0; i<nums.length; i++) {
			for (int j=0; j<nums.length; j++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
		
	}//main

}
