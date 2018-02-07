package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.GoodsCar;

public interface IGoodsCarDao {

	public List<GoodsCar> findAll();

	public boolean update(GoodsCar car, int id);

	public boolean insert(GoodsCar car);

	public boolean delete(int id);

	List<GoodsCar> find(String name);

	public boolean delete(String uname);
}
