package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page_POM {
	
	public static WebDriver driver;
	public Login_Page_POM(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="Email") WebElement txtEmail;
	@FindBy(id="Password") WebElement txtPassword;
	@FindBy(xpath="//button[text()='Log in']") WebElement btnLogIn;
	@FindBy(xpath="//a[text()='Logout']") WebElement btnLogOut;
	
	//Actions
	public void enterEmail(String email) {
		txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	public void enterPassword(String password) {
		txtPassword.clear();
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogIn.click();
	}
	public void clickLogOut() {
		btnLogOut.click();
	}
}
