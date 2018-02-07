package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IGoodsSortsDao;
import com.kmyj.shopping.entity.GoodsSorts;
import com.kmyj.shopping.util.DBoperation;

public class GoodsSortsDao implements IGoodsSortsDao {
	private DBoperation db = null;
	private ResultSet rs = null;
	private String sql = "";
	private List<GoodsSorts> list = null;

	public GoodsSortsDao() {
		db = new DBoperation();
		list = new ArrayList<GoodsSorts>();
	}

	@Override
	public List<GoodsSorts> findAll() {
		try {
			sql = "select * from wpfl ";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				GoodsSorts gs = new GoodsSorts();
				gs.setId(rs.getInt("id"));
				gs.setTypename(rs.getString("typename"));
				list.add(gs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean insert(GoodsSorts gs) {
		sql = "insert into wpfl(typename) values('" + gs.getTypename() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(GoodsSorts gs, int id) {
		sql = "update wpfl set typename='" + gs.getTypename() + "' where id="
				+ id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from wpfl where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public GoodsSorts find(int id) {
		GoodsSorts gs = new GoodsSorts();

		return gs;
	}

	public int getInt(String sql) {
		int i = 0;
		try {
			rs = db.executeQuery(sql);
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<GoodsSorts> search(String typename) {
		try {
			sql = "select * from wpfl where typename like '%"+typename+"%'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				GoodsSorts gs = new GoodsSorts();
				gs.setId(rs.getInt("id"));
				gs.setTypename(rs.getString("typename"));
				list.add(gs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
