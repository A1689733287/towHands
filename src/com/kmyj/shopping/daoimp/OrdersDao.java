package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IOrdersDao;
import com.kmyj.shopping.entity.Orders;
import com.kmyj.shopping.util.DBoperation;

public class OrdersDao implements IOrdersDao {
	private DBoperation db = null;
	private List<Orders> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public OrdersDao() {
		db = new DBoperation();
		list = new ArrayList<Orders>();
	}

	@Override
	public List<Orders> findAll() {
		try {
			sql = "select * from prosorders ";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				order.setUname(rs.getString("uname"));
				order.setTouname(rs.getString("touname"));
				order.setDdinfo(rs.getString("ddinfo"));
				order.setLxr(rs.getString("lxr"));
				order.setLxtel(rs.getString("lxtel"));
				order.setLxqq(rs.getString("lxqq"));
				order.setAddress(rs.getString("addrs"));
				order.setFkfs(rs.getString("fkfs"));
				order.setStatus(rs.getString("status"));
				order.setSavetime(rs.getString("savetime"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(Orders order, int id) {
		sql = "update prosorders set uname='" + order.getUname()
				+ "',touname='" + order.getTouname() + "',ddinfo='"
				+ order.getDdinfo() + "',lxr='" + order.getLxr() + "',lxtel='"
				+ order.getLxtel() + "',lxqq='" + order.getLxqq() + "',addrs='"
				+ order.getAddress() + "',status='" + order.getStatus()
				+ "',savetime='" + order.getSavetime() + "' where id="
				+ order.getId() + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Orders order) {
		sql = "insert into prosorders(uname,touname,ddinfo,lxr,lxtel,lxqq,addrs,fkfs,status,savetime) values('"
				+ order.getUname()
				+ "','"
				+ order.getTouname()
				+ "','"
				+ order.getDdinfo()
				+ "<br />','"
				+ order.getLxr()
				+ "','"
				+ order.getLxtel()
				+ "','"
				+ order.getLxqq()
				+ "','"
				+ order.getAddress()
				+ "','"
				+ order.getFkfs()
				+ "','"
				+ order.getStatus() + "','" + order.getSavetime() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from prosorders where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public Orders find(int id) {
		Orders orders = new Orders();

		// TODO Auto-generated method stub
		return orders;
	}

	@Override
	public List<Orders> findAll(String name) {
		try {
			sql = "select * from prosorders where uname='" + name + "'";
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				order.setUname(rs.getString("uname"));
				order.setTouname(rs.getString("touname"));
				order.setDdinfo(rs.getString("ddinfo"));
				order.setLxr(rs.getString("lxr"));
				order.setLxtel(rs.getString("lxtel"));
				order.setLxqq(rs.getString("lxqq"));
				order.setAddress(rs.getString("addrs"));
				order.setFkfs(rs.getString("fkfs"));
				order.setStatus(rs.getString("status"));
				order.setSavetime(rs.getString("savetime"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Orders> findToAll(String name) {
		try {
			sql = "select * from prosorders where touname='" + name + "'";
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				order.setUname(rs.getString("uname"));
				order.setTouname(rs.getString("touname"));
				order.setDdinfo(rs.getString("ddinfo"));
				order.setLxr(rs.getString("lxr"));
				order.setLxtel(rs.getString("lxtel"));
				order.setLxqq(rs.getString("lxqq"));
				order.setAddress(rs.getString("addrs"));
				order.setFkfs(rs.getString("fkfs"));
				order.setStatus(rs.getString("status"));
				order.setSavetime(rs.getString("savetime"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(String status, int id) {
		sql = "update prosorders set status='" + status + "' where id=" + id
				+ "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Orders> search(String uname, String ddinfo) {
		try {
			if (uname != null&&ddinfo=="") {
				sql = "select * from prosorders where touname like '%"+uname+"%'";
			} else if (ddinfo != null&&uname=="") {
				sql = "select * from prosorders where ddinfo like '%"+ddinfo+"%'";
			}else{
				sql="select * from prosorders";
			}
			System.out.print(sql);
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Orders order = new Orders();
				order.setId(rs.getInt("id"));
				order.setUname(rs.getString("uname"));
				order.setTouname(rs.getString("touname"));
				order.setDdinfo(rs.getString("ddinfo"));
				order.setLxr(rs.getString("lxr"));
				order.setLxtel(rs.getString("lxtel"));
				order.setLxqq(rs.getString("lxqq"));
				order.setAddress(rs.getString("addrs"));
				order.setFkfs(rs.getString("fkfs"));
				order.setStatus(rs.getString("status"));
				order.setSavetime(rs.getString("savetime"));
				list.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
