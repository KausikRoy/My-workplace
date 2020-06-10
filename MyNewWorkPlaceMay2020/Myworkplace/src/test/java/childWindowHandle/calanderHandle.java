package childWindowHandle;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class calanderHandle {
	@Test

	public void pickCurrentDate() {

		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();

		
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); Date today =
		 * Calendar.getInstance().getTime(); String date = dateFormat.format(today);
		 * System.out.println(date);
		 * driver.findElement(By.xpath("//input[@id='travel_date']")).sendKeys(date);
		 */
		while(!driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText().contains("May"))
		{
		driver.findElement(By.cssSelector("[class='datepicker-days'] th[class='next']")).click();
		}
		List<WebElement> dates= driver.findElements(By.className("day"));
		//Grab common attribute//Put into list and iterate
		int count=driver.findElements(By.className("day")).size();

		for(int i=0;i<count;i++)
		{
		String text=driver.findElements(By.className("day")).get(i).getText();
		if(text.equalsIgnoreCase("31"))
		{
		driver.findElements(By.className("day")).get(i).click();
		break;
		}
		 
	}

}
}
