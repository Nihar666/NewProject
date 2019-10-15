package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory = OR
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name ="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	private WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	private WebElement crmLogo;
	
	
	//Initializing the page Objects
	public LoginPage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImg(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws IOException{
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.submit();
		
		return new HomePage();
		
	}
	

}
