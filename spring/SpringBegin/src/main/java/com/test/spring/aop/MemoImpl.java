package com.test.spring.aop;

import java.util.Calendar;

//주 업무 객체
public class MemoImpl implements Memo {

	@Override
	public void add(String memo) {
		
		System.out.println("메모 쓰기: " + memo);
		
	}

	@Override
	public String read(int seq) throws Exception {
		
		if (seq >= 1 && seq <= 10) {
			System.out.println("메모 읽기: " + seq);
		} else {
			throw new Exception("존재하지 않는 메모");
		}
		
		return "메모입니다.";
	}

	@Override
	public boolean edit(int seq, String memo) {
		
		System.out.println("메모 수정하기: " + memo);
		
		
		return true;
	}

	@Override
	public boolean del(int seq) {
		
		System.out.println("메모 삭제하기: " + seq);
		
		
		return true;
	}

}






















