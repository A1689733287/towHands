package com.kmyj.shopping.entity;

/**
 * 收藏夹scj
 * 
 * @author G
 * 
 */
public class Favorites {

	private int id;// id
	private String sctype;// 收藏类型
	private String uname;// 用户名
	private String wpid;// 物品id

	public Favorites() {
		super();
	}

	public Favorites(int id, String sctype, String uname, String wpid) {
		super();
		this.id = id;
		this.sctype = sctype;
		this.uname = uname;
		this.wpid = wpid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSctype() {
		return sctype;
	}

	public void setSctype(String sctype) {
		this.sctype = sctype;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getWpid() {
		return wpid;
	}

	public void setWpid(String wpid) {
		this.wpid = wpid;
	}

}
