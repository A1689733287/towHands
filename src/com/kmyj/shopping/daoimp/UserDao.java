package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IUserDao;
import com.kmyj.shopping.entity.User;
import com.kmyj.shopping.util.DBoperation;

public class UserDao implements IUserDao {
	private DBoperation db = null;
	private ResultSet rs = null;
	private String sql = "";
	private List<User> list = null;

	public UserDao() {
		db = new DBoperation();
		list = new ArrayList<User>();
	}

	@Override
	public boolean findManagerUser(User user) {
		try {
			sql = "select * from users where username='" + user.getUsername()
					+ "' and usertype='管理员' and userpass='"
					+ user.getUserpass() + "'";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean findUsualUser(User user) {
		try {
			sql = "select * from users where username='" + user.getUsername()
					+ "' and userpass='" + user.getUserpass() + "'";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<User> findAllManagerUser() {

		try {
			sql = "select * from users where usertype='管理员'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<User> findAllUsualUser() {
		try {
			sql = "select * from users where usertype='会员'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean updateUser(User user, int id) {
		String sql = "update users set username='" + user.getUsername()
				+ "',userpass='" + user.getUserpass() + "',truename='"
				+ user.getTruename() + "',sex='" + user.getSex() + "',qq='"
				+ user.getQq() + "',phoneno='" + user.getPhoneno()
				+ "',email='" + user.getEmail() + "',dizhi='"
				+ user.getAddress() + "',filename='" + user.getFilename()
				+ "' where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertUser(User user) {
		sql = "insert into users(username,userpass,truename,sex,qq,phoneno,email,dizhi,usertype,filename,savetime) values('"
				+ user.getUsername()
				+ "','"
				+ user.getUserpass()
				+ "','"
				+ user.getTruename()
				+ "','"
				+ user.getSex()
				+ "','"
				+ user.getQq()
				+ "','"
				+ user.getPhoneno()
				+ "','"
				+ user.getEmail()
				+ "','"
				+ user.getAddress()
				+ "','"
				+ user.getUserType()
				+ "','"
				+ user.getFilename()
				+ "','"
				+ user.getSavetime() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from users where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public User find(String name) {
		User user = null;
		try {
			sql = "select * from users where username='" + name + "'";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setFilename(rs.getString("filename"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findAllManagerUser(String name) {

		try {
			sql = "select * from users where username=" + name + "";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update users set userpass='" + user.getUserpass()
				+ "',truename='" + user.getTruename() + "',sex='"
				+ user.getSex() + "',qq='" + user.getQq() + "',phoneno='"
				+ user.getPhoneno() + "',email='" + user.getEmail()
				+ "',dizhi='" + user.getAddress() + "',filename='"
				+ user.getFilename() + "' where username='"
				+ user.getUsername() + "'";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(String user, String pass, String oldpass) {
		String sql = "update users set userpass='" + pass
				+ "' where username='" + user + "' and userpass='" + oldpass
				+ "'";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> searchUser(String uname, String truename) {
		try {
			if(uname!=null&&truename==""){
				sql = "select * from users where usertype='会员' and username like'%"+uname+"%'";
			}else if(truename!=null&&uname==""){
				sql = "select * from users where usertype='会员' and truename like'%"+truename+"%'";
			}else{
			sql = "select * from users where usertype='会员'";}
			rs = db.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public List<User> searchManager(String uname, String truename) {
		try {
			if(uname!=null&&truename==""){
				sql = "select * from users where usertype='管理员' and username like'%"+uname+"%'";
			}else if(truename!=null&&uname==""){
				sql = "select * from users where usertype='管理员' and truename like'%"+truename+"%'";
			}else{
			sql = "select * from users where usertype='管理员'";}
			rs = db.executeQuery(sql);
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setUserpass(rs.getString("userpass"));
				user.setTruename(rs.getString("truename"));
				user.setSex(rs.getString("sex"));
				user.setQq(rs.getString("qq"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("dizhi"));
				user.setUserType(rs.getString("usertype"));
				user.setSavetime(rs.getString("savetime"));
				list.add(user);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
