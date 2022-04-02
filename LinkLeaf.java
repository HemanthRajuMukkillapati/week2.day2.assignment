package week2.day2.assignment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkLeaf {
	public static void main(String args[]) {
		// TODO Auto-generated method stub
	

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		driver.get("http://leafground.com");
		
		driver.findElement(By.xpath("//h5[contains(text(),'HyperLink')]")).click();
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[1]")).click();
		String titleOfHomePage = driver.getTitle();	
		if(titleOfHomePage.contains("Selenium Playground")) {
			System.out.println("Landed on the correct page : "+titleOfHomePage);
			driver.navigate().back();
			}
		
		else {
		System.out.println("Landed on the wrong page : "+titleOfHomePage);		
	}
		System.out.println(driver.findElement(By.xpath("//a[contains(text(),'without clicking me?')]")).getAttribute("href"));
		driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).click();
		String brokenLink = driver.getTitle();
		if(brokenLink.equals("404 Not Found")) {
			System.out.println("The link is broken");
			driver.navigate().back();
			
		}
		else {
			System.out.println("The link is not broken");
		}
		System.out.println(driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]/following-sibling::label")).getText());
		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		String titleOfHomePage2 = driver.getTitle();	
		if(titleOfHomePage2.contains("Selenium Playground")) {
			System.out.println("Landed on the correct page : "+titleOfHomePage2);
			driver.navigate().back();
			}
		
		else {
		System.out.println("Landed on the wrong page : "+titleOfHomePage2);	
		}
		 driver.findElement(By.xpath("//a[contains(text(),'links are available in this page?')]")).click();
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total number of links in page are: " +links.size());
		
}}
