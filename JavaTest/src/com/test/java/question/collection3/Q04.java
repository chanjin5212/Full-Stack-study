package com.test.java.question.collection3;

public class Q04 {
	
	public static void main(String[] args) {
		
		MyHashMap1 map1 = new MyHashMap1();
		MyHashMap2 map2 = new MyHashMap2();
		
		System.out.println(map1);
		System.out.println(map2);
		
		map1.put("국어", "합격");
		map1.put("영어", "합격");
		map1.put("수학", "불합격");
		map1.put("과학", "불합격");
		map1.put("사회", "불합격");
		
		System.out.println(map1);
		
		map2.put("국어", "합격");
		map2.put("영어", "합격");
		map2.put("수학", "불합격");
		map2.put("과학", "불합격");
		map2.put("사회", "불합격");
		
		System.out.println(map2);
		
		System.out.println(map1.get("국어"));
		System.out.println(map1.get("생물"));
		
		System.out.println(map2.get("국어"));
		System.out.println(map2.get("생물"));
		
		map1.put("국어", "불합격");
		System.out.println(map1);
		
		map2.put("국어", "불합격");
		System.out.println(map2);
		
		map1.remove("국어");
		System.out.println(map1);
		
		map2.remove("국어");
		System.out.println(map2);
		
		System.out.println(map1.containKey("영어"));
		System.out.println(map1.containKey("국어"));
		
		System.out.println(map2.containKey("영어"));
		System.out.println(map2.containKey("국어"));
		
		System.out.println(map1.containsValue("합격"));
		System.out.println(map1.containsValue("보류"));
		
		System.out.println(map2.containsValue("합격"));
		System.out.println(map2.containsValue("보류"));
		
		map1.clear();
		map2.clear();
		
		System.out.println(map1.size());
		System.out.println(map2.size());
		
		map1.put("국어", "합격");
		map1.put("영어", "합격");
		map1.put("수학", "불합격");
		map1.put("과학", "불합격");
		map1.put("사회", "불합격");
		
		
		map2.put("국어", "합격");
		map2.put("영어", "합격");
		map2.put("수학", "불합격");
		map2.put("과학", "불합격");
		map2.put("사회", "불합격");
		
		map1.trimToSize();
		map2.trimToSize();
		
		System.out.println(map1);
		System.out.println(map2);
		
	}

}

