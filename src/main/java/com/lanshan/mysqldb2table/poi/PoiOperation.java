package com.lanshan.mysqldb2table.poi;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

public class PoiOperation implements PoiGroup {

	// 第一步，创建一个HSSFWorkbook，对应一个Excel文件
	private HSSFWorkbook wb = new HSSFWorkbook();
	// 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
	private HSSFSheet sheet = wb.createSheet();
	// 行数索引
	private Integer index = 0;

	public void setCellValueAndStyle(List<String> value, List<HSSFCellStyle> styles) {
		HSSFRow row = sheet.createRow(index);
		row.setHeightInPoints(20);
		for (int i = 0; i < value.size(); i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue(value.get(i));
			if (styles != null)
				cell.setCellStyle(styles.get(i));
		}
		nextLine();
	}

	public HSSFWorkbook getWorkbook() {
		return wb;
	}

	@Override
	public void setColumnWidth(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			sheet.setColumnWidth(i, list.get(i)*256);
		}
	}
	
	public void nextLine() {
		index = index + 1;
	}

	@Override
	public void setMegre(int x1, int x2) {
		CellRangeAddress region = new CellRangeAddress(index, index, x1, x2);
        sheet.addMergedRegion(region);
	}
}
