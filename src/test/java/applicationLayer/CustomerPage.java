package applicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class CustomerPage {
	//Define Repository to Add Customer
	@FindBy(xpath = "(//a[contains(text(),'Customers')])[2]")
	WebElement ObjClickCustomerLink;
	@FindBy(xpath = "(//span[@data-caption='Add'])[1]")
	WebElement ObjClickAddIcon;
	@FindBy(xpath = "//input[@id='x_Customer_Number']")
	WebElement ObjCustomerNumber;
	@FindBy(xpath = "//input[@id='x_Customer_Name']")
	WebElement ObjCustomerName;
	@FindBy(xpath = "//textarea[@id='x_Address']")
	WebElement ObjAddress;
	@FindBy(xpath = "//input[@id='x_City']")
	WebElement ObjCity;
	@FindBy(xpath = "//input[@id='x_Country']")
	WebElement ObjCountry;
	@FindBy(xpath = "//input[@id='x_Contact_Person']")
	WebElement ObjContactPerson;
	@FindBy(xpath = "//input[@id='x_Phone_Number']")
	WebElement ObjPhoneNumber;
	@FindBy(xpath = "//input[@id='x__Email']")
	WebElement ObjEmail;
	@FindBy(xpath = "//input[@id='x_Mobile_Number']")
	WebElement ObjMobileNumber;
	@FindBy(xpath = "//input[@id='x_Notes']")
	WebElement ObjNotes;
	@FindBy(id = "btnAction")
	WebElement ObjClickAddBtn;
	@FindBy(xpath = "//button[normalize-space()='OK!']")
	WebElement ObjClickConfirmOK;
	@FindBy(xpath = "(//button[starts-with(text(),'OK')])[6]")
	WebElement ObjAlertOk;
	@FindBy(xpath = "//span[@data-caption='Search']")
	WebElement ObjSearchPanel;
	@FindBy(xpath = "//input[@id='psearch']")
	WebElement ObjSearchTextbox;
	@FindBy(xpath = "//button[@id='btnsubmit']")
	WebElement ObjSearchButton;
	@FindBy(xpath = "//table[@class='table ewTable']/tbody/tr[1]/td[5]/div/span/span")
	WebElement webTable;

	//Method for customer Module
	public boolean customer_Validate(String CustomerName,String Address,String City,String Country,
			String contactPerson,String PhoneNumber,String Email,String MobileNumber,String Notes)throws Throwable
	{

		ObjClickCustomerLink.click();
		ObjClickAddIcon.click();
		String Exp_Data = ObjCustomerNumber.getAttribute("value");
		ObjCustomerName.sendKeys(CustomerName);
		ObjAddress.sendKeys(Address);
		ObjCity.sendKeys(City);
		ObjCountry.sendKeys(Country);
		ObjContactPerson.sendKeys(contactPerson);
		ObjPhoneNumber.sendKeys(PhoneNumber);
		ObjEmail.sendKeys(Email);
		ObjMobileNumber.sendKeys(MobileNumber);
		ObjNotes.sendKeys(Notes);
		ObjClickAddBtn.click();
		ObjClickConfirmOK.click();
		Thread.sleep(3000);
		ObjAlertOk.click();
		Thread.sleep(3000);
		if(!ObjSearchTextbox.isDisplayed())
			ObjSearchPanel.click();
		ObjSearchTextbox.clear();
		ObjSearchTextbox.sendKeys(Exp_Data);
		ObjSearchButton.click();
		Thread.sleep(3000);
		String Act_Data =webTable.getText();

		if(Act_Data.equals(Exp_Data))
		{
			Reporter.log("Customer number is Matching"+Exp_Data+"     "+Act_Data,true);
			return true;
		}
		else
		{
			Reporter.log("Customer number is Not Matching"+Exp_Data+"     "+Act_Data,true);
			return false;
		}

	}
}
