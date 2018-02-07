package com.kmyj.shopping.entity;

//留言
public class Messages {
	private int id;// 留言id
	private String saver;
	private String savetime;
	private String content;
	private String resaver;
	private String recontent;
	private String resavetime;

	public Messages() {
		super();
	}

	public Messages(String saver, String savetime, String content,
			String resaver, String recontent, String resavetime) {
		super();
		this.saver = saver;
		this.savetime = savetime;
		this.content = content;
		this.resaver = resaver;
		this.recontent = recontent;
		this.resavetime = resavetime;
	}

	public Messages(int id, String saver, String savetime, String content,
			String resaver, String recontent, String resavetime) {
		super();
		this.id = id;
		this.saver = saver;
		this.savetime = savetime;
		this.content = content;
		this.resaver = resaver;
		this.recontent = recontent;
		this.resavetime = resavetime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSaver() {
		return saver;
	}

	public void setSaver(String saver) {
		this.saver = saver;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getResaver() {
		return resaver;
	}

	public void setResaver(String resaver) {
		this.resaver = resaver;
	}

	public String getRecontent() {
		return recontent;
	}

	public void setRecontent(String recontent) {
		this.recontent = recontent;
	}

	public String getResavetime() {
		return resavetime;
	}

	public void setResavetime(String resavetime) {
		this.resavetime = resavetime;
	}

}
