package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLandingPage {
	
	AppiumDriver ldriver;

	public AppLandingPage(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(id="com.flexiloan:id/et_mobile_number")
	@CacheLookup
	WebElement mobileNumberField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_monthly_sales\"]")
	@CacheLookup
	WebElement monthlySalesField;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"less than 2 Lakhs\"]")
	@CacheLookup
	WebElement monthlySalesLessThanTwo;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"2 - 4 Lakhs\"]")
	@CacheLookup
	WebElement monthlySalesTwotoFour;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"4 - 10 Lakhs\"]")
	@CacheLookup
	WebElement monthlySalesFourtoTen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"10 Lakhs +\"]")
	@CacheLookup
	WebElement monthlySalesMoreThanTen;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_gst_yes\"]")
	@CacheLookup
	WebElement gstYesButton;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_gst_no\"]")
	@CacheLookup
	WebElement gstNoButton;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_submit\"]")
	@CacheLookup
	WebElement SubmitButton;
	
	public void EnterMobilefield(String mob) {
		mobileNumberField.sendKeys(mob);
	}
	
	public void SelectMonthlySales() {
		monthlySalesField.click();
	}
	
	public void SelectMonthlySalesLessThanTwo() {
		monthlySalesLessThanTwo.click();
	}
	
	public void SelectMonthlySalesTwotoFour() {
		monthlySalesTwotoFour.click();
	}
	
	public void SelectMonthlySalesFourtoTen() {
		monthlySalesFourtoTen.click();
	}
	
	public void SelectMonthlySalesMoreThanTen() {
		monthlySalesMoreThanTen.click();
	}
	
	public void SelectGSTYes() {
		gstYesButton.click();
	}
	
	public void SelectGSTNo() {
		gstNoButton.click();
	}
	
	public void Submit() {
		SubmitButton.click();
	}

}
