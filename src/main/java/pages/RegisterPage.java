package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
    
    @FindBy(id = "input-lastname")
	private WebElement lastNameField;
    
    @FindBy(id = "input-email")
	private WebElement emailAddressField;
    
    @FindBy(id = "input-telephone")
	private WebElement phoneNumField;
    
    @FindBy(id = "input-password")
	private WebElement passwordField;
    
    @FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
    
    @FindBy(xpath = "//label[@class='radio-inline']/input[@value='1']")
	private WebElement subscribeOptionYes;
    
    @FindBy(name = "agree")
	private WebElement agreeForPrivacyPolicy;
    
    @FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
    
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailAddressWarning;
    
    @FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
    private WebElement privacyPolicyWarning;
    
    @FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
    private WebElement firstNameWarning;
    
    @FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
    private WebElement lastNameWarning;
    
    @FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
    private WebElement emailAddressWarning;
    
    @FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
    private WebElement telephoneNumberWarning;
    
    @FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
    private WebElement passwordWarning;
    
    // Actions
    
    public void enterFirstname(String firstNameText) {
    	firstNameField.sendKeys(firstNameText);
	}
    
    public void enterLastName(String lastNameText) {
    	lastNameField.sendKeys(lastNameText);
	}

    public void enterEmail(String emailText) {
    	emailAddressField.sendKeys(emailText);
	}
    
    public void enterTelephone(String telephoneText) {
    	phoneNumField.sendKeys(telephoneText);
	}
    
    public void enterPassword(String passwordText) {
    	passwordField.sendKeys(passwordText);
	}
    
    public void enterConfirmPassword(String confirmPasswordText) {
    	confirmPasswordField.sendKeys(confirmPasswordText);
	}
    
    public void cliclOnAgreeForPrivacyPolicy() {
    	agreeForPrivacyPolicy.click();
	}
    
    public AccountSuccessPage clickOnContinueButton() {
    	continueButton.click();
    	return new AccountSuccessPage(driver);
	}
    
    public void selectSubscribeOptionYes() {
    	subscribeOptionYes.click();
	}

    public String getDuplicateEmailAddressWarning() {
    	String duplicateEmailAddressWarningText= duplicateEmailAddressWarning.getText();
    	return duplicateEmailAddressWarningText;
	}
    
    public String getPrivacyPolicyWarning( ) {
    	String privacyPolicyWarningText = privacyPolicyWarning.getText();
    	return privacyPolicyWarningText;
	}
    
    public String getFirstNameWarning( ) {
    	String  firstNameWarningText= firstNameWarning.getText();
    	return firstNameWarningText;
	}
    
    public String getLastNameWarning( ) {
    	String lastNameWarningText = lastNameWarning.getText();
    	return lastNameWarningText;
	}
    
    public String getEmailAddressWarning( ) {
    	String emailAddressWarningText = emailAddressWarning.getText();
    	return emailAddressWarningText;
	}
    
    public String getTelephoneNumberWarning( ) {
    	String telephoneNumberWarningText = telephoneNumberWarning.getText();
    	return telephoneNumberWarningText;
	}

	public String getPasswordWarning( ) {
    	String passwordWarningText = passwordWarning.getText();
    	return passwordWarningText;
	}
    
    
    
}
