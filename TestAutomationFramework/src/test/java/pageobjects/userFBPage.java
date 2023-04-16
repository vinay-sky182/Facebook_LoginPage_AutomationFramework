package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class userFBPage extends Base {

	public userFBPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath = "//span[text()='Friends']") 
	WebElement optFindFriends;
	
	public WebElement optFindFriends() {
		return optFindFriends;
	}
}
