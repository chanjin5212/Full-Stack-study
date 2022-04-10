package com.test.java.question.io;

import java.io.File;

public class Q08 {
	
	static int countD = 0;
	static int countF = 0;
	
	public static void main(String[] args) {
		
		File dir = new File("C:\\quiz\\폴더 삭제\\delete");
		countFile(dir);
		
		System.out.println("폴더를 삭제했습니다.");
		System.out.printf("삭제된 폴더는 %d개이고, 파일은 %d개입니다.", countF, countD);
		
	}
	private static void countFile(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				countFile(subdir);
				subdir.delete();
				countF++;
			} else {
				subdir.delete();
				countD++;
			}
		}
		
		
		
		
		
		
		
	}

}


