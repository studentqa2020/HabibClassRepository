package com.test.Zoopla_Project;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseLogin {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "/Users/habib/Desktop/chromedriver");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		// habib
		driver.get("https://www.zoopla.co.uk/");
		driver.findElement(By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='button button--tertiary-dark account-link__text']")));
		
		WebElement signIn = driver.findElement(By.xpath("//a[@class='button button--tertiary-dark account-link__text']"));
		signIn.click();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("automation2sample@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("automation");
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement signInButton = driver.findElement(By.xpath("//button[@id='signin_submit']"));
		
		js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", signInButton);
		
		signInButton.click();
		//System.out.println(driver.getTitle());
		
		if(driver.getTitle().contains("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents")){
			System.out.println("Tittle of the Homepage after successfull login VARIFIED");
		}
		else {
			System.out.println("Please check your code :(");
		}
		
		
		
	}

}