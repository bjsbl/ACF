/**
 * ACF
 * Create By baoliang.shen@pbin.net
 * 2015-3-24 下午10:04:22
 * 
 */
package com.code.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.code.entity.TableMeta;

/**
 * TODO
 * 
 */
public interface DBHandler {

	public TableMeta getTableMeta(Connection conn,String tableName) throws SQLException;
}
