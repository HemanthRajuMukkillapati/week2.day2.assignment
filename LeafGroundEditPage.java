package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEditPage {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		driver.get("http://leafground.com");
		String titleOfHomePage = driver.getTitle();
		if(titleOfHomePage.contains("Selenium Playground")) {
			System.out.println("Landed on the correct page : "+titleOfHomePage);
			driver.findElement(By.xpath("//h5[contains(text(),'Edit')]")).click();
		}
		
		else {
		System.out.println("Landed on the wrong page : "+titleOfHomePage);
		}
		String email ="hetty@testleaf.com";
		driver.findElement(By.id("email")).sendKeys(email);         // enter email id
		String emailID = driver.findElement(By.id("email")).getAttribute("value"); //get entered value using getAttribute
		System.out.println(emailID);											   //print attribute value
		if(email.contains(emailID)) {   //why == is failing
			System.out.println("Test passed, Able to retrive the entred value");
			}
			else {
			System.out.println("Test failed, Not Able to retrive the entred value");
			}
		
		String existingValue = driver.findElement(By.xpath("//label[contains(text(),'Append a text and press')]/following-sibling::input")).getAttribute("value");
		
		driver.findElement(By.xpath("//label[contains(text(),'Append a text and press')]/following-sibling::input")).sendKeys("addedvalue");
		
		if(driver.findElement(By.xpath("//label[contains(text(),'Append a text and press')]/following-sibling::input")).getAttribute("value").equals(existingValue+"addedvalue" )) 
		{
			System.out.println("Value appened successfully");
			driver.findElement(By.xpath("//label[contains(text(),'Append a text and press')]/following-sibling::input")).sendKeys(Keys.TAB);
			WebElement elemnetfocusednow = driver.switchTo().activeElement();
			System.out.println("the focused element is " + elemnetfocusednow.getAttribute("value"));
		}
		else {
			System.out.println("new value is not appened");
		}
		driver.findElement(By.xpath("//input[@value='Clear me!!']")).clear();
		System.out.println(driver.findElement(By.xpath("//label[contains(text(),'field is disabled')]/following-sibling::input")).isEnabled());
		
		}
	}
	
	


