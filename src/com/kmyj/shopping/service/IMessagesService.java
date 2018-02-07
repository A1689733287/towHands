package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.Messages;

public interface IMessagesService {
	public List<Messages> findAll();

	public boolean update(Messages msg, int id);

	public boolean insert(Messages msg);

	public boolean delete(int id);

	Messages find(int id);

	public List<Messages> search(String saver, String content);
}
