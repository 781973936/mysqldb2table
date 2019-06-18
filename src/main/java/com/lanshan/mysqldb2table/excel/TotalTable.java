package com.lanshan.mysqldb2table.excel;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lanshan.mysqldb2table.db.Database;
import com.lanshan.mysqldb2table.db.Table;
import com.lanshan.mysqldb2table.poi.PoiGroup;
import com.lanshan.mysqldb2table.poi.PoiOperation;

public class TotalTable implements ExcelStand {

	private PoiGroup poi = new PoiOperation();
	// 文件
	private String file = "X:\\Users\\liyuchen\\Desktop\\test.xls";

	@Override
	public HSSFWorkbook getWorkbook() {
		Database database = new Database();
		// 获取数据库的所有表格
		List<Table> tables = database.geTables();
		// 设置列宽
		poi.setColumnWidth(Arrays.asList(27,30));
		
		List<String> value = Arrays.asList("表名", "中文描述");
		List<HSSFCellStyle> styles = Arrays.asList(getStyle(), getStyle());
		poi.setCellValueAndStyle(value, styles);
		
		for (Table table : tables) {
			List<String> list = Arrays.asList(table.getName(),table.getRemark());
			poi.setCellValueAndStyle(list, styles);
		}
		
		return poi.getWorkbook();
	}

	private HSSFCellStyle getStyle() {
		HSSFCellStyle style = poi.getWorkbook().createCellStyle();
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		return style;
	}

	@Override
	public String getPath() {
		return file;
	}

}
