package com.test.java.question.collection;

import java.util.ArrayList;

public class Q01 {
	
	public static void main(String[] args) {
		
		MyArrayList list = new MyArrayList();
		
		list.add("바나나");
		list.add("사과");
		list.add("포도");
		list.add("딸기");
		
		System.out.println(list);
		
		
		list.add("귤");
		System.out.println(list);
		
		//System.out.println(list.get(6));
		
		System.out.println(list.size());
		
		list.remove(2);
		
		list.set(3, "복숭아");
		
		
		System.out.println(list);
		
		list.add(3, "체리");
		
		System.out.println(list);
		
		
	}//main

}
