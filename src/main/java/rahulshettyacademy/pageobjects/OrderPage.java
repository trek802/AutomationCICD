package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;


public class OrderPage extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public Boolean VerifyOrderDisplay(String productName) throws InterruptedException {
		int count=0;
		Boolean match=false;
		while(count<10) {
		try	{
		match = productNames.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		break;
		}catch(Exception e) {
		Thread.sleep(1000);
		count++;
		}
		}
		return match;

	}


}
