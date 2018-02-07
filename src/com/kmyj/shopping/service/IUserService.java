package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.User;

public interface IUserService {
	public boolean findManagerUser(User user);

	public boolean findUsualUser(User user);

	public List<User> findAllManagerUser();

	public List<User> findAllUsualUser();

	public boolean updateUser(User user, int id);

	public boolean insertUser(User user);

	public boolean delete(int id);

	User find(String name);

	public List<User> findAllManagerUser(String user);

	public boolean updateUser(User user);

	public boolean updateUser(String user, String pass, String oldpass);

	public List<User> searchUser(String uname, String truename);

	public List<User> searchManager(String uname, String truename);
}
