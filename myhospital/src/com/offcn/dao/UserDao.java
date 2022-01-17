package com.offcn.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.offcn.entity.User;

public class UserDao {
	QueryRunner qRunner=new QueryRunner(new ComboPooledDataSource());
	//�����û���������
	public User findUserByUserNameAndPwd(User user) {
		String sql="SELECT * FROM USERS WHERE username=? AND PASSWORD=? AND STATUS=1";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),user.getUsername(),user.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��ѯ�û����Ƿ��ѱ�ע��
	public User checkUserName(String username) {
		String sql="SELECT * FROM users WHERE username=?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),username);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//��ѯ�����Ƿ��ѱ�ע��
	public User checkEmail(String email) {
		String sql="SELECT * FROM users WHERE email=?";
		try {
			return qRunner.query(sql, new BeanHandler<User>(User.class),email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	//����û�
	public int insertStudent(User user) {
		String sql="INSERT INTO users (NAME,email,username,PASSWORD,modifytime)VALUES(?,?,?,?,?)";
		try {
			return qRunner.update(sql, user.getName(),user.getEmail(),user.getUsername(),user.getPassword(),user.getModifytime());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
