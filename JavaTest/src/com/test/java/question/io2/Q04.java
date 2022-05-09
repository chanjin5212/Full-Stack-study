package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("이름:");
			String input = br.readLine();
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\단일검색.dat"));
			
			String line = null;
			int count = 0;
			while ((line = reader.readLine()) != null) {
				
				if (input.equals(line.split(",")[1])) {
					String num = line.split(",")[0];
					String name = line.split(",")[1];
					String address = line.split(",")[2];
					String phone = line.split(",")[3];
					System.out.printf("[%s]\n번호: %s\n주소: %s\n전화:%s\n", name, num, address, phone);
					count++;
					break;
				}
				
			}
			reader.close();
			
			if (count == 0) {
				System.out.println("존재하지 않는 이름입니다.");
			}
		} catch (Exception e) {
			System.out.println("Q04.main");
			e.printStackTrace();
		}
		
		
		
	}

}
