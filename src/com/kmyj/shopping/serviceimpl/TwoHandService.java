package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.ITwoHandDao;
import com.kmyj.shopping.daoimp.TwoHandDao;
import com.kmyj.shopping.entity.TwoHand;
import com.kmyj.shopping.service.ITwoHandService;

public class TwoHandService implements ITwoHandService {
	ITwoHandDao dao = new TwoHandDao();

	@Override
	public List<TwoHand> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean update(TwoHand twoh, int id) {
		// TODO Auto-generated method stub
		return dao.update(twoh, id);
	}

	@Override
	public boolean insert(TwoHand twoh) {
	
		return dao.insert(twoh);
	}

	@Override
	public boolean delete(int id) {
	
		return dao.delete(id);
	}

	@Override
	public TwoHand find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public List<TwoHand> infoFindAll() {
	
		return dao.infoFindAll();
	}

	@Override
	public List<TwoHand> find5Top() {
		// TODO Auto-generated method stub
		return dao.find5Top();
	}

	@Override
	public List<TwoHand> infoFindAll(String name) {
		// TODO Auto-generated method stub
		return dao.infoFindAll(name);
	}

	@Override
	public List<TwoHand> infoTFindAll(String wptype) {
		// TODO Auto-generated method stub
		return dao.infoTFindAll(wptype);
	}

	@Override
	public List<TwoHand> search(String title, String uname) {
		// TODO Auto-generated method stub
		return dao.search(title,uname);
	}

}
