package com.kmyj.shopping.dao;

import java.util.List;

import com.kmyj.shopping.entity.News;

public interface INewsDao {
	public List<News> findAll();

	public boolean update(News news, int id);

	public boolean insert(News news);

	public boolean delete(int id);

	News find(int id);

	public List<News> search(String title, String author);
}
