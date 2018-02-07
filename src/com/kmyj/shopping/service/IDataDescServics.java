package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.DataDesc;

public interface IDataDescServics {
	public List<DataDesc> findAll();

	public boolean insert(DataDesc data);

	public boolean update(DataDesc data);

	public boolean delete(int id);

	DataDesc find(int id);

	DataDesc find(String datatype);
}
