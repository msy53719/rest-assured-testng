package com.mosy.core.util;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mosy.core.constant.DBConstant;
import com.mysql.cj.jdbc.MysqlDataSource;

public class DbConnectionUtil {
	private static Logger logger = LoggerFactory.getLogger(DbConnectionUtil.class);

	private static Connection connection;

	public static DataSource getDataSource() {
		MysqlDataSource datasource = new MysqlDataSource();
		datasource.setDatabaseName(DBConstant.DB_NAME);
		datasource.setPort(DBConstant.JDBC_PORT);
		datasource.setPassword(DBConstant.JDBC_PWD);
		datasource.setUser(DBConstant.JDBC_USER);

		return datasource;
	}

	public static synchronized Connection getConnection() {

		if (connection == null) {
			try {
				connection = getDataSource().getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
				logger.error("conact to db error", e);
			}
		}
		return connection;

	}
}
