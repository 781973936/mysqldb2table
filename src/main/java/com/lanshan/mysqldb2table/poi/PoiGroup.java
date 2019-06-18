package com.lanshan.mysqldb2table.poi;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface PoiGroup {
	
	public void setCellValueAndStyle(List<String> value, List<HSSFCellStyle> styles);
	
	public HSSFWorkbook getWorkbook();
	
	public void setColumnWidth(List<Integer> list);
	
	public void nextLine() ;
	
	public void setMegre(int x1,int x2);
}
