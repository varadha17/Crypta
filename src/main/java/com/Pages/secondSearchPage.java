package com.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Base.BaseTest;
import com.utilities.excel;

public class secondSearchPage extends BaseTest {

	public secondSearchPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="a[class='cd-main-nav__item cd-main-nav__item--signin']")
	WebElement signIn;
	
	@FindBy(id="signin-email")
	WebElement email;
	
	@FindBy(id="signin-password")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginBtn;
	
	@FindBy(xpath="//div[@class='cata_d products']/following::span[@id='desc']")
	List<WebElement> overall;
	
	excel ex = new excel("./src/main/java/com/Excelsheets/cryptaSearch.xlsx");
	
	String beforeXpath = "(//span[@id='desc'])[";
	String AfterXpath = "]";
	
	public void cryptasignIn() throws InterruptedException, IOException {
			signIn.click();
			email.sendKeys(prop.getProperty("username"));
			password.sendKeys(prop.getProperty("password"));
			loginBtn.click();
			//System.out.println("Overall datas:: "+overall.size());
			int data = overall.size()-90;
			ex.removeColumn("search", 0);
			ex.addColumn("search", "Search");
			for(int i=2; i<=data;i++) {
				String actualXpath = beforeXpath+i+AfterXpath;
				String actual = driver.findElement(By.xpath(actualXpath)).getText();
				ex.setCellData("search", "Search", i, actual);
				//System.out.println(actual);
				Thread.sleep(2000);
			}
			
	
	}
	

}
