package qa;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//This is a helper class for any operation related to drivers/browsers

public class DriverHelper {
	
	public static WebDriver driver= null;
	// Creating a logger
		private static Logger logger = LogManager.getLogger();
	
	public static WebDriver open_Driver(String name) throws Exception
	{
		logger.info("Attempting to open browser " + name); 
		try {
			if(name.toLowerCase().equals(ConstantsHelper.chromeBrowser))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Chrome Driver Oct 2022\\chromedriver.exe");
				
				return driver = new ChromeDriver();
			
			}
			else if(name.toLowerCase().equals(ConstantsHelper.firefoxBrowser))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\admin\\gecko_driver\\geckodriver.exe");
				return driver = new FirefoxDriver();
			}
			else
			{
				System.setProperty("webdriver.edge.driver", "C:\\Users\\admin\\edge driver\\msedgedriver.exe");
				return driver = new EdgeDriver();
			} 
		}catch(Exception ex) {
			logger.error("Exception occured while opening browser. Exception message "+ex.getMessage()+ " /n Stack Trace "+ ex.getStackTrace());
			throw ex;
		}
			
	}
	
	public static void open_Url(String url, WebDriver driver)
	{
		logger.info("Getting url " + url); 
		driver.get(url);
		logger.info("Success in getting url " + url); 
	}
	
	public static void close_Driver(WebDriver driver)
	{
		logger.info("attempting to close browser"); 
		driver.close();
		logger.info("Browser closed"); 
	}
	
	public static void quit_Driver(WebDriver driver)
	{
		logger.info("attempting to quit browser"); 
		driver.quit();
		logger.info("Browser quit"); 
	}
	
	public static void implicitWait(WebDriver driver, int timeInSec)
	{
		logger.info("Attempting to implicity wait"); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
		logger.info("Implicity waited for "+timeInSec); 
	
	}
	
}