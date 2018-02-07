package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.GoodsSorts;

public interface IGoodsSortsDao {

	public List<GoodsSorts> findAll();

	public boolean insert(GoodsSorts gs);

	public boolean update(GoodsSorts gs, int id);

	public boolean delete(int id);

	GoodsSorts find(int id);

	int getInt(String sql);

	public List<GoodsSorts> search(String typename);

}
