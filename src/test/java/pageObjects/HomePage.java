package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// @FindBy(xpath="//a[@title='My Account']") WebElement lnkMyAcoount;

	// @FindBy(xpath = "//span[text()='My Account']/parent::a | //a[@title='My
	// Account']")
	// WebElement lnkMyAcoount;
	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAcoount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnkLogin;

	public void clickMyAccount() {
		lnkMyAcoount.click();
	}

	public void clickRegister() {
		lnkRegister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

}
