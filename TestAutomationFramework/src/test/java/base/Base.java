package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected  WebDriver driver;
	protected  Properties prop = new Properties();
	protected  FileInputStream fip;
	
	public void setUp() throws IOException {
		
		if(driver==null) {
		
		fip = new FileInputStream(System.getProperty("user.dir")+
				"\\src\\test\\resources\\configfiles\\config.properties");
		
		
		prop.load(fip);
		}
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();			
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	/*
	 * public void tearDown() { driver.close(); }
	 */

}
