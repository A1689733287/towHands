package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.DataDesc;

public interface IDataDescDao {
	//
	public List<DataDesc> findAll();

	public boolean insert(DataDesc data);

	public boolean update(DataDesc data);

	public boolean delete(int id);

	DataDesc find(int id);

	public DataDesc find(String datatype);
}
