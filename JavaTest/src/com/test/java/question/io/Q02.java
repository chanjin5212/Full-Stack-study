package com.test.java.question.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("폴더:");
		String path = reader.readLine();
		System.out.print("확장자:");
		String ext = reader.readLine();
		
		File file = new File(path);
		File[] list = file.listFiles();
		
		for (File f : list) {
			String[] ext1 = f.getName().split("\\.");
			if (ext1[ext1.length-1].equals(ext)) {
				System.out.println(f.getName());
			}
		}
		
	}

}
