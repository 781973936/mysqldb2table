package com.lanshan.mysqldb2table.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ExcenStand {
	// 生成文件
	public void createFile(HSSFWorkbook wb);
}
