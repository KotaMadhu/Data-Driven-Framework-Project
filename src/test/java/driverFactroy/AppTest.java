package driverFactroy;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import applicationLayer.CustomerPage;
import config.AppUtil;
import utilities.ExcelFileUtil;

public class AppTest extends AppUtil{

	String inputpath ="./FileInput/Customer.xlsx";	
	String outputpath ="./FileOutput/DataDrivenResults.xlsx";
	String sheet ="CustomerData";
	@Test
	public void startTest()throws Throwable
	{
		//create object for excel file utl class
		ExcelFileUtil xl = new ExcelFileUtil(inputpath);
		//count no of rows in customerdata sheet
		int rc =xl.rowCount(sheet);
		Reporter.log("No of rows are::"+rc,true);
		//iterate all rows in CustomerData sheet
		for(int i=1;i<=rc;i++)
		{
			String cname = xl.getCellData(sheet, i, 0);
			String Address = xl.getCellData(sheet, i, 1);
			String city = xl.getCellData(sheet, i, 2);
			String Country = xl.getCellData(sheet, i, 3);
			String cperson = xl.getCellData(sheet, i, 4);
			String pnumber = xl.getCellData(sheet, i, 5);
			String email = xl.getCellData(sheet, i, 6);
			String mnumber = xl.getCellData(sheet, i, 7);
			String notes = xl.getCellData(sheet, i, 8);

			//call customer page class
			CustomerPage cus =PageFactory.initElements(driver, CustomerPage.class);
			boolean res =cus.customer_Validate(cname, Address, city, Country, cperson, pnumber, email, mnumber, notes);
			//if res is true write as pass
			if(res) {
				xl.setCellData(sheet, i, 9, "pass", outputpath);
			}
			else
			{
				//if res is false write as Fail
				xl.setCellData(sheet, i, 9, "Fail", outputpath);
			}
		}
	}


}
