package com.kmyj.shopping.daoimp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.kmyj.shopping.dao.IFavoritesDao;
import com.kmyj.shopping.entity.Favorites;
import com.kmyj.shopping.entity.TwoHand;
import com.kmyj.shopping.util.DBoperation;

public class FavoritesDao implements IFavoritesDao {

	private DBoperation db = null;
	private List<Object> list = null;
	private ResultSet rs = null;
	private String sql = null;

	public FavoritesDao() {
		db = new DBoperation();
		list = new ArrayList<Object>();

	}

	@Override
	public HashMap<String, Object> findAll(String uname) {
		List<Favorites> favs = new ArrayList<Favorites>();
		List<TwoHand> twohs = new ArrayList<TwoHand>();
		HashMap<String, Object> map = null;
		map = new HashMap<String, Object>();
		try {
			sql = "select secondhand.title,secondhand.wpbei,secondhand.filename,secondhand.lxr,secondhand.lxtel,secondhand.lxqq,secondhand.lxaddrs,secondhand.price,secondhand.uname,secondhand.savetime,secondhand.infotype,secondhand.wptype,scj.*  from secondhand right join scj on secondhand.id=scj.wid where scj.uname='"
					+ uname + "'";
			rs = db.executeQuery(sql);
			while (rs.next()) {
				Favorites fav = new Favorites();
				TwoHand twoh = new TwoHand();
				fav.setId(rs.getInt("id") == 0 ? 0 : rs.getInt("id"));
				fav.setWpid(rs.getString("wid") == null ? " " : rs
						.getString("wid"));
				twoh.setTitle(rs.getString("title") == null ? " " : rs
						.getString("title"));
				twoh.setWpdes(rs.getString("wpbei") == null ? " " : rs
						.getString("wpbei"));
				twoh.setFilename(rs.getString("filename") == null ? " " : rs
						.getString("filename"));
				twoh.setLxr(rs.getString("lxr") == null ? " " : rs
						.getString("lxr"));
				twoh.setLxtel(rs.getString("lxtel") == null ? " " : rs
						.getString("lxtel"));
				twoh.setLxqq(rs.getString("lxqq") == null ? " " : rs
						.getString("lxqq"));
				twoh.setLxaddress(rs.getString("lxaddrs") == null ? " " : rs
						.getString("lxaddrs"));
				twoh.setPrice(rs.getFloat("price") == 0 ? 0 : rs
						.getFloat("price"));
				twoh.setUname(rs.getString("uname") == null ? " " : rs
						.getString("uname"));
				twoh.setSavetime(rs.getString("savetime") == null ? " " : rs
						.getString("savetime"));
				twoh.setInfotype(rs.getString("infotype") == null ? " " : rs
						.getString("infotype"));
				twoh.setWptype(rs.getString("wptype") == null ? " " : rs
						.getString("wptype"));
				favs.add(fav);
				twohs.add(twoh);
			}

			map.put("fav", favs == null ? " " : favs);
			map.put("twoh", twohs == null ? " " : twohs);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {

		}

		return map;
	}

	@Override
	public boolean update(Favorites fav, int id) {
		sql = "update scj set sctype=" + fav.getSctype() + ",uname="
				+ fav.getUname() + " ,wid=" + fav.getWpid() + " where id=" + id
				+ "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Favorites fav) {
		sql = "insert into scj(sctype,uname,wid) values('" + fav.getSctype()
				+ "','" + fav.getUname() + "','" + fav.getWpid() + "')";
		if (db.executeUpdate(sql)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		sql = "delete from scj where id=" + id + "";
		if (db.executeUpdate(sql)) {
			return true;
		}
		return false;
	}

	@Override
	public Favorites find(int id) {
		Favorites fav = new Favorites();

		return fav;
	}

}
