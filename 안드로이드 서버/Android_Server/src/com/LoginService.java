package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/LoginService")
public class LoginService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		AndMemberDAO dao = new AndMemberDAO();
		AndMemberVO info = dao.login(id, pw);
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		if( info != null) {
			System.out.println("로그인 성공");
			Gson gson = new Gson();
			String result = gson.toJson(info);
			out.print(result);
		}else {
			System.out.println("로그인 실패");
			out.print("fail");
		}
		
	}
}