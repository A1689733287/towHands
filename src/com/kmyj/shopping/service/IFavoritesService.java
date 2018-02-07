package com.kmyj.shopping.service;

import java.util.HashMap;
import com.kmyj.shopping.entity.Favorites;

public interface IFavoritesService {
	public HashMap<String, Object> findAll(String uname);

	public boolean update(Favorites fav, int id);

	public boolean insert(Favorites fav);

	public boolean delete(int id);

	Favorites find(int id);
}
