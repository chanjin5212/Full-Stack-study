package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {
	
	public static void main(String[] args) {
		
		//게시글 더미 생성하기
		
		String sql = "insert into tblBoard (seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
		
		//시드 데이터
		String[] subject = { "게시판을", "안녕~", "홍길동입니다", "자바는", "컴퓨터가", "급하게", "밖에", "비가", "아~", "휴..", "앗!!", "테스트에게", "뭐라고!!" };
		
		String content = "내용입니다.";
		
		String[] id = { "hong", "admin", "test", "hoho" };
		
		Connection conn = null;
		PreparedStatement stat = null;
		
		try {
			
			conn = DBUtil.open();
			
			stat = conn.prepareStatement(sql);
			
			Random rnd = new Random();
			
			for (int i=0; i<256; i++) {
				
				stat.setString(1, subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)]);
				
				stat.setString(2, content);
				
				stat.setString(3, id[rnd.nextInt(id.length)]);
				
				stat.executeUpdate();
			}
			
		} catch (Exception e) {
			System.out.println("Dummy.main");
			e.printStackTrace();
		}
		
	}
	
}
