package com.kmyj.shopping.entity;

/*
 * 
 */
public class DataDesc {
	private int id;// id
	private String datatype;// 数据类型
	private String content;// 数据内容

	public DataDesc() {
		super();
	}

	public DataDesc(int id, String datatype, String content) {
		super();
		this.id = id;
		this.datatype = datatype;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
