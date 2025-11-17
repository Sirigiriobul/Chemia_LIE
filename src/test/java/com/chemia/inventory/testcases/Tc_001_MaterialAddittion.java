package com.chemia.inventory.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.chemia.inventory.utilities.ExcelUtility;

public class Tc_001_MaterialAddittion {
	
	
	@Test
	public void method1() throws IOException {
		
		ExcelUtility excelUtil = new ExcelUtility("C://Automation//Chemia//Chemia 5.1//Chemia_Lie//testData//Automation-Sheet.xlsx");
		String mat = excelUtil.getCellData("Material", 0, 0);
		System.out.println(mat);
		
	}

}
