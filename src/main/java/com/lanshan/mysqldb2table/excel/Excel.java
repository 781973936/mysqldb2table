package com.lanshan.mysqldb2table.excel;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Excel extends ExcelStandImpl implements ExcenStand{
	
	public  void createExcel() {
		// 获取数据
		List<String> list = Arrays.asList("", "");

		// excel标题
		String[] title = { "名称" };

		// excel文件名
		String fileName = "学生信息表" + System.currentTimeMillis() + ".xls";

		// sheet名
		String sheetName = "学生信息表";

		String[][] content = new String[2][1];
		for (int i = 0; i < list.size(); i++) {
			String string = list.get(i);
			content[i][0] = string;
		}

		// 创建HSSFWorkbook
		HSSFWorkbook wb = getHSSFWorkbook(sheetName, title, content, null);
		createFile(wb);
	}

	public static HSSFWorkbook getHSSFWorkbook(String sheetName, String[] title, String[][] values, HSSFWorkbook wb) {

		// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
		if (wb == null) {
			wb = new HSSFWorkbook();
		}

		// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet();

		// 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
		HSSFRow row = sheet.createRow(0);

		// 第四步，创建单元格，并设置值表头 设置表头居中
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式

		// 声明列对象
		HSSFCell createCell = row.createCell(1);
		createCell.setCellValue("test");

		return wb;
	}
}
