package com.test.java.question.io;

import java.io.File;

public class Q07 {
	
	public static void main(String[] args) {
		
		File[] fileA = new File("C:\\quiz\\동일 파일\\MusicA").listFiles();
		File[] fileB = new File("C:\\quiz\\동일 파일\\MusicB").listFiles();
		
		for (File a : fileA) {
			for (File b : fileB) {
				if (a.getName().equals(b.getName())) {
					System.out.println(a.getName());
				}
			}
		}
	}

}
