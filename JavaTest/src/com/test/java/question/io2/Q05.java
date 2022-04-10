package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q05 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름:");
		String input = br.readLine();
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\검색_회원.dat"));
			BufferedReader reader1 = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\검색_주문.dat"));
			String line = null;
			ArrayList<String> list = new ArrayList<String>();
			while ((line = reader.readLine()) != null) {
				if (input.equals(line.split(",")[1])) {
					String num = line.split(",")[0];
					String address = line.split(",")[2];
					String line1 = null;
					while ((line1 = reader1.readLine()) != null) {
						if (num.equals(line1.split(",")[3])) {
							String product = line1.split(",")[1];
							String amount = line1.split(",")[2];
							
							list.add(String.format("%5s %6s %8s %7s      %s", num, input, product, amount, address));
						}
					}
					
				}
			}
			reader.close();
			reader1.close();
			
			if (list.size() != 0) {
				System.out.println("==== 구매내역 ==== ");
				System.out.println("[번호]    [이름]    [상품명]    [개수]    [배송지]");
				for (String l : list) {
					System.out.println(l);
				}
			} else {
				System.out.println("구매한 기록이 존재하지 않습니다.");
			}

			
		} catch (Exception e) {
			System.out.println("Q05.main");
			e.printStackTrace();
		}
		
		
	}

}
