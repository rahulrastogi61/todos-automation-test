package com.cognizant.todos.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.cognizant.todos.pages.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public final String HOME_PAGE_URL = "https://todomvc.com/examples/react/dist/";
	public WebDriver driver ;
	public HomePage homePage;
	
	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homePage = PageFactory.initElements(driver, HomePage.class);
	}
	
	public void gotoHomePage() {
		driver.get(HOME_PAGE_URL);
	}
	
	
	@AfterMethod
	public void afterTest() {
		driver.quit();
	}
	
	

}
