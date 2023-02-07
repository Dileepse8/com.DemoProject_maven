package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Add_Customer_Page {

	public WebDriver driver;

	public Add_Customer_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "(//p[contains(text(),'Customers')])[1]")
	WebElement menuCustomers;
	@FindBy(xpath = "(//p[contains(text(),'Customers')])[2]")
	WebElement subMenuCustomers;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement btnCustomersAddbutton;
	@FindBy(id = "Email")
	WebElement txtEmail;
	@FindBy(id = "Password")
	WebElement txtPassword;
	@FindBy(id = "FirstName")
	WebElement txtFirstName;
	@FindBy(id = "LastName")
	WebElement txtLastName;

	@FindBy(id = "Gender_Male")
	WebElement rdioGender_Male;
	@FindBy(id = "Gender_Female")
	WebElement rdioGender_Female;

	@FindBy(id = "Company")
	WebElement txtCompany;

	@FindBy(xpath = "(//div[@class='k-multiselect-wrap k-floatwrap'])[2]")
	WebElement customersRoles;

	@FindBy(xpath = "//li[contains(text(),'Vendors')]")
	WebElement drpCusVendors;

	@FindBy(xpath = "//li[contains(text(),'Guests')]")
	WebElement drpCusGuests;

	@FindBy(xpath = "//li[contains(text(),'Forum Moderators')]")
	WebElement drpCusForum_Moderators;

	@FindBy(xpath = "//li[contains(text(),'Administrators')]")
	WebElement drpCusAdministrators;

	@FindBy(xpath = "//li[contains(text(),'Registered')]")
	WebElement drpCusRegistered;

	@FindBy(id = "VendorId")
	WebElement drpVendorId;

	@FindBy(id = "AdminComment")
	WebElement txtAdminComment;

	@FindBy(id = "DateOfBirth")
	WebElement dateDateOfBirth;

	@FindBy(xpath = "//button[@name='save']")
	WebElement btnSave;

	@FindBy(tagName = "body")
	WebElement bodyTextmsg;
//	@FindBy(xpath = "//textarea[@id='AdminComment']")
//	WebElement txtAdminComment;

	// Actions Methods
	
	public void clickSaveCustomer() {
		btnSave.click();
	}
	
	
	public void enterAdminComments(String comments) {
		txtAdminComment.sendKeys(comments);
	}
	
	

	public String getTitle() {
		return driver.getTitle();
	}

	public void clickMenuCustomers() {
		menuCustomers.click();
	}

	public void clickSubMenuCustomers() {
		subMenuCustomers.click();
	}

	public void clickCustomersAddButton() {
		btnCustomersAddbutton.click();
	}

	public void EnterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);

	}

	public void EnterFirstName(String firsrName) {
		txtFirstName.sendKeys(firsrName);
	
	}

	public void EnterLastName(String lastName) {
		txtLastName.sendKeys(lastName);
		
	}

	public void selectGender(String gender) {
		if (gender.equals("Male")) {
			rdioGender_Male.click();
		} else if (gender.equals("Female")) {
			rdioGender_Female.click();
		} else {
			rdioGender_Male.click(); // By Default Selected
		}

	}

	public void enterCompanyName(String companyName) {
		txtCompany.sendKeys(companyName);
	
	}

	public void enterDateOfBirth(String DOB) {
		dateDateOfBirth.sendKeys(DOB);
	}

	public void selectManagerVendorID(String value) {

		Select se = new Select(drpVendorId);
		se.selectByVisibleText(value);

	}

	public boolean confirmationmsg() { // this will use after added cus successmsg should validaed purpose we use
		boolean res = bodyTextmsg.getText().contains("The new customer has been added successfully.");
		return res;

	}

	public void selectCustomerRoles(String role) throws InterruptedException {

		if (!role.equals("Vendors")) {

		}
		WebElement listItem;

		customersRoles.click();
		Thread.sleep(1000);
		if (role.equals("Administrators")) {
			listItem = drpCusAdministrators;
		} else if (role.equals("Forum Moderators")) {
			listItem = drpCusForum_Moderators;
		} else if (role.equals("Guests")) {
			listItem = drpCusGuests;
		} else if (role.equals("Registered")) {
			listItem = drpCusRegistered;
		} else if (role.equals("Vendors")) {
			listItem = drpCusVendors;
		} else {
			listItem = drpCusGuests;
		}
		listItem.click();
		// JavascriptExecutor js= (JavascriptExecutor)driver;
		// js.executeScript("arguments[0].click();", listItem);

	}

}
