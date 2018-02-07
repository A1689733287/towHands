package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IFriendLinkDao;
import com.kmyj.shopping.entity.FriendLink;
import com.kmyj.shopping.util.DBoperation;

public class FriendLinkDao implements IFriendLinkDao {
	private DBoperation db = null;
	private List<FriendLink> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public FriendLinkDao() {
		db = new DBoperation();
		list = new ArrayList<FriendLink>();
	}

	@Override
	public List<FriendLink> findAll() {
		try {
			sql = "select * from yqlj ";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				FriendLink flk = new FriendLink();
				flk.setId(rs.getInt("id"));
				flk.setLinkname(rs.getString("ljname"));
				flk.setLinkurl(rs.getString("ljurl"));
				list.add(flk);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean insert(FriendLink flk) {
		sql = "insert into yqlj(ljname,ljurl) values('" + flk.getLinkname()
				+ "','" + flk.getLinkurl() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean update(FriendLink flk, int id) {
		sql = "update yqlj set ljname='" + flk.getLinkname() + "',ljurl='"
				+ flk.getLinkurl() + "' where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from yqlj where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public List<FriendLink> search(String ljname) {
		try {
			sql = "select * from yqlj where ljname like '%" + ljname + "%'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				FriendLink flk = new FriendLink();
				flk.setId(rs.getInt("id"));
				flk.setLinkname(rs.getString("ljname"));
				flk.setLinkurl(rs.getString("ljurl"));
				list.add(flk);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}
}
