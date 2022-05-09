package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q08 {
	
	public static void main(String[] args) throws Exception {
		
		//1. 7번과 똑같다.
		
		
		//m1();
		m2();
		
	}//main

	private static void m2() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삭제 위치 : ");
		int inNum = Integer.parseInt(reader.readLine());
		
		
		int[] array = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};

		System.out.printf("원본:%s\n",Arrays.toString(array));
		
		for (int i=inNum; i<array.length-1; i++) {
			array[i] = array[i+1];
		}
		array[array.length-1] = 0;
		
		System.out.printf("결과:%s\n",Arrays.toString(array));
		
	}

	private static void m1() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("삭제 위치 : ");
		int inNum = Integer.parseInt(reader.readLine());
		
		int[] array = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
		
		System.out.printf("원본 : %s\n", Arrays.toString(array));
		
		int[] array1 = new int[9-inNum];
		
		for (int i=0; i<array1.length; i++) {
			array1[i] = array[i+inNum+1];
		}
		
		for (int i=0; i<array1.length; i++) {
			array[inNum+i] = array1[i];
		}
		array[9] = 0;
		
		System.out.printf("결과 : %s\n", Arrays.toString(array));
	}
	
	
	

}
