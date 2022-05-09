package com.test.java.question.overload;

public class Q03 {

	public static void main(String[] args) {
		
		//인자로 받은 숫자들 중 양수의 갯수를 반환하는 메소드를 선언하시오.
		int count = 0;
		
		count = positive(10);
		System.out.printf("양수: %d개\n", count);
		
		count = positive(10, 20);
		System.out.printf("양수: %d개\n", count);
		
		count = positive(10, 20, -30);
		System.out.printf("양수: %d개\n", count);
		
		count = positive(10, 20, -30, 40);
		System.out.printf("양수: %d개\n", count);
		
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수: %d개\n", count);
		
		
	}//main
	
	public static int positive(int n1) {
		
		int count = 0;
		
		count += (n1 > 0) ? 1 : 0;
		
		return count;
	}
	
	public static int positive(int n1, int n2) {
		
		int count = 0;
		
		count += (n1 > 0) ? 1 : 0;
		count += (n2 > 0) ? 1 : 0;
		
		return count;
	}
	
	public static int positive(int n1, int n2, int n3) {
		
		int count = 0;
		
		count += (n1 > 0) ? 1 : 0;
		count += (n2 > 0) ? 1 : 0;
		count += (n3 > 0) ? 1 : 0;
		
		return count;
	}
	
	public static int positive(int n1, int n2, int n3, int n4) {
		
		int count = 0;
		
		count += (n1 > 0) ? 1 : 0;
		count += (n2 > 0) ? 1 : 0;
		count += (n3 > 0) ? 1 : 0;
		count += (n4 > 0) ? 1 : 0;
		
		return count;
	}
	
	public static int positive(int n1, int n2, int n3, int n4, int n5) {
		
		int count = 0;
		
		count += (n1 > 0) ? 1 : 0;
		count += (n2 > 0) ? 1 : 0;
		count += (n3 > 0) ? 1 : 0;
		count += (n4 > 0) ? 1 : 0;
		count += (n5 > 0) ? 1 : 0;
		
		return count;
	}
	
}
