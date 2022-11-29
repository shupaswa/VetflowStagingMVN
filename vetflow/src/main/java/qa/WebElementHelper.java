package qa;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElementHelper {

	public static WebElement getElement(String selector, String searchText, WebDriver driver) throws Exception {
		try {
			WebElement element = null;
			switch (selector) {
			  case ConstantsHelper.id:
				  element = driver.findElement(By.id(searchText));
			    break;
			  case ConstantsHelper.name:
				  element = driver.findElement(By.name(searchText));
			    break;
			  case ConstantsHelper.className:
				  element = driver.findElement(By.className(searchText));
			    break;
			  case ConstantsHelper.tagName:
				  element = driver.findElement(By.tagName(searchText));
			    break;
			  case ConstantsHelper.cssSelector:
				  element = driver.findElement(By.cssSelector(searchText));
			    break;
			  case ConstantsHelper.xpath:
				  element = driver.findElement(By.xpath(searchText));
			    break;
			  case ConstantsHelper.linkText:
				  element = driver.findElement(By.linkText(searchText));
			    break;
			  case ConstantsHelper.partialLinkText:
				  element = driver.findElement(By.partialLinkText(searchText));
			}
			return element;
		}catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	public static WebElement getElementWithWait(String selector, WebDriver driver, int timeInSec, String searchText) throws Exception
	{
		//new WebDriverWait(driver, Duration.ofSeconds(15)).until(
		 // ExpectedConditions.elementToBeClickable(By.id(searchText)));
			 
		try {
			By bySelector= null;
			switch (selector) {
			  case ConstantsHelper.id:
				  bySelector = By.id(searchText);
			    break;
			  case ConstantsHelper.name:
				  bySelector = By.name(searchText);
			    break;
			  case ConstantsHelper.className:
				  bySelector = By.className(searchText);
			    break;
			  case ConstantsHelper.tagName:
				  bySelector = By.tagName(searchText);
			    break;
			  case ConstantsHelper.cssSelector:
				  bySelector = By.cssSelector(searchText);
			    break;
			  case ConstantsHelper.xpath:
				  bySelector = By.xpath(searchText);
			    break;
			  case ConstantsHelper.linkText:
				  bySelector = By.linkText(searchText);
			    break;
			  case ConstantsHelper.partialLinkText:
				  bySelector = By.partialLinkText(searchText);
			}
			return new WebDriverWait(driver, Duration.ofSeconds(timeInSec)).until(
				    ExpectedConditions.elementToBeClickable(bySelector));
					  
		}catch(Exception ex)
		{
			throw new Exception(ex);
		}
		
	}
	
}
