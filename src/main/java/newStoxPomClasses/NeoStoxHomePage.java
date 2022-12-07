package newStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxHomePage {
	
	@FindBy(id="lbl_username")private WebElement username;
	@FindBy(id="lbl_curbalancetop")private WebElement fund;
	@FindBy(id="lnk_logout")private WebElement logout;
	@FindBy(xpath="(//a[text()='OK'])[2]")private WebElement popupOkButton;
	@FindBy(xpath="(//a[text()='Close'])[5]")private WebElement popupCloseButton;
	
	
	public NeoStoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   	
	public void popupHandling(WebDriver driver) throws InterruptedException
	{
		if(popupOkButton.isDisplayed())
		{
			Thread.sleep(1000);
			popupOkButton.click();
			Thread.sleep(1000);
			popupCloseButton.click();
			
			Reporter.log("popup handled", true);
			
		}
		else
		{
			Reporter.log("popup is not present", true);
		}
	}
	
   public String getActualUsername(WebDriver driver)
   {
	   String actualUsername = username.getText();
	   Reporter.log("actual username", true);
	   return actualUsername;
	  
   }
   
   public String getActualFund(WebDriver driver)
   {
	   String actualFund = fund.getText();
	   Reporter.log("actual fund ", true);
	   
	   return actualFund;
	   
   }
   
   
   public void logoutApp(WebDriver driver) throws InterruptedException
   {
	   username.click();
	   
	   Thread.sleep(1000);
	   
	   logout.click();
	   
	   Reporter.log("logging out ", true);
	   
   }
   
   
   
}
