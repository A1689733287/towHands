package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.Orders;

public interface IOrdersDao {
	public List<Orders> findAll();

	public boolean update(Orders order, int id);

	public boolean insert(Orders order);

	public boolean delete(int id);

	Orders find(int id);

	public List<Orders> findAll(String name);

	public List<Orders> findToAll(String name);

	boolean update(String status, int id);

	public List<Orders> search(String uname, String ddinfo);

}
