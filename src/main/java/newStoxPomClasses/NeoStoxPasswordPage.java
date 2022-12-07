package newStoxPomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class NeoStoxPasswordPage {
	
	@FindBy(id="txt_accesspin")private WebElement password;
	@FindBy(id="lnk_submitaccesspin")private WebElement submitbutton;
	
	
	public NeoStoxPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	
	public void enterPassword(WebDriver driver,String pw)
	{
		password.sendKeys(pw);
		
		Reporter.log("enterning password", true);
	}
	public void clickOnSubmitButton(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		submitbutton.click();
		
		Reporter.log("clicked submit button",true);
	}
}