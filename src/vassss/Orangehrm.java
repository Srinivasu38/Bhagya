package vassss;

import java.io.FileInputStream;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class Orangehrm {
	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	FileInputStream fi;
	FileOutputStream fo;
	Workbook wb;
	Sheet ws;
	Row row;
	Cell cell;
	String input="‪D:\\orangehrm.xlsx";
	String output="E://Result.xlsx";
	File screen;
	@BeforeTest
	public void setup()
	{
		reports=new ExtentReports("./Reports/Login.html");
		driver= new ChromeDriver();
	}
@Test
	public void vewrifylogin() throws Throwable
	{
		fi=new FileInputStream(input);
		wb=WorkbookFactory.create(fi);
		ws=wb.getSheet("Sheet1");
		row=ws.getRow(0);
		int rc=ws.getLastRowNum();
		int cc=row.getLastCellNum();
		Reporter.log("no of rows::"+rc+"no of cell:"+cc,true);
		for(int i=1;i<=rc;i++)
		{
			test=reports.startTest("verify login");
			test.assignAuthor("vasu");
			test.assignCategory("Data Driver");
			driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
			Thread.sleep(4000);
			
			String username=ws.getRow(i).getCell(0).getStringCellValue();
			String password=ws.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(password);
			driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
			Thread.sleep(4000);
			
			if (driver.getCurrentUrl().contains("dash"))
			{
				test.log(LogStatus.PASS, "login success");
				Reporter.log("login sucess",true);
				ws.getRow(i).createCell(2).setCellValue("login sucess");
				ws.getRow(i).createCell(3).setCellValue("pass");
			}
			else
			{
				String message=driver.findElement(By.id("spanMessage")).getText();
				Reporter.log(message,true);
				test.log(LogStatus.FAIL, message);
				ws.getRow(i).createCell(2).setCellValue(message);
				ws.getRow(i).createCell(3).setCellValue("fail");
			}
			reports.endTest(test);
			reports.flush();
		}
		fi.close();
		fo=new FileOutputStream(output);
		wb.write(fo);
		fo.close();
		wb.close();
	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
		
		
}