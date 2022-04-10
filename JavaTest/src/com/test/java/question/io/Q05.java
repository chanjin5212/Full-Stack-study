package com.test.java.question.io;

import java.io.File;
import java.util.HashMap;

public class Q05 {
	
	public static void main(String[] args) {
		
		File[] file = new File("C:\\quiz\\확장자별 카운트").listFiles();;
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for (File f : file) {
			String[] list = f.getName().split("\\.");
			
			if (map.containsKey(list[list.length-1])) {
				map.put(list[list.length-1], map.get(list[list.length-1]) + 1);
			} else {
				map.put(list[list.length-1], 1);
			}
		}
		for (String key : map.keySet()) {
			System.out.printf("*.%s : %d개\n", key, map.get(key));
		}
	}

}
