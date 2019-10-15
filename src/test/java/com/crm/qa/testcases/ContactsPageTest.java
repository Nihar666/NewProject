package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactPage;
	
	String sheetName = "contacts";

	public ContactsPageTest() throws IOException {
		super();	
	}
	
	@BeforeMethod
	public void setUp() throws Exception{
		initialization();
		
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
		Thread.sleep(4000);
		//testUtil.switchToFrame();
		driver.switchTo().frame("mainpanel");
		//Thread.sleep(4000);
		contactPage = homePage.clickOnContactsLink();
		//Thread.sleep(5000);
		
	}
	
	
	@Test(priority =1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestdata() throws Exception{
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getCRMTestdata")
	public void validateCreateNewContact(String title, String firstname,String lastname,String company ){
		homePage.clickOnNewContactLink();
		//contactPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactPage.createNewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown(){
	driver.quit();
     }

}
