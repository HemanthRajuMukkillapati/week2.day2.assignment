package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonLeaf {
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
	

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		driver.get("http://leafground.com");
		
		driver.findElement(By.xpath("//h5[contains(text(),'Button')]")).click();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		String titleOfHomePage = driver.getTitle();	
		if(titleOfHomePage.contains("Selenium Playground")) {
			System.out.println("Landed on the correct page : "+titleOfHomePage);
			driver.navigate().back();
			}
		
		else {
		System.out.println("Landed on the wrong page : "+titleOfHomePage);		
	}
		System.out.println(driver.findElement(By.id("position")).getLocation().getX());
		System.out.println(driver.findElement(By.id("position")).getLocation().getY());
		System.out.println(driver.findElement(By.id("position")).getLocation());
		System.out.println(driver.findElement(By.id("color")).getCssValue("background-color"));
		System.out.println(driver.findElement(By.id("size")).getSize().height);
		System.out.println(driver.findElement(By.id("size")).getSize().width);
		System.out.println(driver.findElement(By.id("size")).getSize());
	
}}
