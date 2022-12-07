package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.NeoStoxUtilityClass;

public class NeoStoxBaseClass {

	
	static protected WebDriver driver;
	
	public void launchBrowser() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver", "E:\\selenium files\\chromedriver.exe");
		 
		driver=new ChromeDriver();
		
		driver.get(NeoStoxUtilityClass.getDataFromPropertyFile("url"));
		
		driver.manage().window().maximize();
		
		NeoStoxUtilityClass.wait(driver, 1000);
		
		Reporter.log("launching browser", true);
		
		
	}
	
	
}
