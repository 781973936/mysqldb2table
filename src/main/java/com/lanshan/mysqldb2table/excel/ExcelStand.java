package com.lanshan.mysqldb2table.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * excel标准操作
 * 
 * @author liyuchen
 */
public interface ExcelStand {
	/**
	 * 生成excel文件
	 * 
	 * @param wb
	 */
	public default void createFile() {
		try {
			// String createPath = "X:\\Users\\liyuchen\\Desktop\\test.xls";
			File file = new File(getPath());
			if(!file.exists()) {
				file.createNewFile();
			}
			OutputStream os = new FileOutputStream(file);
			getWorkbook().write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	};
	
	/**
	 * 获取excel工作簿
	 * @return
	 */
	public HSSFWorkbook getWorkbook();
	/**
	 * 文件路径
	 * @return
	 */
	public String getPath();
}
