/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-24 下午10:06:48
 * 
 */
package com.code.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.code.dao.DBHandler;
import com.code.entity.ColumnMeta;
import com.code.entity.TableMeta;

/**
 * TODO
 * 
 */
public class MySqlDBHandler implements DBHandler {

	@Override
	public TableMeta getTableMeta(Connection conn, String tableName) throws SQLException {
		TableMeta tableMeta = new TableMeta();
		tableMeta.setTableName(tableName);
		Statement state = conn.createStatement();
		ResultSet rs = state.executeQuery(String.format("select * from %s limit 1", tableName));
		ResultSetMetaData rsMetaData = rs.getMetaData();
		int columnCount = rsMetaData.getColumnCount();
		ColumnMeta columnMeta = null;
		for (int i = 1; i <= columnCount; ++i) {
			columnMeta = new ColumnMeta();
			columnMeta.setFieldComment(rsMetaData.getColumnName(i));
			columnMeta.setFieldName(rsMetaData.getColumnName(i));
			columnMeta.setFieldType(rsMetaData.getColumnTypeName(i));
			columnMeta.setNullAble(rsMetaData.isNullable(i) == 1 ? true : false);
			tableMeta.addColumnMeta(columnMeta);
		}
		rs.close();
		state.close();
		return tableMeta;
	}

}
