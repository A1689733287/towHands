package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.GoodsCar;

public interface IGoodsCarService {
	public List<GoodsCar> findAll();

	public boolean update(GoodsCar car, int id);

	public boolean insert(GoodsCar car);

	public boolean delete(int id);

	public boolean delete(String uname);

	List<GoodsCar> find(String uname);
}
