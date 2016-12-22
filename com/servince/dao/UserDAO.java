package com.servince.dao;

import java.util.List;

import com.servince.model.User;

public interface UserDAO {
	void saveUser(User user);
	void deleteUser(String username);
	List<User>seleteUserDate(User user);
	User login(String username, String password);
}
