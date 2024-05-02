package PageObject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppDashboard_2 {
	
	AppiumDriver ldriver;

	public AppDashboard_2(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.flexiloan:id/tab_application\"]")
	@CacheLookup
	WebElement dashboardLoanApplication;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.flexiloan:id/tab_loan_offer\"]")
	@CacheLookup
	WebElement dashboardLoanOffer;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.flexiloan:id/tab_post_loan_offer\"]")
	@CacheLookup
	WebElement dashboardLoanFormalities;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@resource-id=\"com.flexiloan:id/tab_disbursment\"]")
	@CacheLookup
	WebElement dashboardDisbursement;
	
//	------------------------------------------------------
	
	public boolean ifDashboardDisplayed() {
		try {
			return
					dashboardLoanApplication.isDisplayed();
		}
		catch (NoSuchElementException e)
	
		{
			return false;
		}
	}
	
	
	
	public void ClickLoanApplicationTab()
	{
		dashboardLoanApplication.click();
	}
	
	public void ClickLoanOfferTab()
	{
		dashboardLoanOffer.click();
	}
	
	public void ClickLoanFormalitiesTab()
	{
		dashboardLoanFormalities.click();
	}
	
	public void ClickLoanDisbursementTab()
	{
		dashboardDisbursement.click();
	}
	
}
