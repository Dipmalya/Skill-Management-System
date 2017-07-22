package com.smsapp;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class helloTest {
	public ArrayList<String> readData(int colNo) throws IOException, NoClassDefFoundError, ClassNotFoundException 
	{

		FileInputStream fis = new FileInputStream("C:\\Users\\Dipmalya Sen\\Desktop\\Test Data\\login.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("SMSLOGIN");
		Iterator<Row> rowIt = s.iterator();
		rowIt.next();
		ArrayList<String> list = new ArrayList<String>();
		while(rowIt.hasNext())
		{
				list.add(rowIt.next().getCell(colNo).getStringCellValue());	
		}
		wb.close();
		return list;
	}
	@Test
	public void checktest() throws IOException, NoClassDefFoundError, ClassNotFoundException{
		helloTest ht = new helloTest();
		hello h = new hello();
		ArrayList<String> username = ht.readData(0);
		ArrayList<String> password = ht.readData(1);
		for(int count =0;count<username.size();count++)
		{
			boolean result = h.check(username.get(count), password.get(count));
			assertEquals(true,result);
		}
	}
}
