package com.cognizant.todos.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cognizant.todos.utilities.ElementUtil;

public class HomePage {

	@FindBy(id = "todo-input")
	WebElement toDoTextBox;

	WebDriver driver;

	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void addTodo(String item) {
		toDoTextBox.sendKeys(item);
		toDoTextBox.sendKeys(Keys.ENTER);
		ElementUtil.wait(2);
	}

	public void markItemAsCompleted(String item) {
	
		WebElement itemElement = driver.findElement(By.xpath("//*[text()='" + 
		                         item + "']/parent::div/input[@data-testid='todo-item-toggle']"));	
		itemElement.click();
		ElementUtil.wait(1);
	}

	public boolean isItemMarkedCompleted(String item) {
		boolean isCompleted = false;
		List<WebElement> elementList = driver.findElements(By.xpath("//*[@class='completed']//label"));
	    if(elementList != null && elementList.size() >0)
	    {
	    	for(WebElement element : elementList) {
	    		if (element.getText().equals(item)) {
	    			isCompleted = true;
	    		}
	    	}
	    }
		return isCompleted;
	}
	
	public boolean isItemDisplayed(String item) {
		try {
			WebElement element = driver.findElement(By.xpath("//*[text()='" + 
                    item + "']"));
			return element.isDisplayed();
		}catch (NoSuchElementException e) {
			return false ;
		}
		
		
	}

}
