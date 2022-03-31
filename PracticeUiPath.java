package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeUiPath {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().window().maximize();		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]")).click();
		String title = driver.getTitle();
		System.out.println("The Title of the page is : " +title );
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		Thread.sleep(3000);
		driver.quit();
		
		
	}

}
