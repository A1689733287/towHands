package com.kmyj.shopping.service;

import java.util.List;

import com.kmyj.shopping.entity.News;

public interface INewsService {
	public List<News> findAll();

	public boolean update(News news, int id);

	public boolean insert(News news);

	public boolean delete(int id);

	News find(int id);

	public List<News> search(String title, String author);
}
