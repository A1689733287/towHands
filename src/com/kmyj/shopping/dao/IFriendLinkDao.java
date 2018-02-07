package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.FriendLink;

public interface IFriendLinkDao {
	public List<FriendLink> findAll();

	public boolean insert(FriendLink flk);

	public boolean update(FriendLink flk, int id);

	public boolean delete(int id);


	public List<FriendLink> search(String ljname);

}
