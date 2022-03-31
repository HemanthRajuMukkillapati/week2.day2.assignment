package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

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
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		Thread.sleep(2000);
		if(driver.getTitle().equals("Duplicate Lead | opentaps CRM")) {
			System.out.println("The Duplicate lead page is displayed");
			driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		}
		else {
			System.out.println("Duplicate lead page is not displayed");
		}
		if(driver.findElement(By.id("viewLead_firstName_sp")).getText().equals(firstNameLead)){
			
		
			System.out.println("The Lead is duplicated successfully and the first Name is: "+firstNameLead);
		}
			else {
				System.out.println("The Lead is not Duplicated");
			}
			driver.quit();
		
		//
		
		

	}


}



/*http://leaftaps.com/opentaps/control/main

1	Launch the browser
2	Enter the username
3	Enter the password
4	Click Login
5	Click crm/sfa link
6	Click Leads link
7	Click Find leads
8	Click on Email
9	Enter Email
10	Click find leads button
11	Capture name of First Resulting lead
12	Click First Resulting lead
13	Click Duplicate Lead
14	Verify the title as 'Duplicate Lead'
15	Click Create Lead
16	Confirm the duplicated lead name is same as captured name
17	Close the browser (Do not log out)

*/
