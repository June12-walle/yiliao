package com.offcn.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.offcn.entity.User;
import com.offcn.service.UserService;

@WebServlet("/user")
public class UserServlet extends BaseServlet {
	UserService userService = new UserService();

	public void checkLogin(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// ��ȡ�û���Ϣ
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String verifyCode = request.getParameter("verify");
		// ��װ�û�����
		User user = new User(username, password);
		boolean flag = userService.checkLogin(user, verifyCode, request.getSession());
		if (flag) {
			response.sendRedirect("index.jsp");
		} else {
			request.setAttribute("msg", "�û����������� ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

	// ��֤���ɵ���֤�����û�������Ƿ���ͬ
	public void checkVerifyCode(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String verifyCode = request.getParameter("verify");
		boolean flag = userService.checkVerifyCode(verifyCode, request.getSession());
		response.getWriter().print(flag);
	}

	// �˳���¼
	public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("login.jsp");
	}

	// ע��ҳ���û�����֤
	public void checkUserName(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		boolean flag = userService.checkUserName(username);
		response.getWriter().print(flag);
	}

	// ע��ҳ��������֤
	public void checkEmail(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		boolean flag = userService.checkEmail(email);
		response.getWriter().print(flag);
	}

	// ע��ҳ��������֤
	public void regist(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//��ȡ�û���Ϣ
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		//��װ�û�����
		User user=new User(name, email, username, password, new Date());
		boolean flag=userService.regist(user);
		if (flag) {
			response.sendRedirect("login.jsp");
		}
	}
}
