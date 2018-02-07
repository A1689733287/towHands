package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kmyj.shopping.dao.IMessagesDao;
import com.kmyj.shopping.entity.Messages;
import com.kmyj.shopping.util.DBoperation;

public class MessagesDao implements IMessagesDao {
	private DBoperation db = null;
	private List<Messages> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public MessagesDao() {
		db = new DBoperation();
		list = new ArrayList<Messages>();
	}

	@Override
	public List<Messages> findAll() {
		try {
			sql = "select * from messages ";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Messages msg = new Messages();
				msg.setId(rs.getInt("id"));
				msg.setSaver(rs.getString("saver"));
				msg.setSavetime(rs.getString("savetime"));
				msg.setContent(rs.getString("content"));
				msg.setResaver(rs.getString("resaver"));
				msg.setRecontent(rs.getString("recontent"));
				msg.setResavetime(rs.getString("resavetime"));
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean update(Messages msg, int id) {
		sql = "update messages set resaver='" + msg.getResaver()
				+ "',recontent='" + msg.getRecontent() + "',resavetime='"
				+ msg.getResavetime() + "' where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Messages msg) {
		sql = "insert into messages(saver,savetime,content,resaver,recontent,resavetime) values('"
				+ msg.getSaver()
				+ "','"
				+ msg.getSavetime()
				+ "','"
				+ msg.getContent() + "','','','')";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from messages where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public Messages find(int id) {
		Messages msg = new Messages();
		return msg;
	}

	@Override
	public List<Messages> search(String saver, String content) {
		try {
			if(saver!=null&&content==""){
				sql = "select * from messages where saver like '%"+saver+"%'";
			}else if(content!=null&&saver==""){
				sql = "select * from messages where content like '%"+content+"%'";
			}
			else{
			sql = "select * from messages ";
			}rs = db.executeQuery(sql);
			while (rs.next()) {
				Messages msg = new Messages();
				msg.setId(rs.getInt("id"));
				msg.setSaver(rs.getString("saver"));
				msg.setSavetime(rs.getString("savetime"));
				msg.setContent(rs.getString("content"));
				msg.setResaver(rs.getString("resaver"));
				msg.setRecontent(rs.getString("recontent"));
				msg.setResavetime(rs.getString("resavetime"));
				list.add(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
