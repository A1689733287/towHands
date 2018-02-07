package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IGoodsCarDao;
import com.kmyj.shopping.entity.GoodsCar;
import com.kmyj.shopping.util.DBoperation;

public class GoodsCarDao implements IGoodsCarDao {
	private DBoperation db = null;
	private List<GoodsCar> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public GoodsCarDao() {
		db = new DBoperation();
		list = new ArrayList<GoodsCar>();
	}

	@Override
	public List<GoodsCar> findAll() {
		try {
			sql = "select * from proscar";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				GoodsCar car = new GoodsCar();
				car.setId(rs.getInt("id"));
				car.setUname(rs.getString("uname"));
				car.setToname(rs.getString("toname"));
				car.setPname(rs.getString("pname"));
				car.setPrice(rs.getString("price"));
				car.setFilename(rs.getString("filename"));
				car.setStatus(rs.getString("status"));
				car.setSavetime(rs.getString("savetime"));
				car.setNums(rs.getInt("nums"));
				car.setWid(rs.getString("wid"));
				list.add(car);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean update(GoodsCar car, int id) {
		sql = "update proscar set nums='" + car.getNums()+ "' where id=" + id;
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(GoodsCar car) {
		sql = "Insert into proscar (uname,touname,pname,price,filename,status,nums,wid) values('"
				+ car.getUname()
				+ "','"
				+ car.getToname()
				+ "','"
				+ car.getPname()
				+ "','"
				+ car.getPrice()
				+ "','"
				+ car.getFilename()
				+ "','"
				+ car.getStatus()
				+ "','"
				+ car.getNums() + "','" + car.getWid() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from proscar where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public List<GoodsCar> find(String name) {
		GoodsCar car = null;
		try {
			sql = "select * from proscar where uname='" + name + "'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				car = new GoodsCar();
				car.setId(rs.getInt("id"));
				car.setUname(rs.getString("uname"));
				car.setToname(rs.getString("touname"));
				car.setPname(rs.getString("pname"));
				car.setPrice(rs.getString("price"));
				car.setFilename(rs.getString("filename"));
				car.setStatus(rs.getString("status"));
				car.setSavetime(rs.getString("savetime"));
				car.setNums(rs.getInt("nums"));
				car.setWid(rs.getString("wid"));
				list.add(car);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean delete(String uname) {
		sql = "delete from proscar where uname=" + uname + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

}
