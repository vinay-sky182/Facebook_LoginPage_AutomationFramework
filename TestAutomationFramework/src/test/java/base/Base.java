package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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
			ChromeOptions co = new ChromeOptions();
			co.addArguments("--disable-notifications");
			co.addArguments("--disable-save-password");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
			
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			FirefoxOptions fo = new FirefoxOptions();
			fo.addArguments("--disable-notifications");
			fo.addArguments("--disable-save-password");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(fo);			
		}
		else {
			WebDriverManager.edgedriver().setup();
			EdgeOptions eo = new EdgeOptions();
			eo.setCapability("--disable-notifications", true);
			eo.setCapability("--disable-save-password", true);
			driver = new EdgeDriver();	
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	/*
	 * public void tearDown() { driver.close(); }
	 */

}
