package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Q02 {
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\숫자.dat"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\quiz\\파일_입출력_문제\\숫자_변환.dat"));
			String line = null;
			
			//0 과 함께 1 과 함께 2
			//-> 영 과 함께 1 과 함께 2
			String[] number = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
			String[] korean = { "영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구" };
			
			while ((line = reader.readLine()) != null) {
				for (int i=0; i<korean.length; i++) {
					line = line.replaceAll(number[i], korean[i]);
				}
				writer.write(line);
				writer.newLine();
			}
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
			reader.close();
			writer.close();
			
			
		} catch (Exception e) {
			System.out.println("Q02.main");
			e.printStackTrace();
		}
		
	}

}
