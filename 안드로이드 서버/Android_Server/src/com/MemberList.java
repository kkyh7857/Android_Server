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
		// memberList �޼ҵ带 ���� �� �Ʒ����� �ݺ����� ���� �ֿܼ� ȸ�������� ����Ͻÿ�
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
		
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson(); // ������ �ִ� ����� json Ÿ������ �ڵ� ��ȯ ���ִ� ��ġ: Gson
		String result = gson.toJson(list);
		out.print(result);
	}
}
