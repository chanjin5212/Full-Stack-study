package com.test.java.question.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q09 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 길이:");
		int length = Integer.parseInt(reader.readLine());
		
		int[] array = new int[length];
		
		for (int i=0; i<array.length; i++) {
			array[i] = (int)(Math.random() * 9 + 1);
		}
		
		System.out.printf("원본:%s\n", Arrays.toString(array));
		
		int[] array1;
		
		if (length % 2 == 0) {
			array1 = new int[length / 2];
			
			for (int i=0; i<array1.length; i++) {
				array1[i] = array[2 * i] + array[2 * i + 1];
			}
		} else {
			array1 = new int[length / 2 + 1];
			for (int i=0; i<array1.length-1; i++) {
				array1[i] = array[2 * i] + array[2 * i + 1];
			}
			array1[array1.length-1] = array[array.length-1];
		}
		
		
		System.out.printf("결과:%s\n", Arrays.toString(array1));
		
	}

}
