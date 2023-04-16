package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils; 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {
	
	public void screenShot(String TestCase, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE); // This is the Raw format of file.
		FileUtils.copyFile(source, new File("./Screenshot/"+TestCase+".jpeg")); // Convert the Raw format into Human Readable format.
		
	}

}
