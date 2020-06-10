package childWindowHandle;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameHandeling {

	@Test
	public void frameSwitching() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("My Frame  :"+driver.findElement(By.tagName("frame")).getSize());
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("java.awt.color")).click();
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		waitforElement(driver, 40, By.linkText("ColorSpace"));
		driver.findElement(By.linkText("ColorSpace")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("classFrame");
		waitforElement(driver, 40, By.linkText("Serializable"));
		driver.findElement(By.linkText("Serializable")).click();
		waitforElement(driver, 40, By.xpath("//h2[@class='title']"));

		driver.findElement(By.xpath("//h2[@class='title']")).isDisplayed();
		System.out.println(driver.findElement(By.xpath("//h2[@class='title']")).getText());

		String ExpectedText = "Interface Serializable";
		driver.findElement(By.xpath("//h2[@class='title']")).getText();
		String ActualText = "Interface Serializable";
		Assert.assertEquals(ActualText, ExpectedText);
		driver.close();

	}

	private void waitforElement(WebDriver driver, int timeToWaitInSeconds, By ElementLocator) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSeconds);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ElementLocator));

	}

}
