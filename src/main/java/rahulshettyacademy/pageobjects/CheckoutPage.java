package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".action__submit")
	 private WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;

	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;

	//private By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) throws InterruptedException {
		int count=0;
		Actions a = new Actions(driver);
		while(count<10) {
		try {		
		a.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
		break;
		}catch(Exception e) {
			Thread.sleep(1000);
			count++;
		}
		}
	}
	
	public ConfirmationPage submitOrder() throws InterruptedException
	{   int count=0;
		while(count<10) {
	
		try { 
		submit.click();
		break;
		}catch(Exception e) {
			Thread.sleep(1000);
			count++;
		}
		}
		return new ConfirmationPage(driver);
		
	}

}
