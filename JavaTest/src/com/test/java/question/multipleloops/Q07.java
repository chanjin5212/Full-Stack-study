package com.test.java.question.multipleloops;

public class Q07 {

	public static void main(String[] args) {
		
		//1. 입력된 값을 저장하는 num 변수 생성
		//2. 다중 for문으로 완전수 계산
		//3. 완전수와 완전수의 약수를 num 변수에 저장
		//4. 출력


		String num = "";
		for (int i=1; i<=100; i++) {
			String divisor = "";
			int sum = 0;

			for (int j=1; j<i; j++) {

				if (i % j == 0) {
					sum += j;
					divisor += j + ", ";
				} 
			}
			if (sum == i) {
				num += i + " = [" + divisor + "\b\b]\n";
			}
		}
		System.out.println(num);
	}
}
