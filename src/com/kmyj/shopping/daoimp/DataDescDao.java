package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IDataDescDao;
import com.kmyj.shopping.entity.DataDesc;
import com.kmyj.shopping.util.DBoperation;

public class DataDescDao implements IDataDescDao {

	private DBoperation db = null;
	private List<DataDesc> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public DataDescDao() {
		db = new DBoperation();
		list = new ArrayList<DataDesc>();
	}

	@Override
	public List<DataDesc> findAll() {
		try {
			sql = "select * from zdatadic";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				DataDesc data = new DataDesc();
				data.setId(rs.getInt("id"));
				data.setDatatype(rs.getString("datatype"));
				data.setContent(rs.getString("content"));
				list.add(data);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean insert(DataDesc data) {
		sql = "insert into zdatadic(datatype,content) values('"
				+ data.getDatatype() + "','" + data.getContent() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean update(DataDesc data) {
		sql = "update zdatadic set content='" + data.getContent()
				+ "' where datatype='" + data.getDatatype() + "'";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from zdatadic where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public DataDesc find(int id) {
		DataDesc data = new DataDesc();
		return data;
	}

	@Override
	public DataDesc find(String datatype) {
		DataDesc data = null;
		try {
			sql = "select * from zdatadic where datatype='" + datatype + "'";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				data = new DataDesc();
				data.setContent(rs.getString("content"));
				data.setDatatype(rs.getString("datatype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

}
