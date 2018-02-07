package com.kmyj.shopping.dao;

import java.util.HashMap;
import java.util.List;

import com.kmyj.shopping.entity.Favorites;

public interface IFavoritesDao {
	public HashMap findAll(String uname);

	public boolean update(Favorites fav, int id);

	public boolean insert(Favorites fav);

	public boolean delete(int id);

	Favorites find(int id);
}
