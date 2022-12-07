package newStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxLoginPage {
	@FindBy(xpath="(//input[@type='number'])[1]") private WebElement mobile;
	@FindBy(id="lnk_signup1") private WebElement signup;
	
	
	
	public NeoStoxLoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public void enterMobileNumber(WebDriver driver,String mn) throws InterruptedException
	{
		Thread.sleep(500);
		mobile.sendKeys(mn);
		Reporter.log("sending mobile number", true);

	}
	
	public void clickONSignUpButton(WebDriver driver) throws InterruptedException
	{
	   Thread.sleep(500);
		signup.click();
		Reporter.log("clicking on submit button", true);
	}
	
	
}
