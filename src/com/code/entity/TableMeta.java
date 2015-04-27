package com.code.entity;

import java.util.ArrayList;

public class TableMeta {

	private String tableName;
	private String primaryKey;
	private ArrayList<ColumnMeta> columns = new ArrayList<ColumnMeta>();

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public ArrayList<ColumnMeta> getColumns() {
		return columns;
	}

	public void setColumns(ArrayList<ColumnMeta> columns) {
		this.columns = columns;
	}

	public void addColumnMeta(ColumnMeta columnMeta) {
		this.columns.add(columnMeta);
	}
}
