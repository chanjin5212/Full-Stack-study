package com.test.java.question.multipleloops;

public class Q06 {
	
	public static void main(String[] args) {
		
		
		String num = "";
		for (int i=2; i<=100; i++) {
			
			int count = 0;
			
			for (int j=1; j<i; j++) {
				
				if (i % j == 0) {
					count++;
				}
			}
			if (count == 1) {
				num += i + ", ";
			}
			
		}
		System.out.print(num + "\b\b");
		
	}

}
