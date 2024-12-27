package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogoutPage {
	//Define Repository
	@FindBy(xpath="(//a[.=' Logout'])[2]")
	WebElement ObjLogout;
	//Create Method
	public void adminLogout() {
		ObjLogout.click();
	}

}
