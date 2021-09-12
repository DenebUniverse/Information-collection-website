package cn.edu.uibe.myClass;

public class MyTable<T> {
	public String tableName;
	public int colLen;
	public int rowLen;
	public String[] colNames;
	public String[] rowNames;
	public T[][] matrix;
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getColLen() {
		return colLen;
	}
	public void setColLen(int colLen) {
		this.colLen = colLen;
	}
	public int getRowLen() {
		return rowLen;
	}
	public void setRowLen(int rowLen) {
		this.rowLen = rowLen;
	}
	public String[] getColNames() {
		return colNames;
	}
	public void setColNames(String[] colNames) {
		this.colNames = colNames;
	}
	public String[] getRowNames() {
		return rowNames;
	}
	public void setRowNames(String[] rowNames) {
		this.rowNames = rowNames;
	}
	public T[][] getMatrix() {
		return matrix;
	}
	public void setMatrix(T[][] matrix) {
		this.matrix = matrix;
	}
	

}
