package nrk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class login {

	public static void main(String args[]) 
	 {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
       WebDriver driver=new ChromeDriver();
		
		driver.get("http://orangehrm.qedgetech.com/symfony/web/index.php/auth/login");
	driver.manage().window().maximize();
	
	driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Qedge123!@#");
	driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("Qedge123!@#");
	driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	
	
	
	driver.close();
	
	
	
	
	}
	}

