package com.kmyj.shopping.entity;

//secondhands
public class TwoHand {
	private int id;
	private String title;// 交易物品名称
	private String wpdes;// 物品描述
	private String filename;// 物品图片
	private String lxr;// 联系人
	private String lxtel;// 联系手机
	private String lxaddress;// 联系地址
	private String lxqq;// 联系qq
	private float price;// 物品价格
	private String uname;// 用户姓名
	private String savetime;// 保存时间
	private String infotype;// 交易类型
	private String wptype;// 物品类型

	public TwoHand() {
		super();
	}

	public TwoHand(String title, String wpdes, String filename, String lxr,
			String lxtel, String lxaddress, String lxqq, float price,
			String wptype) {
		super();
		this.title = title;
		this.wpdes = wpdes;
		this.filename = filename;
		this.lxr = lxr;
		this.lxtel = lxtel;
		this.lxaddress = lxaddress;
		this.lxqq = lxqq;
		this.price = price;
		this.wptype = wptype;
	}

	public TwoHand(String title, String wpdes, String filename, String lxr,
			String lxtel, String lxaddress, String lxqq, float price,
			String uname, String savetime, String infotype, String wptype) {
		super();
		this.title = title;
		this.wpdes = wpdes;
		this.filename = filename;
		this.lxr = lxr;
		this.lxtel = lxtel;
		this.lxaddress = lxaddress;
		this.lxqq = lxqq;
		this.price = price;
		this.uname = uname;
		this.savetime = savetime;
		this.infotype = infotype;
		this.wptype = wptype;
	}

	public TwoHand(int id, String title, String wpdes, String filename,
			String lxr, String lxtel, String lxaddress, String lxqq,
			float price, String uname, String savetime, String infotype,
			String wptype) {
		super();
		this.id = id;
		this.title = title;
		this.wpdes = wpdes;
		this.filename = filename;
		this.lxr = lxr;
		this.lxtel = lxtel;
		this.lxaddress = lxaddress;
		this.lxqq = lxqq;
		this.price = price;
		this.uname = uname;
		this.savetime = savetime;
		this.infotype = infotype;
		this.wptype = wptype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWpdes() {
		return wpdes;
	}

	public void setWpdes(String wpdes) {
		this.wpdes = wpdes;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getLxr() {
		return lxr;
	}

	public void setLxr(String lxr) {
		this.lxr = lxr;
	}

	public String getLxtel() {
		return lxtel;
	}

	public void setLxtel(String lxtel) {
		this.lxtel = lxtel;
	}

	public String getLxaddress() {
		return lxaddress;
	}

	public void setLxaddress(String lxaddress) {
		this.lxaddress = lxaddress;
	}

	public String getLxqq() {
		return lxqq;
	}

	public void setLxqq(String lxqq) {
		this.lxqq = lxqq;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

	public String getInfotype() {
		return infotype;
	}

	public void setInfotype(String infotype) {
		this.infotype = infotype;
	}

	public String getWptype() {
		return wptype;
	}

	public void setWptype(String wptype) {
		this.wptype = wptype;
	}

}
