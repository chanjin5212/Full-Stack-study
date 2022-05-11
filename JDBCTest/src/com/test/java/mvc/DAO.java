package com.test.java.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylibrary.db.DBUtil;

//JDBC 코드 담당 > DB 업무 담당
public class DAO {
	
	private Connection conn = null;
	private Statement stat = null;
	private PreparedStatement pstat = null;
	private ResultSet rs = null;
	
	public DAO() {
		
		conn = DBUtil.open();
		
	}

	public int add(Address dto) {
		
		
		try {
			
			String sql = "insert into tblAddress (seq, name, age, gender, tel, address, regdate) "
					+ "values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			
			int result = pstat.executeUpdate();
			
			return result;
			
			//월권 행위!!!
			// > DAO의 역할 > DB작업
//			if (result == 1) {
//				System.out.println("성공");
//			} else {
//				System.out.println("실패");
//			}
			
		} catch (Exception e) {
			System.out.println("DAO.add");
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<Address> list() {
		
		try {
			
			String sql = "select * from tblAddress order by seq asc";
			
			stat = conn.createStatement();
			
			rs = stat.executeQuery(sql);
			
			
			//ResultSet -> (복사) -> ArrayList<Address>
			ArrayList<Address> list = new ArrayList<Address>();
			
			while (rs.next()) {
				
				//레코드 1개 > Address 1개
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
				
			}
			
			return list; //select의 결과를 Service에게 반환
			
		} catch (Exception e) {
			System.out.println("DAO.list");
			e.printStackTrace();
		}
		
		return null;
	}

	public Address get(String seq) {
		
		try {
			
			String sql = "select * from tblAddress where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			rs = pstat.executeQuery();
			
			if (rs.next()) {
				
				//레코드 1줄 > Address 1개
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto; //반환
				
			}
			
			
			
		} catch (Exception e) {
			System.out.println("DAO.get");
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(Address dto) {
		
		try {
			
			//모든 컬럼을 업데이트한다. > SQL를 1개만 만들기 위해서!!!!
			String sql = "update tblAddress set name = ?, age = ?, gender = ?, tel = ?, address = ? where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, dto.getName());
			pstat.setString(2, dto.getAge());
			pstat.setString(3, dto.getGender());
			pstat.setString(4, dto.getTel());
			pstat.setString(5, dto.getAddress());
			pstat.setString(6, dto.getSeq());
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("DAO.edit");
			e.printStackTrace();
		}
		
		return 0;
	}

	public int del(String seq) {
		
		try {
			
			//모든 컬럼을 업데이트한다. > SQL를 1개만 만들기 위해서!!!!
			String sql = "delete from tblAddress where seq = ?";
			
			pstat = conn.prepareStatement(sql);
			
			pstat.setString(1, seq);
			
			int result = pstat.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			System.out.println("DAO.del");
			e.printStackTrace();
		}
		
		return 0;
	}

}


//디자인 패턴
//MVC Pattern
//	- Model > Data > Address.java (+ DAO.java)
//	- View > 출력 > View.java
//	- Controller > 운용 역할. 제어 > Main.java, Service.java



//동일한 주제 > 쌍용 교육 센터 관리 프로그램 
// > 직원의 요구사항
// > 



















