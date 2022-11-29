package qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class WindowOperationHelper {
	private static Logger logger = LogManager.getLogger();
	
	public static void maximizeBrowser(WebDriver driver)
	{
		logger.info("Maximizing browser");
		driver.manage().window().maximize();
		logger.info("Browser maximized ");
	}
	public static void minimizeBrowser(WebDriver driver)
	{
		logger.info("Minimizing browser");
		driver.manage().window().maximize();
		logger.info("Browser minimized ");
	}
	public static void fullscreenBrowser(WebDriver driver)
	{
		logger.info("Attempting to open the browser in fullscreen");
		driver.manage().window().fullscreen();
		logger.info("Opened the browser in fullscreen");
	}
	
}
