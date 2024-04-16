package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	/**
	 * This method is used to read data from excel file
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String sheetname,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
{
FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
Workbook wk=WorkbookFactory.create(fiss);
Sheet sh=wk.getSheet(sheetname);
String value=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
return value;
}
/**
 * This method is used to get the total number of row present in excel
 * Author avanish kumar dubey
 * @param sheetname
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getTotalRowCount(String sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wk=WorkbookFactory.create(fiss);
	Sheet sh=wk.getSheet(sheetname);
	int rowCount=sh.getLastRowNum();
	return rowCount;
}
/**
 * This method is used to write the data into excel
 * @author avanish kumar dubey
 * @param sheetName
 * @param rowno
 * @param cellno
 * @param data
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataintoExcel(String sheetName,int rowno,int cellno,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wk=WorkbookFactory.create(fiss);
	Sheet sh=wk.getSheet(sheetName);
	sh.createRow(rowno).createCell(cellno).setCellValue(data);
	FileOutputStream fout=new FileOutputStream(IPathConstant.ExcelPath);
	wk.write(fout);
	wk.close();
}
/**
 * This method is used to get the total number of cell present in excel
 * @author avanish kumar dubey
 * @param sheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public int getTotalCellCount(String sheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wk=WorkbookFactory.create(fiss);
	Sheet sh=wk.getSheet(sheetName);
	int cellCount=sh.getRow(0).getLastCellNum();
	return cellCount;			
  }
/**
 * This method is used to read multiple data from excel file
 * @author avanish kumar dubey
 * @param sheetName
 * @throws EncryptedDocumentException
 * @throws IOException
 */
//public void readAllTheDatafromexcelfile(String sheetName) throws EncryptedDocumentException, IOException
//{
//	FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
//	Workbook wk=WorkbookFactory.create(fiss);
//	Sheet sh=wk.getSheet(sheetName);
//	int rowCount=sh.getLastRowNum();
//	int cellCount=sh.getRow(0).getLastCellNum();
//	for(int i=0;i<=rowCount;i++)
//	{
//		for(int j=0;j<cellCount;j++)
//		{
//			String value=sh.getRow(i).getCell(j).getStringCellValue();
//			System.out.print(value+" ");
//		}
//		System.out.println(" ");
//	}
//}
public HashMap<String, String> readMultipleData(String sheetname,int cellno) throws EncryptedDocumentException, IOException
{
	FileInputStream fiss=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wk=WorkbookFactory.create(fiss);
	Sheet sh=wk.getSheet(sheetname);
	int rowount=sh.getLastRowNum();
	HashMap<String, String> map=new HashMap<String, String>();
	for(int i=0;i<=rowount;i++)
	{
		String key=sh.getRow(i).getCell(cellno).getStringCellValue();
		String value=sh.getRow(i).getCell(cellno+1).getStringCellValue();
		map.put(key, value);
		
	}
	return map;
}
}