package com.smoothstack.avalanche.lmsspringboot.svc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	public final String driver = "com.mysql.cj.jdbc.Driver";
	public final String url = "jdbc:mysql://127.0.0.1:3306/lms?useSSL=false&allowPublicKeyRetrieval=true";
	public final String username = "root";
	public final String password = "password";

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		conn.setAutoCommit(Boolean.FALSE);

		return conn;
	}
}