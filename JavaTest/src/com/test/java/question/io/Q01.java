package com.test.java.question.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q01 {

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("파일 경로:");
		String PATH = reader.readLine();

		File file = new File(PATH);
		String[] ext = file.getName().split("\\.");
		
		System.out.printf("파일명:%s\n", file.getName());
		System.out.printf("종류:%s\n", ext[ext.length-1]);
		if (file.length() > Math.pow(1024, 4)) {
			System.out.printf("파일 크기:%.1fTB\n", file.length() / Math.pow(1024, 4));
		} else if (file.length() > Math.pow(1024, 3)) {
			System.out.printf("파일 크기:%.1fGB\n", file.length() / Math.pow(1024, 3));			
		} else if (file.length() > Math.pow(1024, 2)) {
			System.out.printf("파일 크기:%.1fMB\n", file.length() / Math.pow(1024, 2));						
		} else if (file.length() > Math.pow(1024, 1)) {
			System.out.printf("파일 크기:%.1fKB\n", file.length() / Math.pow(1024, 1));			
		} else {
			System.out.printf("파일 크기:%dB\n", file.length());						
		}
	}

}
