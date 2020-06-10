package childWindowHandle;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test

public class WindowHandeling {
	
	
	
	
	public void switchingWindow() throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.yahoo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.id("header-search-input")).sendKeys("xpath");
		driver.findElement(By.id("header-desktop-search-button")).click();
		driver.findElement(By.linkText("XPath Tutorial - W3Schools")).click();
		Thread.sleep(2000);
		System.out.println("Parent Window  :"+driver.getTitle());
		Set <String> ids = driver.getWindowHandles();
		Iterator <String> it = ids.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		System.out.println("Child window  :"+ driver.getTitle());
		driver.findElement(By.linkText("SQL")).click();
		driver.findElement(By.xpath("//input[@name='ex1']")).sendKeys("Select");
		driver.findElement(By.xpath("//button[contains(text(),'Submit Answer »')]")).click();
		driver.switchTo().window(childwindow);
		driver.close();
		driver.switchTo().window(parentwindow);
		System.out.println("Landed to parent window  :"+ driver.getTitle());
		driver.close();
		driver.quit();
		
		
		
		
		
		
	}

}
