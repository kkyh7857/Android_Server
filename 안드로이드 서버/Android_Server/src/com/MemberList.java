package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/MemberList")
public class MemberList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		AndMemberDAO dao = new AndMemberDAO();
		ArrayList<AndMemberVO> list = dao.memberList();
		// memberList 메소드를 만든 후 아래에서 반복문을 통해 콘솔에 회원정보를 출력하시오
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson(); // 나에게 있는 목록을 json 타입으로 자동 변환 해주는 장치: Gson
		String result = gson.toJson(list);
		out.print(result);
	}
}
