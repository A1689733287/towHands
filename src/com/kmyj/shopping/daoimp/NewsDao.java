package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.INewsDao;
import com.kmyj.shopping.entity.News;
import com.kmyj.shopping.util.DBoperation;

public class NewsDao implements INewsDao {
	private DBoperation db = null;
	private List<News> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public NewsDao() {
		db = new DBoperation();
		list = new ArrayList<News>();
	}

	@Override
	public List<News> findAll() {
		try {
			sql = "select * from hbnews ";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setFilename(rs.getString("filename"));
				news.setContent(rs.getString("content"));
				news.setSavetime(rs.getString("savetime"));
				list.add(news);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	@Override
	public boolean update(News news, int id) {
		sql = "update hbnews set title='" + news.getTitle() + "',author='"
				+ news.getAuthor() + "' ,filename='" + news.getFilename()
				+ "',content='" + news.getContent() + "' ,savetime='"
				+ news.getSavetime() + "' where id=" + news.getId() + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(News news) {
		sql = "insert into hbnews(title,author,filename,content,savetime) values('"
				+ news.getTitle()
				+ "','"
				+ news.getAuthor()
				+ "','"
				+ news.getFilename()
				+ "','"
				+ news.getContent()
				+ "','"
				+ news.getSavetime() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from hbnews where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public News find(int id) {
		News news = null;
		try {
			sql = "select * from hbnews where id=" + id + "";
			rs = db.executeQuery(sql);
			if (rs.next()) {
				news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setFilename(rs.getString("filename"));
				news.setContent(rs.getString("content"));
				news.setSavetime(rs.getString("savetime"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return news;
	}

	@Override
	public List<News> search(String title, String author) {
		try {
			if(title!=null&&author==""){
			sql = "select * from hbnews where title like '%"+title+"%'";}
			else if(author!=null&&title==""){
				sql = "select * from hbnews where author like '%"+author+"%'";
			}else {
				sql="select * from hbnews";
			}
			rs = db.executeQuery(sql);
			while (rs.next()) {
				News news = new News();
				news.setId(rs.getInt("id"));
				news.setTitle(rs.getString("title"));
				news.setAuthor(rs.getString("author"));
				news.setFilename(rs.getString("filename"));
				news.setContent(rs.getString("content"));
				news.setSavetime(rs.getString("savetime"));
				list.add(news);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
