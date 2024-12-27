package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLoginPage {
	//Define Repository
	@FindBy(id = "btnreset")
	WebElement ObjReset;
	@FindBy(xpath = "//input[@id='username']")
	WebElement ObjUser;
	@FindBy(xpath = "//input[@id='password']")
	WebElement ObjPass;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjLogin;

	//Write a Method
	public void adminLogin(String User, String Pass) {
		ObjReset.click();;
		ObjUser.sendKeys(User);
		ObjPass.sendKeys(Pass);
		ObjLogin.click();

	}
}
