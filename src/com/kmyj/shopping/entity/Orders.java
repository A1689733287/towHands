package com.kmyj.shopping.entity;

//prosorders
public class Orders {
	private int id;// id
	private String uname; // 姓名
	private String touname; // 姓名
	private String ddinfo;// 购买信息
	private String lxr;// 联系人
	private String lxtel;// 联系手机
	private String lxqq;// 联系qq
	private String address;// 地址
	private String fkfs;// 付款方式
	private String status;// 物品状态
	private String savetime;// 保存时间

	public Orders() {
		super();
	}

	public Orders(String uname, String touname, String ddinfo, String lxr,
			String lxtel, String lxqq, String address, String fkfs,
			String status, String savetime) {
		super();
		this.uname = uname;
		this.touname = touname;
		this.ddinfo = ddinfo;
		this.lxr = lxr;
		this.lxtel = lxtel;
		this.lxqq = lxqq;
		this.address = address;
		this.fkfs = fkfs;
		this.status = status;
		this.savetime = savetime;
	}

	public Orders(int id, String uname, String touname, String ddinfo,
			String lxr, String lxtel, String lxqq, String address, String fkfs,
			String status, String savetime) {
		super();
		this.id = id;
		this.uname = uname;
		this.touname = touname;
		this.ddinfo = ddinfo;
		this.lxr = lxr;
		this.lxtel = lxtel;
		this.lxqq = lxqq;
		this.address = address;
		this.fkfs = fkfs;
		this.status = status;
		this.savetime = savetime;
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

	public String getTouname() {
		return touname;
	}

	public void setTouname(String touname) {
		this.touname = touname;
	}

	public String getDdinfo() {
		return ddinfo;
	}

	public void setDdinfo(String ddinfo) {
		this.ddinfo = ddinfo;
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

	public String getLxqq() {
		return lxqq;
	}

	public void setLxqq(String lxqq) {
		this.lxqq = lxqq;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFkfs() {
		return fkfs;
	}

	public void setFkfs(String fkfs) {
		this.fkfs = fkfs;
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

}
