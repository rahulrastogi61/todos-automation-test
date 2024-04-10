package com.cognizant.todos.tests;

import static org.junit.Assert.assertFalse;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ToDosTests extends BaseTest{
		
	private static final String TOTAL_NUMBER_OF_TODOS_ARE_NOT_CORRECT = "total number of todos are not correct";
	private static final String XPATH_SPAN_CLASS_TODO_COUNT = "//span[@class='todo-count']";

	@Test
	public void testAddThreeItemsInTodos() {
		gotoHomePage();
		homePage.addTodo("Do breakfast");
		homePage.addTodo("Coding Datastructure");
		homePage.addTodo("Finish Assignment");
		String totalCountText= driver.findElement(By.xpath(XPATH_SPAN_CLASS_TODO_COUNT)).getText();
		assertEquals(totalCountText,"3 items left!",TOTAL_NUMBER_OF_TODOS_ARE_NOT_CORRECT);
	}
	
	@Test
	public void testAddTwoItemsInTodosAndCompleteOne() {
		gotoHomePage();
		homePage.addTodo("Do breakfast");
		homePage.addTodo("Coding Datastructure");
		String totalCountText= driver.findElement(By.xpath(XPATH_SPAN_CLASS_TODO_COUNT)).getText();
		assertEquals(totalCountText,"2 items left!",TOTAL_NUMBER_OF_TODOS_ARE_NOT_CORRECT);
		
		homePage.markItemAsCompleted("Do breakfast");
		assertTrue(homePage.isItemMarkedCompleted("Do breakfast"));
		
		String totalCountText1= driver.findElement(By.xpath(XPATH_SPAN_CLASS_TODO_COUNT)).getText();
		assertEquals(totalCountText1,"1 item left!",TOTAL_NUMBER_OF_TODOS_ARE_NOT_CORRECT);
	}
	
	@Test
	public void testAddTwoItemsInTodosAndCompleteOneThenClickClearCompleted() {
		testAddTwoItemsInTodosAndCompleteOne();
		driver.findElement(By.xpath("//button[text()='Clear completed']")).click();
		assertFalse("Item should not be visible", homePage.isItemDisplayed("Do breakfast"));
	}
	
	
	
	


	
	
	
	
	
	

}
