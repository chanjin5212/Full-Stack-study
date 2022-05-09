package com.test.java.question.io;

import java.io.File;

public class Q04 {
	
	public static void main(String[] args) {
		
		File file = new File("C:\\quiz\\음악 파일");
		File[] list = file.listFiles();
		
		int count = 1;
		
		for (File f : list) {
			File re = new File(String.format("C:\\quiz\\음악 파일\\[%03d]%s", count, f.getName()));
			f.renameTo(re);
			count++;
		}
		
	}

}
