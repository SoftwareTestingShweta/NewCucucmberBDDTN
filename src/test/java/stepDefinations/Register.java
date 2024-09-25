package stepDefinations;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {
	
	WebDriver driver;
	private RegisterPage registerPage;
	private AccountSuccessPage accountSuccessPage;
	private CommonUtils commonUtils;
	
	@Given("User navigates to Register account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		registerPage = homePage.clickOnRegisterOption();
	
	}

	@When("user enters the deatils into below fields")
	public void user_enters_the_deatils_into_below_fields(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		commonUtils = new CommonUtils();
		registerPage.enterEmail(commonUtils.getEmailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("confirmPassword"));
		
	}
	
	@When("user enters the deatils into below fields with duplicate email")
	public void user_enters_the_deatils_into_below_fields_with_duplicate_email(DataTable dataTable) {
	    
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstname(dataMap.get("firstName"));
		registerPage.enterLastName(dataMap.get("lastName"));
		registerPage.enterEmail(dataMap.get("email"));
		registerPage.enterTelephone(dataMap.get("telephone"));
		registerPage.enterPassword(dataMap.get("password"));
		registerPage.enterConfirmPassword(dataMap.get("confirmPassword"));
		
	}

	@When("User select privacy policy")
	public void user_select_privacy_policy() {
		
		registerPage.cliclOnAgreeForPrivacyPolicy();
	}

	@When("User click on continue button")
	public void user_click_on_continue_button() {
		
		accountSuccessPage = registerPage.clickOnContinueButton();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
		
		Assert.assertTrue(accountSuccessPage.getAccountSuccessText().contains("Your Account Has Been Created!"));
	}

	@When("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
		
		registerPage.selectSubscribeOptionYes();
	}

	@Then("User should get warning about duplicate email")
	public void user_should_get_warning_about_duplicate_email() {
		
		Assert.assertTrue(registerPage.getDuplicateEmailAddressWarning().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any deatils into the fields")
	public void user_dont_enter_any_deatils_into_the_fields() {
	   
		registerPage.enterFirstname("");
		registerPage.enterLastName("");
		registerPage.enterEmail("");
		registerPage.enterTelephone("");
		registerPage.enterPassword("");
		registerPage.enterConfirmPassword("");
		
	}

	@Then("User should get proper warning message for each mandetory fields")
	public void user_should_get_proper_warning_message_for_each_mandetory_fields() {
		
		Assert.assertEquals("Warning: You must agree to the Privacy Policy!",registerPage.getPrivacyPolicyWarning());
	//	Assert.assertTrue(registerPage.getPrivacyPolicyWarning().contains(" Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",registerPage.getFirstNameWarning());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",registerPage.getLastNameWarning());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",registerPage.getEmailAddressWarning());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",registerPage.getTelephoneNumberWarning());
		Assert.assertEquals("Password must be between 4 and 20 characters!",registerPage.getPasswordWarning());
		     
	}
	
    




}
