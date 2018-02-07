package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.kmyj.shopping.dao.ICheckNoDao;
import com.kmyj.shopping.util.DBoperation;

public class CheckNoDao implements ICheckNoDao {
	private DBoperation db = null;
	private ResultSet rs = null;
	private String sql = null;

	public CheckNoDao() {
		db = new DBoperation();
	}

	@Override
	public boolean select(String table, String col, String value) {
		sql = "select * from " + table + " where " + col + "='" + value + "'";
		try {
			rs = db.executeQuery(sql);
			if (rs != null & rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
