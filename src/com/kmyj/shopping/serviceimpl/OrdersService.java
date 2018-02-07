package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IOrdersDao;
import com.kmyj.shopping.daoimp.OrdersDao;
import com.kmyj.shopping.entity.Orders;
import com.kmyj.shopping.service.IOrdersService;

public class OrdersService implements IOrdersService {
	IOrdersDao dao = new OrdersDao();

	@Override
	public List<Orders> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean update(Orders order, int id) {
		
		return dao.update(order, id);
	}

	@Override
	public boolean insert(Orders order) {
		
		return dao.insert(order);
	}

	@Override
	public boolean delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public Orders find(int id) {

		return dao.find(id);
	}

	@Override
	public List<Orders> findAll(String name) {
		
		return dao.findAll(name);
	}

	@Override
	public List<Orders> findToAll(String name) {
		
		return dao.findToAll(name);
	}

	@Override
	public boolean update(String status, int id) {
		
		return dao.update(status, id);
	}

	@Override
	public List<Orders> search(String uname, String ddinfo) {
		
		return dao.search(uname,ddinfo);
	}

}
