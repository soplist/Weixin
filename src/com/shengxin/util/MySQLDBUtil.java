package com.shengxin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLDBUtil {

	private static final String username = "root";
	private static final String password = "root";

	private static MySQLDBUtil mySQLDBUtil = null;

	private MySQLDBUtil() {

	}

	public static MySQLDBUtil getInstance() {
		if (mySQLDBUtil == null) {
			synchronized (MySQLDBUtil.class) {
				if (mySQLDBUtil == null) {
					mySQLDBUtil = new MySQLDBUtil();
				}
			}
		}
		return mySQLDBUtil;
	}

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection getConnection(String database) {
		Connection conn = null;

		try {

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + database + "?useUnicode=true&characterEncoding=utf-8", username, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeConnection(ResultSet rs, Statement statement, Connection con) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
