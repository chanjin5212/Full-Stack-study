package com.test.java.question.overload;

public class Q01 {

	public static void main(String[] args) {

		// 인자로 받은 숫자들의 합을 구하는 메소드를 선언하시오.

		sum(10);
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);
		sum(10, 20, 30, 40, 50);


	}// main

	public static void sum(int n1) {

		System.out.printf("%d = %d\n", n1, n1);
	}

	public static void sum(int n1, int n2) {

		System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
	}

	public static void sum(int n1, int n2, int n3) {

		System.out.printf("%d + %d + %d = %d\n", n1, n2, n3, n1 + n2 + n3);
	}

	public static void sum(int n1, int n2, int n3, int n4) {

		System.out.printf("%d + %d + %d + %d = %d\n", n1, n2, n3, n4, n1 + n2 + n3 + n4);
	}

	public static void sum(int n1, int n2, int n3, int n4, int n5) {

		System.out.printf("%d + %d + %d + %d + %d = %d\n", n1, n2, n3, n4, n5,
				n1 + n2 + n3 + n4 + n5);
	}

}
