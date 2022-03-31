package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();		
		
		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("TestLeafFirst"); 
		driver.findElement(By.id("lastNameField")).sendKeys("TestLeaflast"); 
		driver.findElement(By.xpath("//input[@name='firstNameLocal']")).sendKeys("TestLeafFirstLocal"); 
		driver.findElement(By.xpath("//input[@name='lastNameLocal']")).sendKeys("TestLeafLastLocal"); 
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("Testdepartment");
		driver.findElement(By.xpath("//textarea[@id='createContactForm_description']")).sendKeys("TestDesc");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("testleafhetty@testleaf.com");
		WebElement stateprovdd = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		
		Select stPvDd = new Select(stateprovdd);
		
		stPvDd.selectByVisibleText("New York");
		
		
		driver.findElement(By.xpath("//input[@value='Create Contact']")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit'] ")).click();
		
		
		driver.findElement(By.xpath("//textarea[@id='updateContactForm_description']")).clear();
		driver.findElement(By.xpath("//input[@value='Update']")).click();

		String titleOfPage = driver.getTitle();
		
		System.out.println("the Title of the page is:  " + titleOfPage);
		

		
	}

}
