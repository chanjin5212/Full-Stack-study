package com.test.java.question.io2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Stack;

public class Q06 {
	
	public static void main(String[] args) {
		
		try {
			Stack<Character> stack = new Stack<Character>();
			BufferedReader reader = new BufferedReader(new FileReader("C:\\quiz\\파일_입출력_문제\\괄호.java"));
			String line = null;
			boolean temp = true;
			while ((line = reader.readLine()) != null) {
				for (int i=0; i<line.length(); i++) {
					if (line.charAt(i) == '(' || line.charAt(i) == '{') {
						stack.push(line.charAt(i));
					} else if (line.charAt(i) == ')') {
						if (stack.size() == 0 || stack.peek() != '(') {
							temp = false;
							break;
						} else if (stack.peek() == '(') {
							stack.pop();
						}
						
					} else if (line.charAt(i) == '}') {
						if (stack.size() == 0 || stack.peek() != '{') {
							temp = false;
							break;
						} else if (stack.peek() == '{') {
							stack.pop();
						}
						
					}
					
				}
				if (!temp) {
					break;
				}
				
			}
			reader.close();
			if (temp && stack.size() == 0) {
				System.out.println("올바른 소스입니다.");
			} else {
				System.out.println("올바르지 않은 소스입니다.");
			}
			
			
		} catch (Exception e) {
			System.out.println("Q06.main");
			e.printStackTrace();
		}
		
	}

}
