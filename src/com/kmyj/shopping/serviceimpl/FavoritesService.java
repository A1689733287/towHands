package com.kmyj.shopping.serviceimpl;

import java.util.HashMap;
import com.kmyj.shopping.dao.IFavoritesDao;
import com.kmyj.shopping.daoimp.FavoritesDao;
import com.kmyj.shopping.entity.Favorites;
import com.kmyj.shopping.service.IFavoritesService;

public class FavoritesService implements IFavoritesService {
	IFavoritesDao dao = new FavoritesDao();

	@Override
	public HashMap<String, Object> findAll(String uname) {

		return dao.findAll(uname);
	}

	@Override
	public boolean update(Favorites fav, int id) {

		return dao.update(fav, id);
	}

	@Override
	public boolean insert(Favorites fav) {

		return dao.insert(fav);
	}

	@Override
	public boolean delete(int id) {

		return dao.delete(id);
	}

	@Override
	public Favorites find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

}
