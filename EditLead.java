package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	public static void main(String[] args) throws InterruptedException {
	
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("hemanthraju.m1991@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		Thread.sleep(5000);
		String firstNameLead = driver.findElement(By.xpath("//div[contains(@class,'firstName')]/a[contains(@href,'viewLead')]")).getText();
		System.out.println("The First Name of First Lead is : " + firstNameLead );
		driver.findElement(By.xpath("//div[contains(@class,'firstName')]/a[contains(@href,'viewLead')]")).click();
		//
		if(driver.getTitle().equals("View Lead | opentaps CRM")) {
			System.out.println("The View lead page is displayed");
			driver.findElement(By.xpath("//a[text()='Edit']")).click();
		}
		else {
			System.out.println("View Leads Page is not displayed");
		}
		
		WebElement companyName = driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']"));
		companyName.clear();
		String updatecmp="Update Company Name";
		companyName.sendKeys(updatecmp);
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		if(driver.getTitle().equals("View Lead | opentaps CRM")) {
			System.out.println("The View lead page is displayed");
			if(driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText().contains(updatecmp)) {
				System.out.println("The company Name is updated to " +updatecmp+" and Test is passed");
			}
			else {
				System.out.println("Test is failed and Company name is not updated");
			}
		}
		else {
			System.out.println("View Leads Page is not displayed");
		}
		driver.quit();
}
}