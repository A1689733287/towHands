package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IDataDescDao;
import com.kmyj.shopping.daoimp.DataDescDao;
import com.kmyj.shopping.entity.DataDesc;
import com.kmyj.shopping.service.IDataDescServics;

public class DataDescService implements IDataDescServics {
	IDataDescDao dao = new DataDescDao();

	@Override
	public List<DataDesc> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public boolean insert(DataDesc data) {
		// TODO Auto-generated method stub
		return dao.insert(data);
	}

	@Override
	public boolean update(DataDesc data) {
		// TODO Auto-generated method stub
		return dao.update(data);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public DataDesc find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public DataDesc find(String datatype) {
		
		return dao.find(datatype);
	}

}
