package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.Pages.searchPage;

public class searchPageTest extends BaseTest{

	public searchPageTest() throws IOException {
		super();
	}
	
	public searchPage search;
	
	@BeforeMethod
	public void setup() throws IOException {
		startBrowser();
		
		search = new searchPage();
	}
	
	@Test
	public void setSearchTextTest() throws InterruptedException, IOException {
		search.setSearchText();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
