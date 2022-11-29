package qa;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class URLLoginTest {

	// creating a logger
	private static Logger logger = LogManager.getLogger();
	
	@Test(priority=3)
	public void loadUrlEdge() {
		try {
			logger.info("starting program");
			WebDriver driver = DriverHelper.open_Driver(ConstantsHelper.edgeBrowser);
			DriverHelper.open_Url(ConstantsHelper.urlLogin, driver);
			String currentUrl = driver.getCurrentUrl();
		    if(!currentUrl.equals(ConstantsHelper.urlLogin))
		    	Assert.fail();
		    	
		} catch (Exception ex) {

			StackTraceElement stackTraceElements[] = ex.getStackTrace();
			logger.error("Exception occured . Exception message " + ex.getMessage() + " /n Stack Trace ");
			for (int i = 0, n = stackTraceElements.length; i < n; i++) {
				logger.error(": Line no " + stackTraceElements[i].getLineNumber() + ">> Method Name : "
						+ stackTraceElements[i].getMethodName() + "()");
				/*
				 * System.out.println(stackTraceElements[i].getFileName() +":" +
				 * stackTraceElements[i].getLineNumber() +">>" +
				 * stackTraceElements[i].getMethodName()+ "()");
				 */
			}
		}
	}
	
	@Test(priority=2)
	public void loadUrlChrome() {
		try {
			logger.info("starting program");
			WebDriver driver = DriverHelper.open_Driver(ConstantsHelper.chromeBrowser);
			DriverHelper.open_Url(ConstantsHelper.urlLogin, driver);
			String currentUrl = driver.getCurrentUrl();
		    if(!currentUrl.equals(ConstantsHelper.urlLogin))
		    	Assert.fail();
		    	
		} catch (Exception ex) {

			StackTraceElement stackTraceElements[] = ex.getStackTrace();
			logger.error("Exception occured . Exception message " + ex.getMessage() + " /n Stack Trace ");
			for (int i = 0, n = stackTraceElements.length; i < n; i++) {
				logger.error(": Line no " + stackTraceElements[i].getLineNumber() + ">> Method Name : "
						+ stackTraceElements[i].getMethodName() + "()");
				/*
				 * System.out.println(stackTraceElements[i].getFileName() +":" +
				 * stackTraceElements[i].getLineNumber() +">>" +
				 * stackTraceElements[i].getMethodName()+ "()");
				 */
			}
		}
	}
	
	@Test(priority=1)
	public void loadUrlFireFox() {
		try {
			logger.info("starting program");
			WebDriver driver = DriverHelper.open_Driver(ConstantsHelper.firefoxBrowser);
			DriverHelper.open_Url(ConstantsHelper.urlLogin, driver);
			String currentUrl = driver.getCurrentUrl();
		    if(!currentUrl.equals(ConstantsHelper.urlLogin))
		    	Assert.fail();
		    	
		} catch (Exception ex) {

			StackTraceElement stackTraceElements[] = ex.getStackTrace();
			logger.error("Exception occured . Exception message " + ex.getMessage() + " /n Stack Trace ");
			for (int i = 0, n = stackTraceElements.length; i < n; i++) {
				logger.error(": Line no " + stackTraceElements[i].getLineNumber() + ">> Method Name : "
						+ stackTraceElements[i].getMethodName() + "()");
				/*
				 * System.out.println(stackTraceElements[i].getFileName() +":" +
				 * stackTraceElements[i].getLineNumber() +">>" +
				 * stackTraceElements[i].getMethodName()+ "()");
				 */
			}
		}
	}
}
