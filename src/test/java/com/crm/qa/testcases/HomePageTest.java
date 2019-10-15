package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest  extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;

	public HomePageTest() throws IOException {
		super();
	}
	
	
	//test cases should be separated -- independent with each other.
	//before each test cases --- launch the browser and login
	//@Test -- execute test case
	//after each test case -- close the browser
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomepageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactLinkTest() throws IOException{
		testUtil.switchToFrame();
		contactPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
