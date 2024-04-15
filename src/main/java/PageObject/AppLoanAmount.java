package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLoanAmount {
	
	AppiumDriver ldriver;

	public AppLoanAmount(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(id="com.flexiloan:id/selectedValue")
	@CacheLookup
	WebElement loanAmountField;
	
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_proceed\"]")
	@CacheLookup
	WebElement CheckLoanEligibilityBtn;
	
	public void ClickLoanAmountField(){
		loanAmountField.click();
	}
	
	public void EnterLoanAmount(String amount) {
		loanAmountField.sendKeys(amount);
	}
	
	public void ClickCheckLoanEligibilityBtn() {
		CheckLoanEligibilityBtn.click();
	}

}
