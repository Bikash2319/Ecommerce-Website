package com.ecommercepage;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(2000);
		
		int j =0;
		
		//		GET PRODUCT NAME
		String[] itemNeeded = {"Cucumber","Brocolli"};
		
		if(itemNeeded.length==0) {
			System.out.println("Please Enter Your Products to Cart"); 
		}
		else {
			
		
//		COLLECT ALL PRODUCTS IN A LIST
		List <WebElement> products =driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<=itemNeeded.length;i++) {
			String[] name = products.get(i).getText().split("-");
			
//			IF NAME CONTAINS SPACES THEN EXTRACT SPACES
			String formattedName = name[0].trim();
			
		
//			TO GET EXACT PROCUCT NAME
//			CONVERT ARRAY TO ARRAY LIST
//			CHECK WHETHER PRODUCT IS AVAILABLE OR NOT
			List<String> itemNeededList = Arrays.asList(itemNeeded);
			
			if(itemNeededList.contains(formattedName)) {
				
//				ADD MATCHED ITEMS TO CART
				driver.findElements(By.xpath("//div[@class=\"product-action\"]/button")).get(i).click();
				
				if(j==itemNeeded.length) {
					break;
				}
			}
	}

		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
		
		driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);
		
		
		driver.findElement(By.cssSelector("#root > div > div > div > div > div > select")).sendKeys("India");
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		}	

	}
	
	
	
}	
