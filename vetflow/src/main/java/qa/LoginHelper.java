package qa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
 

public class LoginHelper {
	 
	
	  
	  
	 
		private static Logger logger = LogManager.getLogger();
	
		private static XSSFWorkbook readExcel() throws Exception {
		try {
			 // Specify the path of file
  		  File src=new File("C:\\Users\\admin\\Downloads\\Logincredentialss.xlsx");

  		   // load file
  		   FileInputStream fis=new FileInputStream(src);
  		 
  		   // Load workbook
  		   XSSFWorkbook wb=new XSSFWorkbook(fis);
  		   return wb;
		}catch(Exception e) {
			throw e;
		}
	}
	
	
	public static List<String> readValidCreds() throws Exception{
		List<String> listCreds = new ArrayList<String>();
		// WebDriver driver = DriverHelper.open_Driver(ConstantsHelper.chromeBrowser);
		 
    	try {
    		 
    		XSSFWorkbook wb = readExcel();
    		   // Load sheet- Here we are loading first sheet only
    		      XSSFSheet sh1= wb.getSheetAt(0);
    		 
    		    int totalRows = sh1.getPhysicalNumberOfRows();
    		    for(int i = 1; i <= totalRows-1; i++)
    		    {
    		    	String up= sh1.getRow(i).getCell(0).getStringCellValue() +","+ sh1.getRow(i).getCell(1).getStringCellValue();
    		    	listCreds.add(up);
    		    	
    		    }
    		     /*for(String item:list)
    		     {
    		    	 //Split 
    		    	//String[] itemArray= item.split(",", 0);
    		    	//logger.info(itemArray[0].toString() +"-"+itemArray[1].toString());
					
    		    	LoginTest obj1 = new LoginTest(); 
					  obj1.loginValidIdPwd(itemArray[0].toString(), itemArray[1].toString(), driver);
					 
    		     }
    		    */
				return listCreds;
			
    		  } catch (Exception e) {

    		  throw e;

    		  }
    		  
	}


	public static List<String> readInvalidCreds() throws Exception{
		List<String> listCreds = new ArrayList<String>();
    	try {
    		 
    		XSSFWorkbook wb = readExcel();
    		   // Load sheet- Here we are loading first sheet only
    		      XSSFSheet sh1= wb.getSheetAt(1);
    		 
    		    int totalRows = sh1.getPhysicalNumberOfRows();
    		    for(int i = 1; i <= totalRows-1; i++)
    		    {
    		    	String up= sh1.getRow(i).getCell(0).getStringCellValue() +","+ sh1.getRow(i).getCell(1).getStringCellValue();
    		    	listCreds.add(up);
    		    	
    		    }
				/*
				 * for(String item:list) { //Split String[] itemArray= item.split(",", 0);
				 * logger.info(itemArray[0].toString() +"-"+itemArray[1].toString());
				 * 
				 * LoginTest obj2 = new LoginTest();
				 * obj2.loginValidIdInvalidPwd(itemArray[0].toString(),itemArray[1].toString());
				 * 
				 * }
				 */
    		    
				return listCreds;
			
    		  } catch (Exception e) {

    		  throw e;

    		  }
    		  
	}
	
	/*
	 * This method is used for getting the valid credentials from spread sheet,
	 * login into the app with those creds. and returning that particular driver
	 * instance for further operations.
	 */
	public static WebDriver GenericLoginMethod() throws Exception{
		List<String> list = new ArrayList<String>();
		 WebDriver driver = DriverHelper.open_Driver(ConstantsHelper.chromeBrowser);
		 DriverHelper.implicitWait(driver, 40);
		 WindowOperationHelper.maximizeBrowser(driver);
    	try {
    		 
    		XSSFWorkbook wb = readExcel();
    		   // Load sheet- Here we are loading first sheet only
    		      XSSFSheet sh1= wb.getSheetAt(0);
    		 
    		    for(int i = 1; i <= 1; i++)
    		    {
    		    	String up= sh1.getRow(i).getCell(0).getStringCellValue() +","+ sh1.getRow(i).getCell(1).getStringCellValue();
    		    		list.add(up);
    		    	   
    		    }
				
				 for(String item:list) 
				 { 
					 //Split 
					 String[] itemArray= item.split(",", 0);
					 driver.get(ConstantsHelper.urlLogin);
		    		    WebElement username = WebElementHelper.getElement(ConstantsHelper.xpath, "//input[@id='username']", driver); 
		  			  username.sendKeys(itemArray[0].toString());
		  			  			  
		  			  
		  			  WebElement password = WebElementHelper.getElement(ConstantsHelper.xpath,"//input[@id='password']", driver); 
		  			  password.sendKeys(itemArray[1].toString());
		  			 			 

		  			  WebElement loginBtn = WebElementHelper.getElement(ConstantsHelper.xpath, "//button[contains(text(),'Sign In')]", driver);
		  			  loginBtn.click();
				 }  
    		    return driver;
    		  } catch (Exception e) {

    		  throw e;
    		  }
    		  
	}

}
