package com.kmyj.shopping.serviceimpl;

import java.util.List;

import com.kmyj.shopping.dao.INewsDao;
import com.kmyj.shopping.daoimp.NewsDao;
import com.kmyj.shopping.entity.News;
import com.kmyj.shopping.service.INewsService;

public class NewsService implements INewsService {
	INewsDao dao = new NewsDao();

	@Override
	public List<News> findAll() {
		
		return dao.findAll();
	}

	@Override
	public boolean update(News news, int id) {
	
		return dao.update(news, id);
	}

	@Override
	public boolean insert(News news) {
		
		return dao.insert(news);
	}

	@Override
	public boolean delete(int id) {
		
		return dao.delete(id);
	}

	@Override
	public News find(int id) {
		// TODO Auto-generated method stub
		return dao.find(id);
	}

	@Override
	public List<News> search(String title, String author) {
		// TODO Auto-generated method stub
		return dao.search(title, author);
	}

}
