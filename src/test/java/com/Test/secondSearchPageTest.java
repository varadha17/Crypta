package com.Test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Base.BaseTest;
import com.Pages.searchPage;
import com.Pages.secondSearchPage;

public class secondSearchPageTest extends BaseTest{

	public secondSearchPageTest() throws IOException {
		super();
	}
	
	public searchPage search;
	public secondSearchPage second;
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		
		startBrowser();
		search = new searchPage();
		second = search.setSearchText();
		
	}
	
	@Test
	public void cryptasignInTest() throws InterruptedException, IOException {
		
		second.cryptasignIn();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
