package stepDefinations;

import static org.testng.Assert.assertTrue;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {
	
	WebDriver driver;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtils commonUtils;
	
	@Given("User has navigated to login page")
	public void User_has_navigated_to_login_page() {
		
	
		driver = DriverFactory.getDriver();
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccount();
		loginPage =  homepage.clickOnLoginOption();
		
//		driver.findElement(By.xpath("//span[text()=\"My Account\"]")).click();
//		driver.findElement(By.linkText("Login")).click();
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validEmailText) {
		
		 loginPage.enterEmailField(validEmailText);
		
//	   driver.findElement(By.id("input-email")).sendKeys(validEmailText);
	}

	@When("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String validPasswordText) {
		
		loginPage.enterPasswordField(validPasswordText);
	//	driver.findElement(By.id("input-password")).sendKeys(validPasswordText);
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		
		accountPage = loginPage.clickOnLoginButton();
	  // driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
	 
		accountPage.editYourAccountInformationOptionText();
		//Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		
		commonUtils = new CommonUtils();
		loginPage.enterEmailField(commonUtils.getEmailWithTimeStamp());
	//	driver.findElement(By.id("input-email")).sendKeys(getEmailWithTimeStamp());
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		
		loginPage.enterPasswordField(invalidPasswordText);
	//	driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
	}

	@Then("User should get a proper warning message about credential mismatch")
	public void user_should_get_a_proper_warning_message_about_credential_mismatch() {
		
	     assertTrue(loginPage.getWaringMessageText().contains("Warning: No match for E-Mail Address and/or Password."));	
	 //  Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
		
		loginPage.enterEmailField("");
        //driver.findElement(By.id("input-email")).sendKeys("");
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
		
		loginPage.enterPasswordField("");
		//driver.findElement(By.id("input-password")).sendKeys("");
	}
	
	

	


}
