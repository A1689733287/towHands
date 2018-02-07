package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.ITwoHandDao;
import com.kmyj.shopping.entity.TwoHand;
import com.kmyj.shopping.util.DBoperation;

public class TwoHandDao implements ITwoHandDao {
	private DBoperation db = null;
	private List<TwoHand> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public TwoHandDao() {
		db = new DBoperation();
		list = new ArrayList<TwoHand>();
	}

	@Override
	public List<TwoHand> findAll() {
		try {
			sql = "select * from secondhand";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(TwoHand twoh, int id) {
		sql = "update secondhand set title='" + twoh.getTitle() + "',wpbei='"
				+ twoh.getWpdes() + "',filename='" + twoh.getFilename()
				+ "',lxr='" + twoh.getLxr() + "',lxtel='" + twoh.getLxtel()
				+ "',lxqq='" + twoh.getLxqq() + "',lxaddrs='"
				+ twoh.getLxaddress() + "',price='" + twoh.getPrice()
				+ "',wptype='" + twoh.getWptype() + "' where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(TwoHand twoh) {
		sql = "insert into secondhand(title,wpbei,filename,lxr,lxtel,lxaddrs,lxqq,price,wptype) values('"
				+ twoh.getTitle()
				+ "','"
				+ twoh.getWpdes()
				+ "','"
				+ twoh.getFilename()
				+ "','"
				+ twoh.getLxr()
				+ "','"
				+ twoh.getLxtel()
				+ "','"
				+ twoh.getLxaddress()
				+ "','"
				+ twoh.getLxqq()
				+ "','"
				+ twoh.getPrice()
				+ "','"
				+ twoh.getWptype() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from secondhand where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public TwoHand find(int id) {
		TwoHand twoHand = null;
		try {
			sql = "select * from secondhand where id=" + id + "";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return twoHand;
	}

	@Override
	public List<TwoHand> infoFindAll() {
		try {
			sql = "select * from secondhand where infotype='二手交易'";
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
				list.add(twoHand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TwoHand> find5Top() {
		try {
			sql = "select top 5 * from secondhand";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
				list.add(twoHand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TwoHand> infoFindAll(String name) {
		try {
			sql = "select * from secondhand where infotype='二手交易' and uname='"
					+ name + "'";
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
				list.add(twoHand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TwoHand> infoTFindAll(String wptype) {
		try {
			sql = "select * from secondhand where infotype='二手交易' and wptype='"
					+ wptype + "'";
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
				list.add(twoHand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<TwoHand> search(String title, String uname) {
		try {
			if(title!=null&&uname==""){
			sql = "select * from secondhand where title like '%"+title+"%'";}
			else if(uname!=null&&title==""){
				sql = "select * from secondhand where uname like '%"+uname+"%'";
			}
			else{
				sql="select * from secondhand";
			}
			rs = db.executeQuery(sql);
			while (rs.next()) {
				TwoHand twoHand = new TwoHand();
				twoHand.setId(rs.getInt("id"));
				twoHand.setTitle(rs.getString("title"));
				twoHand.setWpdes(rs.getString("wpbei"));
				twoHand.setFilename(rs.getString("filename"));
				twoHand.setLxr(rs.getString("lxr"));
				twoHand.setLxtel(rs.getString("lxtel"));
				twoHand.setLxqq(rs.getString("lxqq"));
				twoHand.setLxaddress(rs.getString("lxaddrs"));
				twoHand.setPrice(rs.getFloat("price"));
				twoHand.setUname(rs.getString("uname"));
				twoHand.setSavetime(rs.getString("savetime"));
				twoHand.setInfotype(rs.getString("infotype"));
				twoHand.setWptype(rs.getString("wptype"));
				list.add(twoHand);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
