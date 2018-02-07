package com.kmyj.shopping.util;

import java.sql.*;

/*
 * 数据库交互层
 */
public class DBoperation {
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=twoHands";
	private String userName = "sa";
	private String userPwd = "123456";
	private Connection con = null;
	private Statement stmt = null;

	public DBoperation() {
		init();
	}

	// 初始化链接
	public void init() {
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userName, userPwd);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新数据
	 * 
	 * @param sql
	 *            查询语句
	 * @return 返回true和false
	 */
	public boolean executeUpdate(String sql) {
		if (con == null) {
			init();
		}
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	/**
	 * 查询链接
	 * 
	 * @param sql
	 *            sql语句
	 * @return rs级
	 */
	public ResultSet executeQuery(String sql) {
		ResultSet rs = null;
		try {
			if (con == null) {
				init();
			}
			stmt = con.createStatement(rs.TYPE_SCROLL_SENSITIVE,
					rs.CONCUR_READ_ONLY);
			try {
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
		return rs;
	}
}
