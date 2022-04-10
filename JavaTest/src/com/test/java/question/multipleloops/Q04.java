package com.test.java.question.multipleloops;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		//3번과 비슷하나 알파벳을 출력하는 부분을 한쪽은 순서대로, 다른 한쪽은 반대로 진행해야한다.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("행:");
		int row = Integer.parseInt(reader.readLine());
		
		
		for (int i=0; i<row; i++) {
			
			for(int j=row-1; j>i; j--) {
				System.out.print(" ");
			}
			for (int j=97; j<i+98; j++) {
				System.out.print((char)j);
			}
			for (int j=97+i; j>96; j--) {
				System.out.print((char)j);
			}
			System.out.println();
		}
	}

}
