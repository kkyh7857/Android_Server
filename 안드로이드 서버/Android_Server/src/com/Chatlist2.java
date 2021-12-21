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

@WebServlet("/Chatlist2")
public class Chatlist2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AndMemberDAO dao = new AndMemberDAO();
		
		ArrayList<ChatVO> list = dao.chatList();
		
		Gson gson = new Gson();
		String result = gson.toJson(list);
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		// response.getWriter().print(result); 이렇게 써도 됨.
		
		
	}

}
