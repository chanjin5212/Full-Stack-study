package com.test.java.question.multipleloops;

public class Q12 {
	
	public static void main(String[] args) {
		
		//1. 숫자를 입력할 변수 2개와 합을 저장할 변수 1개를 만든다
		//2. 처음은 첫번째 숫자에 더하고 다음은 두번째 숫자에 더하고 이걸 계속 반복함으로 피보나치 수열을 만든다.
		//3. if문을 이용해 두 숫자의 합이 100이 넘으면 멈춘다.
		//4. 계산하는 숫자들을 sum 변수에 더한다.
		
		int firstNum = 0;
		int secondNum = 1;
		int sum = 0;
		String num = "";
		
		while (true) {
			
			secondNum = firstNum + secondNum;
			if (secondNum > 100) {
				break;
			} else {
				num += secondNum + " + ";
				sum += secondNum;
			}
			
			firstNum += secondNum;
			if (firstNum > 100) {
				break;
			} else {
				num += firstNum + " + ";
				sum += firstNum;
			}
			
		}
		
		System.out.printf("%s= %d", num + "\b\b", sum);
		
		
//		for (int i=1; ; i++) {
//			
//			if (firstNum + secondNum > 100) {
//				break;
//			} else {
//				if (i % 2 == 0) {
//					firstNum += secondNum;
//					sum += firstNum;
//					num += firstNum + " + ";
//				} else {
//					secondNum += firstNum;
//					sum += secondNum;
//					num += secondNum + " + ";
//				}				
//			}
//		}
	
	}

}
