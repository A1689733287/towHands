package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IGoodsCarDao;
import com.kmyj.shopping.daoimp.GoodsCarDao;
import com.kmyj.shopping.entity.GoodsCar;
import com.kmyj.shopping.service.IGoodsCarService;

public class GoodsCarService implements IGoodsCarService {
	IGoodsCarDao dao = new GoodsCarDao();

	@Override
	public List<GoodsCar> findAll() {

		return dao.findAll();
	}

	@Override
	public boolean update(GoodsCar car, int id) {

		return dao.update(car, id);
	}

	@Override
	public boolean insert(GoodsCar car) {

		return dao.insert(car);
	}

	@Override
	public boolean delete(int id) {

		return dao.delete(id);
	}

	@Override
	public List<GoodsCar> find(String name) {
		
		return dao.find(name);
	}

	@Override
	public boolean delete(String uname) {
		// TODO Auto-generated method stub
		return dao.delete(uname);
	}

}
