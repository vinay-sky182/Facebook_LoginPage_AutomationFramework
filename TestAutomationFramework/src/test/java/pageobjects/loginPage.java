package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class loginPage extends Base {

	public loginPage(WebDriver driver) {
        
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.ID, using = "email")
	private WebElement txtEmail;

	@FindBy(id = "pass")
	private WebElement txtPass;

	@FindBy(name = "login")
	private WebElement btnLogin;

	public void txtEmail(String userId) {
		txtEmail.sendKeys(userId);
	}

	public void txtPass(String password) {
		txtPass.sendKeys(password);
	}

	public void btnLogin() {
		btnLogin.click();
	}

}
