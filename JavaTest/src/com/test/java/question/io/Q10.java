package com.test.java.question.io;

import java.io.File;

public class Q10 {
	
	public static void main(String[] args) {
		
		String path = "C:\\quiz\\직원";
		File[] file = new File(path).listFiles();
		
		for (File f : file) {
			String[] info = f.getName().split("_");
			String path1 = path + "\\" + info[0] + "\\" + info[1]; //C:\\quiz\\직원\\홍길동\\2014
			File file1 = new File(path1);
			if (!file1.exists()) {
				file1.mkdirs();
			}
			f.renameTo(new File(path1 + "\\" + f.getName()));
			
		}	
		System.out.println("분류가 완료되었습니다.");
	}

}
