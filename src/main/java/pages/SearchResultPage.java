package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultPage {
	
	WebDriver driver;
	
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validHPProduct;
	
	@FindBy(xpath = "//div[@id='content']/descendant::p[2]")
	private WebElement noProductmessage;
	
	public boolean displayValidSearchProduct() {
		
		return validHPProduct.isDisplayed();
//		boolean hpProduct= validHPProduct.isDisplayed();
//		return hpProduct;
	}
	
	public String displayNoProductMessage() {
		
		return noProductmessage.getText();
//		String noProductText = noProductmessage.getText();
//		return noProductText;
	}

}
