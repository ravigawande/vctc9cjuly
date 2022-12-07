package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class NeoStoxUtilityClass {
	
	
	public static String getDataFromPropertyFile(String key) throws IOException
	{
	  Properties p=new Properties();
	  FileInputStream myfile=new FileInputStream("C:\\Users\\Dell\\eclipse-workspace\\09julyCBatch\\NeoStoxProperty.properties");
	  p.load(myfile);
	  String value = p.getProperty(key);
	  return value;
	  }
	
	public static void wait(WebDriver driver,long time)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		
	}
	
	public static void screenshot(WebDriver driver,String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	File destination=new File("E:\\software testing lect\\Selenium screenshot \\screenshot"+name+".jpeg "  );
	FileHandler.copy(source, destination);
	}
	
	
	

}
