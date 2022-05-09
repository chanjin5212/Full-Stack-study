package com.test.java.question.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q03 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("파일 이동을 실행합니다.");
		
		File file1 = new File("C:\\class\\java\\file\\AAA\\test.txt");
		File file2 = new File("C:\\class\\java\\file\\BBB\\test.txt");
		
		if (!file1.renameTo(file2)) {
			System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요?(y/n)");
			String yn = reader.readLine();
			if (yn.equals("y")) {
				file2.delete();
				file1.renameTo(file2);
				System.out.println("y. 파일을 덮어썼습니다.");
			} else {
				System.out.println("n. 작업을 취소합니다.");
			}
		} else {
			file1.renameTo(file2);
			System.out.println("파일 이동을 완료하였습니다.");
		}
		
		
	}

}
