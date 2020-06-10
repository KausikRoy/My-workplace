package practiceActionClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MypracticeActionClass {
	
	@Test
	
public void myActionDemo() {
	
	System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.amazon.com/ref=nav_logo");
	driver.manage().window().maximize();
	Actions a = new Actions(driver);
	WebElement b = driver.findElement(By.xpath("//a[@id='nav-link-accountList']"));
	a.moveToElement(b).build().perform();
	a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
	WebElement prime = driver.findElement(By.id("nav-orders"));
	a.moveToElement(prime).doubleClick().build().perform();
	//driver.findElement(By.id("ap_email")).sendKeys("rkausik74@gmail.com");
	//driver.findElement(By.xpath("//input[@id='continue']")).click();
	
	
	
}
}
