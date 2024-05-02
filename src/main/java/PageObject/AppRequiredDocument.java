package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppRequiredDocument {
	
	AppiumDriver ldriver;

	public AppRequiredDocument(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_loan_offer\" and @text=\"Business KYC\"]")
	@CacheLookup
	WebElement docBusinessKYC;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_loan_offer\" and @text=\"KYC\"]")
	@CacheLookup
	public WebElement docKYC;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tv_loan_offer\" and @text=\"Residential Address Proof\"]")
	@CacheLookup
	WebElement docResidentialAddressProof;
	
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/status\" and @text=\"Received\"]")
	@CacheLookup
	public WebElement receivedMessageForBusinessKYC;
	
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/status\"])[2]")
	@CacheLookup
	public WebElement receivedMessageForKYC;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/status\"])[3]")
	@CacheLookup
	public WebElement receivedMessageForResidentialAddressProof;

	
	
	
//	-------------------------------------------------------------------
	
	public void ClickBusinessKYC()
	{
		docBusinessKYC.click();
	}
	
	public void ClickKYC()
	{
		docKYC.click();
	}
	
	public void ClickResidentialAddressProof()
	{
		docResidentialAddressProof.click();
	}

}
