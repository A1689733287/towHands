package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IGoodsSortsDao;
import com.kmyj.shopping.daoimp.GoodsSortsDao;
import com.kmyj.shopping.entity.GoodsSorts;
import com.kmyj.shopping.service.IGoodsSortsService;

public class GoodsSortsService implements IGoodsSortsService {
	IGoodsSortsDao dao = new GoodsSortsDao();

	@Override
	public List<GoodsSorts> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean insert(GoodsSorts gs) {
	
		return dao.insert(gs);
	}

	@Override
	public boolean update(GoodsSorts gs, int id) {
		// TODO Auto-generated method stub
		return dao.update(gs, id);
	}

	@Override
	public boolean delete(int id) {
	
		return dao.delete(id);
	}

	@Override
	public GoodsSorts find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public int getInt(String sql) {
		// TODO Auto-generated method stub
		return dao.getInt(sql);
	}

	@Override
	public List<GoodsSorts> search(String typename) {
		// TODO Auto-generated method stub
		return dao.search(typename);
	}

}
