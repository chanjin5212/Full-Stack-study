package com.test.java.question.string;

public class Q05 {
	
	public static void main(String[] args) {
		
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		
		m1(content, word);
		m2(content, word);
	}//main
	
	private static void m2(String content, String word) {
		
		String content1 = content.replace(word, "");
		int count = (content.length() - content1.length()) / word.length();
		System.out.printf("'%s'을 총 %d회 발견했습니다.\n", word, count);	
	}
	public static void m1(String content, String word) {
		int index = 0;
		int count = 0;
		while (index <= content.lastIndexOf(word)) {
			index = content.indexOf(word, index);
			count++;
			index++;
		}
		System.out.printf("'%s'을 총 %d회 발견했습니다.\n", word, count);
	}

}
