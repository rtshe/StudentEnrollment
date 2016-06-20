package com.shreetesh.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtil {
	private static Connection dbConnection ;

	public static Connection getConnection() {
		if (dbConnection != null) {
			return dbConnection;
		}
			
				InputStream inputStream = DbUtil.class.getClassLoader()
						.getResourceAsStream("db.properties");
				Properties properties = new Properties();
//				if (properties != null) {
				try {
				properties.load(inputStream);

					String dbDriver = properties.getProperty("dbDriver");
					String connectionUrl = properties
							.getProperty("connectionUrl");
					String userName = properties.getProperty("userName");
					String password = properties.getProperty("password");

					Class.forName(dbDriver);
					dbConnection = DriverManager.getConnection(connectionUrl,
							userName, password);
				
//			} catch (Exception e) {
//				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return dbConnection;
	}
	}

