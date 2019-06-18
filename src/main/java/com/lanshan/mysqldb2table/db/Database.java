package com.lanshan.mysqldb2table.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Database {

	private static final String jdbc_url = "jdbc:mysql://localhost:3306/central_china_adult_edu_db?serverTimezone=GMT%2B8&useSSL=false"; 
	
	private static final String username = "root";
	
	private static final String password = "123456";
	
	// 打开数据库连接
	private static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbc_url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	// 关闭数据库连接
	private static void closeConnection(ResultSet rs, Connection conn, PreparedStatement ps) {
		if (conn != null) {
			try {
				if (rs != null)
					rs.close();
				if (conn != null)
					conn.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 获取表名和注释
	public List<Table> geTables() {
		Connection conn = getConnection();
		ResultSet rs = null;
		List<Table> tables = new ArrayList<Table>();
		try {
			// 获取数据库的元数据
			DatabaseMetaData db = conn.getMetaData();
			// 从元数据中获取到所有的表名
			rs = db.getTables(null, null, null, new String[] { "TABLE" });

			while (rs.next()) {
				String name = rs.getString(3);
				String remark = rs.getString(5);
				Table table = new Table(name, remark);
				table.setFields(getTableFields(name));
				tables.add(table);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(rs, conn, null);
		}
		return tables;
	}

	/**
	 * 获取表中所有字段名称
	 * 
	 * @param tableName 表名
	 * @return
	 */
	public static List<Field> getTableFields(String tableName) {
		List<Field> columnNames = new ArrayList<>();
		// 与数据库的连接
		Connection conn = getConnection();
		PreparedStatement pStemt = null;
		String tableSql = "SELECT * FROM " + tableName;
		 ResultSet rs = null;
		try {
			pStemt = conn.prepareStatement(tableSql);
			rs = pStemt.executeQuery("show full columns from " + tableName);
			
			// 结果集元数据
			ResultSetMetaData rsmd = pStemt.getMetaData();
			// 表列数
			int size = rsmd.getColumnCount();
			for (int i = 0; i < size; i++) {
				Integer column = i+1;
				String comment = null;
				String defaults = null;
				if(rs.next()) {
					comment = rs.getString("Comment");
	            	defaults = rs.getString("Default");
				}
				String name = rsmd.getColumnName(column);
				String type = rsmd.getColumnTypeName(column).toLowerCase();
				String length = String.valueOf(rsmd.getPrecision(column)); // 长度
				String nullable = rsmd.isNullable(column) == 0?"否":"是";
				String auto = rsmd.isAutoIncrement(column)?"自动递增":"";
				Field filed = new Field(name, comment, type, length, defaults, nullable, auto);
				columnNames.add(filed);
			}
		} catch (SQLException e) {
		} finally {
			closeConnection(rs,conn,pStemt);
		}
		return columnNames;
	}
}
