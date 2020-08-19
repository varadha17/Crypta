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
	
	@FindBy(xpath="(//span[@id='desc'])[2]")
	WebElement clickLink;
	
	@FindBy(xpath="(//span[@id='desc'])[3]")
	WebElement clickLink1;
	
	@FindBy(xpath="(//span[@id='desc'])[4]")
	WebElement clickLink2;
	
	@FindBy(xpath="(//span[@id='desc'])[5]")
	WebElement clickLink3;
	
	@FindBy(xpath="(//span[@id='desc'])[6]")
	WebElement clickLink4;
	
	@FindBy(xpath="(//span[@id='desc'])[7]")
	WebElement clickLink5;
	
	@FindBy(xpath="(//span[@id='desc'])[8]")
	WebElement clickLink6;
	
	@FindBy(xpath="(//span[@id='desc'])[9]")
	WebElement clickLink7;
	
	excel ex = new excel("./src/main/java/com/Excelsheets/cryptaSearch.xlsx");
	
	public void cryptasignIn() throws InterruptedException, IOException {
			signIn.click();
			email.sendKeys(prop.getProperty("username"));
			password.sendKeys(prop.getProperty("password"));
			loginBtn.click();
			
			ex.setcellData(1, 0, clickLink.getText(), "search");
			ex.setcellData(2, 0, clickLink1.getText(), "search");
			
			Thread.sleep(6000);
	}
	

}
