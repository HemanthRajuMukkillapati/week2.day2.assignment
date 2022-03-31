package week2.day2.assignment;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTest {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "./driverFolder/chromeDriver.exe");
		ChromeDriver driver =new ChromeDriver(); 
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); //implicit wait
		driver.findElement(By.xpath("//div[@class='_6ltg']//a")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("firstname");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("testleaflast");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("testleaf_hetty@gmail.com");
		//reg_email_confirmation__
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys("testleaf_hetty@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("testleaf_hetty@gmail.com");
		WebElement dayDD = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		WebElement monthDD = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		WebElement yearDD = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		
		
		Select dayDDObj =new Select(dayDD); 
		Select monthDDObj =new Select(monthDD); 
		Select yearDDObj =new Select(yearDD); 
		
		dayDDObj.selectByValue("1");
		monthDDObj.selectByVisibleText("Aug");
		yearDDObj.selectByValue("1991");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

		
		
	}

}
