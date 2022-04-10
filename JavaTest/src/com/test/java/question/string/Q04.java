package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q04 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int countMp3 = 0;
		int countJpg = 0;
		int countJava = 0;
		int countHwp = 0;
		int countDoc = 0;
		for (int i=0; i<10; i++) {
			System.out.print("파일명:");
			String file = reader.readLine();
			String[] fileList = file.split(".");
			
			if (fileList[1].contains("mp3")) {
				countMp3++;
			} 
			else if (fileList[1].contains("jpg")) {
				countJpg++;	
			}
			else if (fileList[1].contains("java")) {
				countJava++;
			}
			else if (fileList[1].contains("hwp")) {
				countHwp++;
			}
			else if (fileList[1].contains("doc")) {
				countDoc++;
			}
		}
		System.out.printf("mp3 : %d개\n", countMp3);
		System.out.printf("jpg : %d개\n", countJpg);
		System.out.printf("java : %d개\n", countJava);
		System.out.printf("hwp : %d개\n", countHwp);
		System.out.printf("doc : %d개\n", countDoc);
	}

}
