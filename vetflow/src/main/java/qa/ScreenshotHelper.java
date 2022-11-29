package qa;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotHelper {

	public static String takeScreenshot(WebDriver driver, String ssname, String filetype) throws Exception
	{
		try {
			filetype= filetype.length() == 0? "png": filetype;
			
			Date date = new Date();
		    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		    String folderName = formatter.format(date);
			
			File theDir = new File(ConstantsHelper.ssBasePath + folderName);
			if (!theDir.exists()){
			    theDir.mkdirs();
			}
			
			File file = new File(theDir.getPath()+"\\"+ ssname + "." + filetype);
			if(file.exists() && !file.isDirectory()) { 
			    ssname = ssname + UUID.randomUUID().toString();
			}
			
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			src.renameTo(new File(theDir.getPath()+"\\" + ssname + "." + filetype));
			
			String fileProcessedFilePath = theDir.getPath()+"\\" + ssname + "." + filetype;
			return fileProcessedFilePath;
			
		}catch(Exception ex) {
			throw new Exception(ex);
		}
		
	}
}
