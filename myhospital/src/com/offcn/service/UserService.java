package com.offcn.service;

import javax.servlet.http.HttpSession;

import com.offcn.dao.UserDao;
import com.offcn.entity.User;

public class UserService {
	UserDao userDao = new UserDao();

	// 根据用户名和密码
	public boolean checkLogin(User user, String verifyCode, HttpSession session) {
		User loginUser = userDao.findUserByUserNameAndPwd(user);
		// 验证数据库中存在此用户，且用户输入的验证码与生成的验证码保持一致
		if (loginUser != null) {
			session.setAttribute("user", loginUser);
			return true;
		}
		return false;
	}

	// 验证码验证
	public boolean checkVerifyCode(String verifyCode, HttpSession session) {
		// 从session中取出生成的验证码
		String verCode = (String) session.getAttribute("verCode");
		// 验证数据库中存在此用户，且用户输入的验证码与生成的验证码保持一致
		if (verifyCode.equalsIgnoreCase(verCode)) {
			return true;
		}
		return false;
	}
	//查询用户名是否已被注册
	public boolean checkUserName(String username) {
		User user=userDao.checkUserName(username);
		return user==null?false:true;
	}
	//查询邮箱是否已被注册
	public boolean checkEmail(String email) {
		User user=userDao.checkEmail(email);
		return user==null?false:true;
	}
	//注册
	public boolean regist(User user) {
		return userDao.insertStudent(user)>0?true:false;
	}
}
