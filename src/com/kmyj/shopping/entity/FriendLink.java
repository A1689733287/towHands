package com.kmyj.shopping.entity;

/**
 * 友情链接yqlj
 * 
 * @author G
 * 
 */
public class FriendLink {
	private int id;// id
	private String linkname;// 链接名称
	private String linkurl;// 链接地址

	public FriendLink() {
		super();
	}

	public FriendLink(String linkname, String linkurl) {
		super();
		this.linkname = linkname;
		this.linkurl = linkurl;
	}

	public FriendLink(int id, String linkname, String linkurl) {
		super();
		this.id = id;
		this.linkname = linkname;
		this.linkurl = linkurl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLinkname() {
		return linkname;
	}

	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

}
