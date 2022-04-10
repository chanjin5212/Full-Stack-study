package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("금액(원):");
		String amount = reader.readLine();
		
		char[] amountList = new char[amount.length()];
		for (int i=0; i<amount.length(); i++) {
			amountList[i] = amount.charAt(i);
		}
		for (int i=0; i<amountList.length; i++) {
			switch(amountList[i]) {
				case '0':
					amountList[i] = 0;
					break;
				case '1':
					amountList[i] = '일';					
					break;
				case '2':
					amountList[i] = '이';					
					break;
				case '3':
					amountList[i] = '삼';					
					break;
				case '4':
					amountList[i] = '사';					
					break;
				case '5':
					amountList[i] = '오';					
					break;
				case '6':
					amountList[i] = '육';					
					break;
				case '7':
					amountList[i] = '칠';					
					break;
				case '8':
					amountList[i] = '팔';					
					break;
				case '9':
					amountList[i] = '구';					
					break;
			}
		}
		String[] unit = { "천", "백", "십", "" };
		int count = amountList.length % 4;
		int a;
		if (count == 0) {
			a = 0;
		} else {
			a = 4 - count;
		}
		String result = "";
		
		for (int i=0; i<amountList.length; i++) {
			if (amountList[i] == 0) {
				a++;
			} else {
				result += amountList[i] + unit[a];
				a++;				
			}
			if (a == 4 && i < amountList.length - 1) {
				a = 0;
				result += "만";
			}
		}
		
		System.out.printf("일금 %s원", result);
		
		
	}

}
