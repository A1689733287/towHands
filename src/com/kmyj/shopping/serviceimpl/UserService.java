package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IUserDao;
import com.kmyj.shopping.daoimp.UserDao;
import com.kmyj.shopping.entity.User;
import com.kmyj.shopping.service.IUserService;

public class UserService implements IUserService {
	IUserDao dao = new UserDao();

	@Override
	public boolean findManagerUser(User user) {

		return dao.findManagerUser(user);
	}

	@Override
	public boolean findUsualUser(User user) {

		return dao.findUsualUser(user);
	}

	@Override
	public List<User> findAllManagerUser() {

		return dao.findAllManagerUser();
	}

	@Override
	public List<User> findAllUsualUser() {

		return dao.findAllUsualUser();
	}

	@Override
	public boolean updateUser(User user, int id) {

		return dao.updateUser(user, id);
	}

	@Override
	public boolean insertUser(User user) {

		return dao.insertUser(user);
	}

	@Override
	public boolean delete(int id) {
		return dao.delete(id);
	}

	@Override
	public User find(String name) {
		// TODO Auto-generated method stub
		return dao.find(name);
	}

	@Override
	public List<User> findAllManagerUser(String user) {
		// TODO Auto-generated method stub
		return dao.findAllManagerUser(user);
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return dao.updateUser(user);
	}

	@Override
	public boolean updateUser(String user, String pass, String oldpass) {
		// TODO Auto-generated method stub
		return dao.updateUser(user, pass, oldpass);
	}

	@Override
	public List<User> searchUser(String uname, String truename) {
		// TODO Auto-generated method stub
		return dao.searchUser(uname, truename);
	}

	@Override
	public List<User> searchManager(String uname, String truename) {
		// TODO Auto-generated method stub
		return dao.searchManager(uname, truename);
	}

}
