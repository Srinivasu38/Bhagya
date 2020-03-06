package nrk;

import java.security.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class fb4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new ChromeDriver();
driver.get("https://www.facebook.com/");
driver.manage().window().maximize();
driver.findElement(By.xpath("//input[@id='email']")).sendKeys("srinivasu papolu");
driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("9014498142");
driver.findElement(By.id("u_0_b")).sendKeys(Keys.ENTER);
	}

}
