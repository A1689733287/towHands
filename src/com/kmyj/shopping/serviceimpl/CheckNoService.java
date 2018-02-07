package com.kmyj.shopping.serviceimpl;

import com.kmyj.shopping.dao.ICheckNoDao;
import com.kmyj.shopping.daoimp.CheckNoDao;
import com.kmyj.shopping.service.ICheckNoService;

public class CheckNoService implements ICheckNoService {
	ICheckNoDao dao = new CheckNoDao();

	@Override
	public boolean select(String table, String col, String value) {
		// TODO Auto-generated method stub
		return dao.select(table, col, value);
	}

}
