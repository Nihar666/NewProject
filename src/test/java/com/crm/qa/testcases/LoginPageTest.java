package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority =1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	}
	
	@Test(priority =2)
	public void crmLogoImageTest(){
		Boolean flag=loginPage.validateCRMImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority =3)
	public void loginTest() throws IOException{
		homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
