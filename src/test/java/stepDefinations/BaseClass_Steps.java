package stepDefinations;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.Add_Customer_Page;
import pageObjects.Login_Page_POM;
import pageObjects.Search_Customer_Page;

public class BaseClass_Steps {

	WebDriver driver;
	public Login_Page_POM lp;
	public Add_Customer_Page addCusPage;
	public Search_Customer_Page search_cus_page;
	public Logger logger;
	public Properties configProp;
	
	
	
	
	// Generating Random Unique Email

		public static String generateRandomEmail() {

			String randomEmail = RandomStringUtils.randomAlphabetic(5);
			return randomEmail;

		}
	
}
