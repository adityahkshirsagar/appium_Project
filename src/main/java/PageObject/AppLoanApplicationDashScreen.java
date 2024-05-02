package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppLoanApplicationDashScreen {
	
	AppiumDriver ldriver;

	public AppLoanApplicationDashScreen(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Preview\"]")
	@CacheLookup
	WebElement applicationFormPreview;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_upload_statment\"]")
	@CacheLookup
	WebElement bankStatementUpload;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@text=\"Add More\"])[2]")
	@CacheLookup
	WebElement documentAddMore;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"com.flexiloan:id/iv_banking_complete\"]")
	@CacheLookup
	public WebElement bankingCompleteTick;
	
	@AndroidFindBy(xpath="//android.widget.ImageView[@resource-id=\"com.flexiloan:id/iv_banking_complete\"]")
	@CacheLookup
	public WebElement documentCompleteTick;
	
	
// -----------------------------------------------------------
	
	public void ClickApplicationFormPreview()
	{
		applicationFormPreview.click();
	}
	
	public void ClickBankStatementUpload()
	{
		bankStatementUpload.click();
	}
	
	public void ClickDocumentsAddMore()
	{
		documentAddMore.click();
	}

}
