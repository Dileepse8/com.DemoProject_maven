package stepDefinations;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.Add_Customer_Page;
import pageObjects.Login_Page_POM;
import pageObjects.Search_Customer_Page;

public class Login_Steps extends BaseClass_Steps {

	@Before
	public void setUp() throws IOException {
		//Reading Properties
		configProp = new Properties();
		FileInputStream fis = new FileInputStream("config.properties");

		configProp.load(fis);

		logger = Logger.getLogger("DEMO_NOPECommerce");
		PropertyConfigurator.configure("log4j.properties");

		String brow = configProp.getProperty("browser");
		if (brow.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (brow.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (brow.equals("ie")) {
			WebDriverManager.edgedriver().setup();
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
	}

	@Given("User Launch the Chrome browser")
	public void user_launch_the_chrome_browser() {
		// System.setProperty("webdriver.chrome.driver.",
		// ".//Drivers/chromedriver.exe");

		lp = new Login_Page_POM(driver);

	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
		logger.info("********URL Is Opened*********");

	}

	@When("User Enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pwd) {
		logger.info("********Providing Names*********");
		lp.enterEmail(email);
		lp.enterPassword(pwd);

	}

	@When("Click on Login button")
	public void click_on_login_button() {
		logger.info("********Clicking Login *********");
		lp.clickLogin();

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {

		if (driver.getPageSource().contains("Login was unsuccessful")) {
			driver.quit();
			logger.info("******** Login passed *********");
			Assert.assertTrue(false);

		} else {
			Assert.assertEquals(title, driver.getTitle());
		}
		Thread.sleep(2000);

	}

	@When("User click on Logout Link")
	public void user_click_on_logout_link() throws InterruptedException {
		logger.info("******** LogOut Clicking *********");
		lp.clickLogOut();
		Thread.sleep(3000);
	}

	@Then("close the browser")
	public void close_the_browser() {
		logger.info("******** Browser Closing *********");

		driver.quit();
	}

	// Add Cus
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addCusPage = new Add_Customer_Page(driver);
		logger.info("******** Checking Title *********");
		Assert.assertEquals("Dashboard / nopCommerce administration", addCusPage.getTitle());

	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		logger.info("******** Clicked on Customers Menu*********");
		addCusPage.clickMenuCustomers();
		Thread.sleep(2000);

	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		logger.info("******** Clicking on Sub Customers Menu*********");
		addCusPage.clickSubMenuCustomers();
		Thread.sleep(2000);
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
		logger.info("******** Clicking Add New Button*********");
		addCusPage.clickCustomersAddButton();
	}

	@Then("User can view Add new customer Page")
	public void user_can_view_add_new_customer_page() {
		logger.info("********Checking Title*********");
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCusPage.getTitle());

	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		logger.info("******** Entering Details*********");
		String email = generateRandomEmail() + "@gmail.com";
		addCusPage.EnterEmail(email);
		logger.info("********Email Given*********");
		addCusPage.enterPassword("test123");
		logger.info("********Password Given*********");

		// Registerd As by Default
		// The Customer can not be in both "Guests" and "Registered" as Customer Role
		// Add Customer to "Guests" or "registered" Customer Role
		addCusPage.selectCustomerRoles("Guest");
		Thread.sleep(1000);
		System.out.println("Role is Selected");
		addCusPage.EnterFirstName("Dileep");
		System.out.println("FirstName is Typed");
		addCusPage.EnterLastName("Kumar");
		System.out.println("LastName is Typed");
		addCusPage.selectGender("Male");
		System.out.println("Gender is Selected");
		addCusPage.enterDateOfBirth("5/07/1994"); // D/MM/YYYY
		System.out.println("DOB Is Selected");
		addCusPage.enterCompanyName("Tata Consultancy Services");
		System.out.println("Comapany  is Typed");
		// addCustomerPage.selectNewsLetter("Test store 2"); // need to verify getti ng
		// eroor if it un commented
		// System.out.println("Newsletter is selected");
		// addCusPage.chkTaxExempt();

		addCusPage.enterAdminComments("Testing application Main");
		logger.info("********Comments Given*********");

		addCusPage.selectCustomerRoles("Registered");

		Thread.sleep(2000);
		addCusPage.selectManagerVendorID("Vendor 2");
		logger.info("********Vendor Given*********");
		// System.out.println("Vendor is selected");
		// addCusPage.chkchkActive();
		System.out.println("Active Check Box Is Clicked");

	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCusPage.clickSaveCustomer();
		logger.info("********Clicked on Save Button*********");

		Thread.sleep(2000);
		// System.out.println("Save Button is Clicked");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {

		Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
				.contains("The new customer has been added successfully."));
		// Assert.assertEquals("The customer has been added successfully.",

		// addCusPage.confirmationmsg());
		logger.info("********Customer added is Validated*********");
		// System.out.println("Customer added is Validated");

	}

	// Search Data by Email
	@When("Enter Customer Email on SearchBox")
	public void enter_customer_email_on_search_box() {
		search_cus_page = new Search_Customer_Page(driver);
		search_cus_page.entersearchEmail("victoria_victoria@nopCommerce.com");
		logger.info("********Email is Validated*********");

	}

	@When("Click on Search button")
	public void click_on_search_button() throws InterruptedException {
		search_cus_page.clickSearchCusButton();
		logger.info("********Search button is Clicked*********");

		Thread.sleep(2000);

	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
		boolean res = search_cus_page.searchCustomerByEmailID("victoria_victoria@nopCommerce.com");
		logger.info("********Email is Validated too*********");

		Assert.assertEquals(true, res);

	}

	// Search by Faname and LastName
	@When("Enter Customer FirstName")
	public void enter_customer_first_name() {
		search_cus_page = new Search_Customer_Page(driver);
		search_cus_page.entersearchFirstName("victoria");
		logger.info("********FirstName is Validated*********");
	}

	@When("Enter Customer LastName")
	public void enter_customer_last_name() {
		search_cus_page.entersearchLastName("Terces");
		logger.info("********LastName is Validated*********");
	}

	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
		boolean status = search_cus_page.searchCustomerByFNameNdLName("Victoria Terces");
		logger.info("********Name is Validated*********");
		Assert.assertEquals(true, status);

	}

}
