package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Q03 {
	
	public static void main(String[] args) {
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\성적.dat"));
			ArrayList<String> pass = new ArrayList<String>();
			ArrayList<String> fail = new ArrayList<String>();
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				String name = line.split(",")[0];
				int kor = Integer.parseInt(line.split(",")[1]);
				int eng = Integer.parseInt(line.split(",")[2]);
				int math = Integer.parseInt(line.split(",")[3]);
				
				if (kor < 40 || eng < 40 || math < 40 || (kor + eng + math) / 3 < 60) {
					fail.add(name);
				} else {
					pass.add(name);
				}
				
			}
			reader.close();
			System.out.println("[합격자]");
			for (String p : pass) {
				System.out.println(p);
			}
			System.out.println("[불합격자]");
			for (String f : fail) {
				System.out.println(f);
			}
			
		} catch (Exception e) {
			System.out.println("Q03.main");
			e.printStackTrace();
		}
		
	}

}
