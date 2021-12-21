package com;

public class AndMemberVO {
	private String id;
	private String pw;
	private String nick;
	private String phone;
	
	public AndMemberVO(String id, String pw, String nick, String phone) {
		this.id = id;
		this.pw = pw;
		this.nick = nick;
		this.phone = phone;
	}
	
	public AndMemberVO() {
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "AndMemberVO [id=" + id + ", "
				+ "pw=" + pw + ", "
						+ "nick=" + nick + ", "
								+ "phone=" + phone + "]";
	}

}
