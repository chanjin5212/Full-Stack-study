package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Q07 {
	
	public static void main(String[] args) {
		
		try {
			HashMap<String, Integer> late = new HashMap<String, Integer>();
			HashMap<String, Integer> early = new HashMap<String, Integer>();
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\출결.dat"));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String name = line.split(",")[1];
				int startHour = Integer.parseInt(line.split(",")[2].split(":")[0]);
				int startMin = Integer.parseInt(line.split(",")[2].split(":")[1]);
				int end = Integer.parseInt(line.split(",")[3].split(":")[0]);
				if (!late.containsKey(name)) {
					late.put(name, 0);
				}
				
				if (!early.containsKey(name)) {
					early.put(name, 0);
				}
				
				if (startHour >= 9 && startMin > 0) {
					late.put(name, late.get(name) + 1);
				}
				if (end < 18) {
					early.put(name, early.get(name) + 1);
				}
				
			}
			reader.close();
			System.out.println("[이름]    [지각]    [조퇴] ");
			for (String s : late.keySet()) {
				System.out.printf("%s      %2d회      %2d회\n", s, late.get(s), early.get(s));
			}
			//2018-8-29,김찬진,9:0,18:0
			
		} catch (Exception e) {
			System.out.println("Q07.main");
			e.printStackTrace();
		}
		
	}

}