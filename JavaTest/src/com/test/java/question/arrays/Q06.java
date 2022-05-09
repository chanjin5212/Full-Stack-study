package com.test.java.question.arrays;

import java.util.Arrays;

public class Q06 {

	public static void main(String[] args) {
		
		//1. 2가지 방법으로 풀수 있다.
		//	1.1 숫자 1개씩 입력받아 그 숫자가 로또 배열에 있으면 다시 뽑고, 없으면 추가하는식으로 6번 반복
		//	1.2 숫자를 전부 입력받아, 서로 중복된게 있으면 다시 뽑고, 없으면 출력
		//2. 1.1방법
		//	2.1 6크기 배열을 만든다.
		//	2.2 num 변수에 먼저 랜덤숫자를 한개 입력받는다
		//	2.3 num 변수가 lotto 배열에 있는지 확인하고 없으면 추가한다.
		//	2.4 완성된 후 출력
		//3. 1.2 방법
		//	3.1 while문으로 시작한다.
		//	3.2 6크기 배열을 만든다
		//	3.3 숫자 6개를 랜덤으로 입력받는다
		//	3.4 for문을 이용해 서로 중복되는 것이 있는지 확인하고 있으면 다시 돌린다.
		//	3.5 완성된 후 출력

		int[] lotto = new int[6];
		int n = 0;
		
		while (n < 6) {
			int num = (int) (Math.random() * 45 + 1);
			int count = 0;
			for (int i = 0; i < lotto.length; i++) {
				if (num == lotto[i]) {
					count++;
				}

			}
			if (count == 0) {
				lotto[n] = num;
				n++;
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
		
		while (true) {
			int count = 0;
			int[] lotto1 = new int[6];
			for (int i=0; i<lotto1.length; i++) {
				lotto1[i] = (int)(Math.random() * 45 + 1);
			}
			for (int i=0; i<lotto1.length; i++) {
				for (int j=i+1; j<lotto1.length; j++) {
					if (lotto1[i] == lotto1[j]) {
						count++;
					}
				}
			}
			if (count == 0) {
				Arrays.sort(lotto1);
				System.out.println(Arrays.toString(lotto1));
				break;
			}
		}
		
		
	
	}//main
}
