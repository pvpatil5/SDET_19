package com.genericutil;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData_Excel {

	public String readDataExcel(String sheet,int row, int cell ) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("../SDET_19/src/test/resources/SDET_19.xlsx");

		String  value = WorkbookFactory.create(fis).getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();

		return value;
	}

	public int getlastrow() throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream("../SDET_19/src/test/resources/SDET_19.xlsx");
		int lastactivrrow=WorkbookFactory.create(fis).getSheet("Sheet2").getLastRowNum();
		return lastactivrrow;
	}

}
