package com.lanshan.mysqldb2table.excel;

import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;

import com.lanshan.mysqldb2table.db.Database;
import com.lanshan.mysqldb2table.db.Field;
import com.lanshan.mysqldb2table.db.Table;
import com.lanshan.mysqldb2table.poi.PoiGroup;
import com.lanshan.mysqldb2table.poi.PoiOperation;

public class TotalTableInfo implements ExcelStand {

	private PoiGroup poi = new PoiOperation();
	// 文件
	private String file = "X:\\Users\\liyuchen\\Desktop\\test.xls";

	@Override
	public HSSFWorkbook getWorkbook() {
		Database database = new Database();
		// 获取数据库的所有表格
		List<Table> tables = database.geTables();
		// 设置列宽
		poi.setColumnWidth(Arrays.asList(19, 18, 15, 12, 12, 12));

		List<HSSFCellStyle> styles = Arrays.asList(getStyle(), getStyle(),getStyle(),getStyle(),getStyle(),getStyle());
		List<HSSFCellStyle> tablestyles = Arrays.asList(getStyle2(), getStyle(),getStyle(),getStyle(),getStyle(),getStyle());
		List<HSSFCellStyle> headstyles = Arrays.asList(getStyle2(), getStyle2(),getStyle2(),getStyle2(),getStyle2(),getStyle2());

		for (Table table : tables) {
			poi.setMegre(1, 5);
			List<String> list = Arrays.asList("表    名", table.getName(),"","","","");
			poi.setCellValueAndStyle(list, tablestyles);
			
			poi.setMegre(1, 5);
			List<String> list2 = Arrays.asList("中文描述", table.getRemark(),"","","","");
			poi.setCellValueAndStyle(list2, tablestyles);

			List<String> head = Arrays.asList("列    名", "中文描述", "数据类型", "精度范围", "空/非空", "默认值");
			poi.setCellValueAndStyle(head, headstyles);

			List<Field> fields = table.getFields();
			for (Field field : fields) {
				List<String> fvalue = Arrays.asList(field.getName(), field.getRemark(), field.getType(),
						field.getRange(), field.getIsNull(), field.getDefaults());
				poi.setCellValueAndStyle(fvalue, styles);
			}
			poi.nextLine();
			poi.nextLine();
		}

		return poi.getWorkbook();
	}

	private HSSFCellStyle getStyle() {
		HSSFCellStyle style = poi.getWorkbook().createCellStyle();
		commonStyle(style);
		return style;
	}
	
	private HSSFCellStyle getStyle2() {
		HSSFCellStyle style = poi.getWorkbook().createCellStyle();
		commonStyle(style);
		style.setFillForegroundColor(HSSFColor.LIME.index);
		style.setFillPattern(CellStyle.SOLID_FOREGROUND);
		HSSFPalette palette = poi.getWorkbook().getCustomPalette();
		int cc = 232;
	    palette.setColorAtIndex(HSSFColor.LIME.index, (byte) cc, (byte) cc, (byte) cc);

		return style;
	}

	private void commonStyle(HSSFCellStyle style) {
		
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBottomBorderColor(HSSFColor.BLUE.index);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setLeftBorderColor(HSSFColor.BLUE.index);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setRightBorderColor(HSSFColor.BLUE.index);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setTopBorderColor(HSSFColor.BLUE.index);
		
		HSSFPalette palette = poi.getWorkbook().getCustomPalette();
		int cc = 120;
	    palette.setColorAtIndex(HSSFColor.BLUE.index, (byte) cc, (byte) cc, (byte) cc);
		
		style.setWrapText(true);  //关键
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		Font font = poi.getWorkbook().createFont();
        font.setFontName("宋体");
        font.setFontHeightInPoints((short) 9);
		style.setFont(font);
	}

	@Override
	public String getPath() {
		return file;
	}

}
