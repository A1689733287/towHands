package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IFriendLinkDao;
import com.kmyj.shopping.daoimp.FriendLinkDao;
import com.kmyj.shopping.entity.FriendLink;
import com.kmyj.shopping.service.IFriendLinkService;

public class FriendLinkService implements IFriendLinkService {
	IFriendLinkDao dao = new FriendLinkDao();

	@Override
	public List<FriendLink> findAll() {

		return dao.findAll();
	}

	@Override
	public boolean insert(FriendLink flk) {

		return dao.insert(flk);
	}

	@Override
	public boolean update(FriendLink flk, int id) {

		return dao.update(flk, id);
	}

	@Override
	public boolean delete(int id) {

		return dao.delete(id);
	}


	@Override
	public List<FriendLink> search(String ljname) {
		// TODO Auto-generated method stub
		return dao.search(ljname);
	}

}
