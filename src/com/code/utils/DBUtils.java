package com.code.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.code.entity.DBMeta;

public class DBUtils {

	private static Connection conn;

	public static Connection getInstance(DBMeta db) {
		if (conn == null) {
			createConnection(db);
		}
		return conn;
	}

	private static Connection createConnection(DBMeta db) {
		try {
			Class.forName(db.getClassName());
			conn = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void release() {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			try {
				conn.close();
			} catch (SQLException e1) {

			}
		} finally {
			conn = null;
		}
	}
	
	

}
