package com.test.java.question.io;

import java.io.File;

public class Q06 {
	
	public static void main(String[] args) {
		
		File[] file = new File("C:\\quiz\\파일 제거").listFiles();
		
		int count = 0;
		
		for (File f : file) {
			if (f.length() == 0) {
				f.delete();
				count++;
			}
		}
		System.out.printf("총 %d개의 파일을 삭제했습니다.", count);
	}

}
