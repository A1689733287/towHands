package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.TwoHand;

public interface ITwoHandService {
	public List<TwoHand> findAll();

	public boolean update(TwoHand twoh, int id);

	public boolean insert(TwoHand twoh);

	public boolean delete(int id);

	TwoHand find(int id);

	public List<TwoHand> infoFindAll();

	public List<TwoHand> infoFindAll(String name);

	public List<TwoHand> infoTFindAll(String wptype);

	public List<TwoHand> find5Top();

	public List<TwoHand> search(String title, String uname);
}
