package PageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppOfferScreen {
	
	AppiumDriver ldriver;

	public AppOfferScreen(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_proceed\"]")
	@CacheLookup
	WebElement offerAcceptBtn;
	
	
	public boolean ifOfferDisplayed() {
		try {
			return
					offerAcceptBtn.isDisplayed();
		}
		catch (NoSuchElementException e)
	
		{
			return false;
		}
	}	
	
	public void SelectAcceptOfferBtn(){
		offerAcceptBtn.click();
	}
	

}
