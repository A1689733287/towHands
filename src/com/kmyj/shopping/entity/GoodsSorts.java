package com.kmyj.shopping.entity;

/*
 * 物品分类wpfl
 */
public class GoodsSorts {
	private int id;
	private String typename;// 类型名称

	public GoodsSorts() {
		super();
	}

	public GoodsSorts(String typename) {
		super();
		this.typename = typename;
	}

	public GoodsSorts(int id, String typename) {
		super();
		this.id = id;
		this.typename = typename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

}
