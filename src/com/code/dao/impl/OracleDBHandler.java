/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-25 上午9:05:28
 * 
 */
package com.code.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;

import com.code.dao.DBHandler;
import com.code.entity.TableMeta;

/**
 * TODO
 * 
 */
public class OracleDBHandler implements DBHandler {

	@Override
	public TableMeta getTableMeta(Connection conn, String tableName) throws SQLException {
		return null;
	}

}
