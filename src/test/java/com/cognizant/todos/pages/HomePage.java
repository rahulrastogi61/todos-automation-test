package com.cognizant.todos.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.locators.RelativeLocator;

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
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void markItemAsCompleted(String item) {
		//WebElement checkBox = driver
		//		.findElement(RelativeLocator.with(By.xpath("//input[@data-testid='todo-item-toggle']"))
		//				.toLeftOf(By.xpath("//*[text()='" + item + "']")));
		
		WebElement itemElement = driver.findElement(By.xpath("//*[text()='" + item + "']/parent::div/input[@data-testid='todo-item-toggle']"));
		
		
		itemElement.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public boolean isItemMarkedCompleted(String item) {
		boolean isCompleted = false;
		WebElement element = driver.findElement(By.xpath("//*[@class='completed']//label"));
		if (element.getText().equals(item)) {
			isCompleted = true;
		}
		return isCompleted;
	}

}
