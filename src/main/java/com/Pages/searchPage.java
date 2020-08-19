package com.Pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseTest;

public class searchPage extends BaseTest {

	public searchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="text")
	WebElement search;
	
	
	public secondSearchPage setSearchText() throws InterruptedException, IOException {
		search.sendKeys("warehouse");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return new secondSearchPage();
	}
	

	
	

}
