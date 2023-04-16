package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class userFBPage{

	public userFBPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//span[contains(text(),'Home')]") 
	WebElement optHome;
	
	public WebElement optHome() {
		return optHome;
	}
}
