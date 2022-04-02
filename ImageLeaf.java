package week2.day2.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageLeaf {
	
	public static void main(String args[]) {
		// TODO Auto-generated method stub
	

		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver =new ChromeDriver(); 	
		
		driver.get("http://leafground.com");
		
		driver.findElement(By.xpath("//h5[contains(text(),'Image')]")).click();
		driver.findElement(By.xpath("//label[@for='home']/following-sibling::img")).click();
		String titleOfHomePage = driver.getTitle();	
		if(titleOfHomePage.contains("Selenium Playground")) {
			System.out.println("Landed on the correct page : "+titleOfHomePage);
			driver.navigate().back();
			}
		
		else {
		System.out.println("Landed on the wrong page : "+titleOfHomePage);		
	}
	

}
}
