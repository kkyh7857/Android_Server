package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AndMemberDAO {
	
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";
			conn = DriverManager.getConnection(url, dbid, dbpw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int join(AndMemberVO vo) {
		int cnt = 0;

		getConnection();
		
		try {			
			String sql ="insert into andMember values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPw());
			psmt.setString(3, vo.getNick());
			psmt.setString(4, vo.getPhone());
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {		
			close();
		}
		
		return cnt;
	}
	
	public AndMemberVO login(String id, String pw) {
		
		getConnection();
		AndMemberVO info = null;
		try {			
			String sql ="select * from andMember where id = ? and pw = ? ";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			psmt.setString(2, pw);
			
			rs = psmt.executeQuery();
			if(rs.next()) {
				id = rs.getString(1);
				pw = rs.getString(2);
				String nick = rs.getString(3);
				String phone = rs.getString(4);
				info = new AndMemberVO(id, pw, nick, phone);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {		
			close();
		}
		
		return info;
	}
	
	public ArrayList<AndMemberVO> memberList() {
		
		ArrayList<AndMemberVO> list = new ArrayList<AndMemberVO>();
		
		getConnection();
		AndMemberVO vo = null;
		
		try {
			String sql ="select * from andMember";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String nick = rs.getString(3);
				String phone = rs.getString(4);
				vo = new AndMemberVO(id, pw, nick, phone);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {		
			close();
		}
		
		return list;
	}

	public int chatInput(String nick, String content) {
		int cnt = 0;
		getConnection();
		try {
			String sql = "insert into andChat values(?,?,sysdate)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, nick);
			psmt.setString(2, content);
			
			cnt = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return cnt;
	}

	public ArrayList<ChatVO> chatList() {
		
		ArrayList<ChatVO> list = new ArrayList<ChatVO>();
		
		getConnection();
		ChatVO vo = null;
		
		try {
			String sql ="select * from andChat order by day desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				String nick = rs.getString(1);
				String content = rs.getString(2);
				String day = rs.getString(3);
				vo = new ChatVO(nick, content, day);
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		
		} finally {
			close();
		}
		
		return list;
	}
}
