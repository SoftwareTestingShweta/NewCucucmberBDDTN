package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.SearchResultPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchResultPage searchResultPage;
	
	@Given("User opens the application")
	public void user_opens_the_application() {
		
		driver = DriverFactory.getDriver();
	}

	@When("user enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) {
		
		homePage = new HomePage(driver);
		homePage.enterInSearchBoxField(validProduct);
	}

	@When("user clicks on Search button")
	public void user_clicks_on_search_button() {
		
		searchResultPage = homePage.clickOnSearchButton();
	}

	@Then("user should get valid product displayed on search result")
	public void user_should_get_valid_product_displayed_on_search_result() {
		
		Assert.assertTrue(searchResultPage.displayValidSearchProduct()) ;
		Assert.fail();
	}

	@When("user enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) {
		homePage = new HomePage(driver);
		homePage.enterInSearchBoxField(invalidProduct);
	}

	@Then("user should get a message about no product matching")
	public void user_should_get_a_message_about_no_product_matching() {
		
		 Assert.assertEquals("There is no product that matches the search criteria.",searchResultPage.displayNoProductMessage());
	}

	@When("user dont enter any product name into search box field")
	public void user_dont_enter_any_product_name_into_search_box_field() {
		homePage = new HomePage(driver);
		homePage.enterInSearchBoxField("");
	}





}
