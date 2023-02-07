package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class Search_Customer_Page {

	WebDriver driver;
	WaitHelper waithelp;

	public Search_Customer_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelp = new WaitHelper(driver);

	}

	@FindBy(id = "SearchEmail")
	WebElement txtSearchEmail;
	@FindBy(id = "SearchFirstName")
	WebElement txtSearchFirstName;
	@FindBy(id = "SearchLastName")
	WebElement txtSearchLastName;

	@FindBy(xpath = "//button[@id='search-customers']")
	WebElement btnSearch;

	@FindBy(xpath = "//table[@id='customers-grid']")
	WebElement table;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> lstRows;

	@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> lstCols;

	// Actions
	public void entersearchEmail(String email) {
		waithelp.waitForWait(txtSearchEmail, 30);
		txtSearchEmail.clear();
		txtSearchEmail.sendKeys(email);
	}

	public void entersearchFirstName(String firstName) {
		waithelp.waitForWait(txtSearchEmail, 30);
		txtSearchFirstName.clear();
		txtSearchFirstName.sendKeys(firstName);
	}

	public void entersearchLastName(String lastName) {
		waithelp.waitForWait(txtSearchEmail, 30);
		txtSearchLastName.clear();
		txtSearchLastName.sendKeys(lastName);
	}

	public void clickSearchCusButton() {
		btnSearch.click();
		waithelp.waitForWait(btnSearch, 30);
	}

	public int getNumOfRows() {
		return (lstRows.size());
	}

	public int getNumOfCols() {
		return (lstCols.size());
	}

	public boolean searchCustomerByEmailID(String email) {

		boolean res = false;
		for (int j = 1; j <= getNumOfRows(); j++) {

			String emailID = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + j + "]/td[2]"))
					.getText();
			if (emailID.equals(email)) {
				// "victoria_victoria@nopCommerce.com"
				res = true;
			}

		}
		return res;

	}

	public boolean searchCustomerByFNameNdLName(String email) {

		boolean res = false;
		for (int j = 1; j <= getNumOfRows(); j++) {

			String[] str = email.split(" ");
			String fname = str[0];
			String lname = str[1];

			String emailID = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + j + "]/td[3]"))
					.getText();
			if (str[0].equals(fname) && str[1].equals(lname)) {
				res = true;

			}

		}
		return res;

	}
}
