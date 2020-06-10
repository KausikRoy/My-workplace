package childWindowHandle;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MultipleWindowWithlimitScope {
	@Test

	public void limitWindowScope() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.tagName("a")).getSize());
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());
		WebElement coloumndriver = footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());
		// opening links in a different tab
		Thread.sleep(3000L);
		
		for (int i = 1; i < coloumndriver.findElements(By.tagName("a")).size(); i++) {
			
			String clickonlinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			
			Thread.sleep(5000L);
			Set<String> xyz = driver.getWindowHandles();
			Iterator<String> it = xyz.iterator();
			

			while (it.hasNext()) {

				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());

			}

		}

	}

}
