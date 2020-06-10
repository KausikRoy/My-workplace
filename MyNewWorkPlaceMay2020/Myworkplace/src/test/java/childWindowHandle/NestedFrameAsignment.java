package childWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class NestedFrameAsignment {
	
	@Test
	
	public void asigngment() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Nested Frames")).click();
		System.out.println("My Frame  :"+driver.findElement(By.tagName("frameset")).getSize());
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		waitforElement(driver, 40, By.xpath("//div[@id='content']"));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
		
		
		
		
		
	}
	private void waitforElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));

	}

}
