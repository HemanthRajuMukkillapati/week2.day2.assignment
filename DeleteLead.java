package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./driverFolder/chromeDriver.exe");
		ChromeDriver driver =new ChromeDriver(); 	
		
		//Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();		
		
		
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");	
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
		WebElement findLeadLink = driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]"));
		findLeadLink.click();
		driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).clear();
		driver.findElement(By.xpath("//input[@name='phoneCountryCode']")).clear();
		WebElement findBtn = driver.findElement(By.xpath("//button[contains(text(),'Find')]"));
		findBtn.click();
		Thread.sleep(5000);
		String firstleadID = driver.findElement(By.xpath("//div[contains(@class,'x-grid3-cell-inner')]/a")).getText();
		System.out.println("The First Lead ID is : " + firstleadID );
		driver.findElement(By.xpath("//table//div[contains(@class,'Id')]/a[contains(@href,'viewLead')]")).click();
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		Thread.sleep(5000);  //giving this to avoid stale elment exception
		driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(firstleadID);
		driver.findElement(By.xpath("//button[contains(text(),'Find')]")).click();
		Thread.sleep(2000);
		String noRecord = driver.findElement(By.xpath("//div[text()='No records to display']")).getText();
		System.out.println(noRecord);
		if (noRecord.equals("No records to display")) {
			System.out.println("Test is passed");
			
		}
		else {
			System.out.println("Test is failed");
		}
		driver.quit();
	}
}
 
	
	
	
	/*http://leaftaps.com/opentaps/control/main
	 
	Delete Lead:
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Phone   --//span[contains(text(),'Phone')]
	9	Enter phone number    //input[@name='phoneNumber']  -123456789
	10	Click find leads button    //button[contains(text(),'Find')]
	11	Capture lead ID of First Resulting lead----//div[contains(@class,'x-grid3-cell-inner')]/a
	12	Click First Resulting lead
	13	Click Delete
	14	Click Find leads
	15	Enter captured lead ID
	16	Click find leads button
	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	18	Close the browser (Do not log out)
*/
