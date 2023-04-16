package testcase;

import java.io.IOException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.Base;
import pageobjects.loginPage;
import pageobjects.userFBPage;
import utilities.ReadXLdata;
import utilities.ScreenshotUtility;

public class LoginTestCase extends Base {

	@BeforeMethod
	public void open() throws IOException {
		setUp();
		driver.get(prop.getProperty("url")); 
	}

	@Test(dataProvider = "drivertest")
	public void login(String uName, String uPass) {

		loginPage lp = new loginPage(driver);

		lp.txtEmail(uName);
		lp.txtPass(uPass);
		lp.btnLogin();

		userFBPage ufp = new userFBPage(driver);

		Assert.assertTrue(ufp.optFindFriends().isDisplayed());

	}

	@AfterMethod
	public void closure(ITestResult result) throws IOException {
		
		if (result.getStatus()==ITestResult.FAILURE) {
			
			ScreenshotUtility su = new ScreenshotUtility();
			su.screenShot(result.getName(), driver);
		}
		driver.close();
	}

	@DataProvider(name = "drivertest")
	public Object[][] dataSheet() throws IOException {

		ReadXLdata xd = new ReadXLdata();
		return (xd.getData("Sheet1"));

	}
}
