package com.lanshan.mysqldb2table;

import com.lanshan.mysqldb2table.excel.ExcelStand;
import com.lanshan.mysqldb2table.excel.TotalTableInfo;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		ExcelStand excel = new TotalTableInfo();
		excel.createFile();
		
		System.out.println("生成完毕！");
	}

}
