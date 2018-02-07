package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.Orders;

public interface IOrdersService {
	public List<Orders> findAll();

	public boolean update(Orders order, int id);

	public boolean insert(Orders order);

	public boolean delete(int id);

	Orders find(int id);

	public List<Orders> findAll(String name);

	public List<Orders> findToAll(String name);

	public boolean update(String status, int id);

	public List<Orders> search(String uname, String ddinfo);
}
