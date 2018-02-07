package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.IMessagesDao;
import com.kmyj.shopping.daoimp.MessagesDao;
import com.kmyj.shopping.entity.Messages;
import com.kmyj.shopping.service.IMessagesService;

public class MessagesService implements IMessagesService {
	IMessagesDao dao = new MessagesDao();

	@Override
	public List<Messages> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean update(Messages msg, int id) {
		// TODO Auto-generated method stub
		return dao.update(msg, id);
	}

	@Override
	public boolean insert(Messages msg) {
		// TODO Auto-generated method stub
		return dao.insert(msg);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	@Override
	public Messages find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public List<Messages> search(String saver, String content) {
		// TODO Auto-generated method stub
		return dao.search(saver,content);
	}

}
