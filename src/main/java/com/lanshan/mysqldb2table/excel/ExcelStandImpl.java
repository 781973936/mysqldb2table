package com.lanshan.mysqldb2table.excel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelStandImpl implements ExcenStand{

	@Override
	public void createFile(HSSFWorkbook wb) {
		try {
			File file = new File("X:\\Users\\liyuchen\\Desktop\\test.xls");
			file.createNewFile();
			OutputStream os = new FileOutputStream(file);
			wb.write(os);
			os.flush();
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
