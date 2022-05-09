package com.test.java.question.io;

import java.io.File;
import java.util.ArrayList;

public class Q09 {
	
	static ArrayList<File> a = new ArrayList<File>();
	
	public static void main(String[] args) {
		
		File file = new File("C:\\quiz\\크기 정렬");
		fileAdd(file);
		
		for (int i=0; i<a.size()-1; i++) {
			for (int j=0; j<a.size()-1-i; j++) {
				if (a.get(j).length() > a.get(j+1).length()) {
					
					File temp = a.get(j+1);
					a.set(j+1, a.get(j));
					a.set(j, temp);
					
				}
			}
		}
		
		
		System.out.println("[파일명]                       [크기]            [파일이 들어있는 폴더]");
		for (int i=a.size()-1; i>=0; i--) {
			String size;
			if (a.get(i).length() > Math.pow(1024, 4)) {
				size = String.format("%.1fTB", a.get(i).length() / Math.pow(1024, 4));
			} else if (a.get(i).length() > Math.pow(1024, 3)) {
				size = String.format("%.1fGB", a.get(i).length() / Math.pow(1024, 3));				
			} else if (a.get(i).length() > Math.pow(1024, 2)) {
				size = String.format("%.1fMB", a.get(i).length() / Math.pow(1024, 2));								
			} else if (a.get(i).length() > Math.pow(1024, 1)) {
				size = String.format("%.1fKB", a.get(i).length() / Math.pow(1024, 1));			
			} else {
				size = a.get(i).length() + "B";								
			}
			System.out.printf("%-28s %-10s        %s\n", a.get(i).getName(), size, a.get(i).getParentFile().getName());
		}
		
	}
	
	private static void fileAdd(File dir) {
		
		File[] list = dir.listFiles();
		
		for (File f : list) {
			if (f.isDirectory()) {
				fileAdd(f);
			} else {
				a.add(f);
			}
		}
		
		
	}

}
