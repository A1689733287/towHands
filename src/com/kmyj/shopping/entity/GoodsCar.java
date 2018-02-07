package com.kmyj.shopping.entity;

//proscar
public class GoodsCar {
	private int id;// 购物车
	private String uname;// 用户名
	private String toname;// /真实姓名
	private String pname;// 物品名称
	private String price;// 物品价格
	private String filename;// 物品图片
	private String status;// 物品状态
	private String savetime;// 保存时间
	private int nums;// 数量
	private String wid;

	public GoodsCar() {
		super();
	}

	public GoodsCar(String uname, String toname, String pname, String price,
			String filename, String status, String savetime, int nums,
			String wid) {
		super();
		this.uname = uname;
		this.toname = toname;
		this.pname = pname;
		this.price = price;
		this.filename = filename;
		this.status = status;
		this.savetime = savetime;
		this.nums = nums;
		this.wid = wid;
	}

	public GoodsCar(String uname, String toname, String pname, String price,
			String filename, String status, String savetime, int nums) {
		super();
		this.uname = uname;
		this.toname = toname;
		this.pname = pname;
		this.price = price;
		this.filename = filename;
		this.status = status;
		this.savetime = savetime;
		this.nums = nums;
	}

	public GoodsCar(int id, String uname, String toname, String pname,
			String price, String filename, String status, String savetime,
			int nums) {
		super();
		this.id = id;
		this.uname = uname;
		this.toname = toname;
		this.pname = pname;
		this.price = price;
		this.filename = filename;
		this.status = status;
		this.savetime = savetime;
		this.nums = nums;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getToname() {
		return toname;
	}

	public void setToname(String toname) {
		this.toname = toname;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

	public int getNums() {
		return nums;
	}

	public void setNums(int nums) {
		this.nums = nums;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getWid() {
		return wid;
	}

	public void setWid(String wid) {
		this.wid = wid;
	}

}
