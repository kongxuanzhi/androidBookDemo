package com.jdbc.dbutils;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils2 {

	private final static String USERNAME = "sa";
	private final static String PASSWORD = "xuanzhi";
	//private final static String URL = "jdbc:mysql://localhost:3306/jdbc";
	private final  static String URL = "jdbc:sqlserver://localhost:1433; DatabaseName=sqlserver";
	//private final static String DRIVER = "com.mysql.jdbc.Driver";
	private final static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private Connection connection;
	private PreparedStatement presmt;
	private ResultSet resultSet;
	public JdbcUtils2(){
		try {
			Class.forName(DRIVER);
			System.out.println("驱动注册成功");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection(){
		try {
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
			System.out.println("连接成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private PreparedStatement AddParames(String sql,List<Object> params) throws SQLException {
		presmt = connection.prepareStatement(sql);
		if(params != null && !params.isEmpty()){
			for (int i = 0; i < params.size(); i++) {
				presmt.setObject(i+1,params.get(i));
			}
		}
		return presmt;
	}

	public boolean updateByPreparedStatement(String sql,List<Object> params) throws SQLException {
		boolean flag = false;
		int result = -1;
		presmt = AddParames(sql,params);
		result = presmt.executeUpdate();
		flag = result >0?true:false;
		return flag;
	}

	public Map<String,Object> findSimpleResult(String sql, List<Object> params) throws SQLException {
		Map<String,Object> result = new HashMap<String, Object>();
		presmt = AddParames(sql, params);
		resultSet = presmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();//获得表结构，得到表信息，列数，列名等信息
		int col_len = metaData.getColumnCount();
		while (resultSet.next()){  //是一个表，有很多行
			for (int i = 0; i < col_len; i++) {   //一行
				String col_name = metaData.getColumnName(i+1);  //从1开始,获得第1列的列名
				Object col_value = resultSet.getObject(col_name);
				if(col_value == null){
					col_value = "";
				}
				result.put(col_name,col_value);
			}
		}
		return  result;
	}

	public List<Map<String,Object>>  findMoreResult(String sql,List<Object> params) throws SQLException {
		List<Map<String,Object>> result = new ArrayList<Map<String, Object>>();
		presmt = AddParames(sql, params);
		resultSet = presmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while(resultSet.next()){
			Map<String,Object> row = new HashMap<String, Object>();
			for (int i = 0; i <col_len; i++) {
				String col_name = metaData.getColumnName(i+1);
				Object col_value = resultSet.getObject(col_name);
				if(col_value == null){
					col_value = "";
				}
				row.put(col_name,col_value);
			}
			result.add(row);
		}
		return result;
	}

	public <T> T findSimpleRefResult(String sql,List<Object> params,Class<T> cls)
			throws Exception {
		T model = null;

		presmt = AddParames(sql,params);
		resultSet = presmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()){
			model = cls.newInstance();
			for (int i = 0; i < col_len; i++) {
				String col_name = metaData.getColumnName(i + 1);
				Object col_value = resultSet.getObject(col_name);
				col_value = col_value == null ? "" : col_value;

				Field col = cls.getDeclaredField(col_name);
				col.setAccessible(true);
				col.set(model, col_value);
			}
		}
		return model;
	}

	public <T> List<T> findMoreRefResult(String sql,List<Object> params,Class<T> cls)
			throws Exception {
		List<T> result = new ArrayList<T>();
		presmt = AddParames(sql,params);

		resultSet = presmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();
		while (resultSet.next()){
			T model = cls.newInstance();
			for (int i = 0; i <col_len; i++) {
				String col_name = metaData.getColumnName(i+1);
				Object col_value = resultSet.getObject(col_name);
				col_value = col_value == null?"":col_value;

				Field field = cls.getDeclaredField(col_name);
				field.setAccessible(true);
				field.set(model,col_value);
			}
			result.add(model);
		}
		return result;
	}

	public void releaseConn(){
		if(resultSet != null){
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(presmt != null){
			try {
				presmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}

