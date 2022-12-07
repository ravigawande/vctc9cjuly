package neoStoxTest;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import neoStoxBase.NeoStoxBaseClass;
import neoStoxUtility.NeoStoxUtilityClass;
import newStoxPomClasses.NeoStoxHomePage;
import newStoxPomClasses.NeoStoxLoginPage;
import newStoxPomClasses.NeoStoxPasswordPage;

public class NeoStoxTestClass extends NeoStoxBaseClass{
	
	NeoStoxLoginPage login;
	NeoStoxPasswordPage password;
	NeoStoxHomePage home;
	
	
	
	@BeforeClass
	public void launchNeoStox() throws IOException
	{
		launchBrowser();
		login=new NeoStoxLoginPage(driver);
		password=new NeoStoxPasswordPage(driver);
		home= new NeoStoxHomePage(driver);
		
		
	}
	
	@BeforeMethod
	public void loginToNeoStox() throws InterruptedException, IOException
	{
		login.enterMobileNumber(driver, NeoStoxUtilityClass.getDataFromPropertyFile("mobileNo"));
		login.clickONSignUpButton(driver);
		password.enterPassword(driver, NeoStoxUtilityClass.getDataFromPropertyFile("password"));
		password.clickOnSubmitButton(driver);
		home.popupHandling(driver);
		
		
		
	}
	
		
  @Test
  public void validatingUsername() throws IOException 
  {
	 NeoStoxUtilityClass.wait(driver, 1000);
	Assert.assertEquals( home.getActualUsername(driver), NeoStoxUtilityClass.getDataFromPropertyFile("expectedUsername")); 
	}
  
  @Test
  public void validatingFund()
  {
	  NeoStoxUtilityClass.wait(driver, 1000);
	 String funds = home.getActualFund(driver);
	 System.out.println("the actual fund is " +funds);
	  
  }
  
  @AfterMethod
  public void logoutAppNeoStox() throws InterruptedException
  {
	 NeoStoxUtilityClass.wait(driver, 1000);
	  home.logoutApp(driver);
  }
  
  @AfterClass
  public void closeTheBrowser()
  {
	  driver.close();
  }
  
}
