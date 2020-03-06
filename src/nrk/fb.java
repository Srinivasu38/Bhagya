package nrk;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class fb {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
			
			driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		org.openqa.selenium.support.ui.Select day = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("day")));
            day.selectByValue("20");
            Thread.sleep(5000);
            org.openqa.selenium.support.ui.Select month = new org.openqa.selenium.support.ui.Select(driver.findElement(By.id("month")));
            month.selectByValue("5");
        
            
            WebElement checckbox= driver.findElement(By.xpath("//input[@id='u_0_6']"));
            checckbox.click();
        
        
}
}