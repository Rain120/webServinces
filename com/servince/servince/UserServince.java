package com.servince.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servince.dao.UserDAO;
import com.servince.dao.UserDAOImp;
import com.servince.model.User;
import com.servince.utils.DBUtils;

public class UserService {
	private static UserService userService = new UserService();

	private UserService() {
	}

	public static UserService getInstance() {
		return userService;
	}

	public void saveUser(User user) {
		// 逻辑数据类型转换
		Connection conn = DBUtils.getInstance().getConn();
		// 事务处理
		DBUtils.beginTransaction(conn);
		// 业务处理
		try {
			UserDAO userDAO = new UserDAOImp(conn);
			userDAO.saveUser(user);
			// 提交
			DBUtils.commit(conn);
		} catch (Exception e) {
			DBUtils.rollback(conn);
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void deleteUserDate(String username) {
		Connection conn = DBUtils.getInstance().getConn();
		try {
			UserDAOImp userDel = new UserDAOImp(conn);
			userDel.deleteUser(username);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public User Login(String username, String password) {
		User LoginUser = new User();
		Connection conn = DBUtils.getInstance().getConn();
		try {
			UserDAO userLogin = new UserDAOImp(conn);
			LoginUser = userLogin.login(username, password);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return LoginUser;		
	}
	public List<User> selectUser(User user){
		List<User> listUser = new ArrayList<User>();
		Connection conn = DBUtils.getInstance().getConn();
		try {
			UserDAO userSelete = new UserDAOImp(conn);
			listUser = userSelete.seleteUserDate(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listUser;
	}
}
