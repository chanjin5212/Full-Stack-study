package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q02 {
	
	public static void main(String[] args) throws Exception {
		
		
		
		m1();
		m2();
		
	} //main

	private static void m2() throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일:");
		String email = reader.readLine();
		
		int index = email.indexOf("@");
		
		System.out.println("아이디:" + email.subSequence(0, index));
		System.out.println("도메인:" + email.subSequence(index+1, email.length()));
		
	}

	private static void m1() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일:");
		String email = reader.readLine();
		
		String[] idDomain = email.split("@");
		
		System.out.println("아이디:" + idDomain[0]);
		System.out.println("도메인:" + idDomain[1]);
		
	}

}
