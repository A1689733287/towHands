package com.kmyj.shopping.entity;

/**
 * 新闻hbnews
 * 
 * @author G
 * 
 */
public class News {
	private int id; // 新闻id
	private String title; // 新闻标题
	private String author; // 新闻作者
	private String filename; // 文件名称
	private String content; // 新闻内容
	private String savetime; // 新闻发布时间

	public News() {
		super();
	}

	public News(String title, String author, String filename, String content,
			String savetime) {
		super();
		this.title = title;
		this.author = author;
		this.filename = filename;
		this.content = content;
		this.savetime = savetime;
	}

	public News(int id, String title, String author, String filename,
			String content, String savetime) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.filename = filename;
		this.content = content;
		this.savetime = savetime;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSavetime() {
		return savetime;
	}

	public void setSavetime(String savetime) {
		this.savetime = savetime;
	}

}
