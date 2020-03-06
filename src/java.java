

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Document;

public class java {

	public static void main(String[] args) throws Throwable  {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location = 'https://amazon.com'" );
		driver.manage().window().maximize();
		Thread.sleep(4000);

		//scroll from to top to bottom

		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(4000);

		//scroll from to bottom to top

		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(4000);

		//scroll to certain pixxel
		
		js.executeScript("window.scrollBy(0,3000)");
		Thread.sleep(4000);
		
		//scroll to particular elements in webpage
		
		WebElement Signinbutton = driver.findElement(By.xpath("//a[contains(text(),'Sign in to see personalized recommendations')]"));
		
		//click on button
		
		Signinbutton.click();
		

	}

}
