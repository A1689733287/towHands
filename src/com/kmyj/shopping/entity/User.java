package com.kmyj.shopping.entity;


public class User {
	private int id; // 用户id
	private String username; // 用户名
	private String userpass; // 用户密码
	private String truename; // 真实姓名
	private String sex; // 性别
	private String qq; // QQ
	private String phoneno; // 手机号
	private String email; // 邮箱
	private String address; // 地址
	private String userType;// 用户类型
	private String filename; // 文件名称
	private String savetime; // 保存时间

	/*
	 * 用户类
	 */
	public User() {

	}

	public User(String username, String userpass, String truename, String sex,
			String qq, String phoneno, String email, String address,
			String userType, String filename, String savetime) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.truename = truename;
		this.sex = sex;
		this.qq = qq;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
		this.userType = userType;
		this.filename = filename;
		this.savetime = savetime;
	}

	/**
	 * 用户类
	 * 
	 * @param id
	 *            用户id
	 * @param username
	 *            用户名
	 * @param userpass
	 *            用户密码
	 * @param truename
	 *            用户真实姓名
	 * @param sex
	 *            性别
	 * @param qq
	 *            QQ号码
	 * @param phoneno
	 *            手机号码
	 * @param email
	 *            用户邮箱
	 * @param address
	 *            用户地址
	 * @param userType
	 *            用户类型
	 * @param filename
	 *            文件名称
	 * @param savetime
	 *            保存时间
	 */
	public User(int id, String username, String userpass, String truename,
			String sex, String qq, String phoneno, String email,
			String address, String userType, String filename, String savetime) {
		super();
		this.id = id;
		this.username = username;
		this.userpass = userpass;
		this.truename = truename;
		this.sex = sex;
		this.qq = qq;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
		this.userType = userType;
		this.filename = filename;
		this.savetime = savetime;
	}

	public User(String username, String userpass, String truename, String sex,
			String qq, String phoneno, String email, String address,
			String filename, String savetime) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.truename = truename;
		this.sex = sex;
		this.qq = qq;
		this.phoneno = phoneno;
		this.email = email;
		this.address = address;
		this.filename = filename;
		this.savetime = savetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getTruename() {
		return truename;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

}
