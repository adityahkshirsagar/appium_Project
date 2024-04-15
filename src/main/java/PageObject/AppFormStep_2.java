package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppFormStep_2 {
	
	AppiumDriver ldriver;

	public AppFormStep_2(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(id="com.flexiloan:id/businessPinCode")
	@CacheLookup
	WebElement businessPincode;
	
	@AndroidFindBy(id="com.flexiloan:id/residentialPinCode")
	@CacheLookup
	WebElement residentialPincode;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\"])[1]")
	@CacheLookup
	WebElement residenceOwnershipOwned;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\"])[2]")
	@CacheLookup
	WebElement residenceOwnershipRented;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\"])[3]")
	@CacheLookup
	WebElement businessOwnershipOwned;
	
	@AndroidFindBy(xpath="(//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\"])[4]")
	@CacheLookup
	WebElement businessOwnershipRented;
	
	@AndroidFindBy(id="com.flexiloan:id/otpV_mobile_number")
	@CacheLookup
	WebElement personalPAN;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\" and @text=\"Proprietorship\"]")
	@CacheLookup
	WebElement legal_statusProprietorship;
	
	@AndroidFindBy(id="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\" and @text=\"Partnership\"]")
	@CacheLookup
	WebElement legal_statusPartnership;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\" and @text=\"Private Limited\"]")
	@CacheLookup
	WebElement legal_statusPvtLtd;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\" and @text=\"Public Limited\"]")
	@CacheLookup
	WebElement legal_statusPublicLimited;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.flexiloan:id/tagTextView\" and @text=\"One Person Company (OPC)\"]")
	@CacheLookup
	WebElement legal_statusOPC;
	
	@AndroidFindBy(id="com.flexiloan:id/bt_next")
	@CacheLookup
	WebElement formStep2NextBtn;
	
	
	public void EnterBusinessPincode(String BusinessPincode)
	{
		businessPincode.sendKeys(BusinessPincode);
	}
	
	public void EnterResidentialPincode(String ResidentialPincode)
	{
		residentialPincode.sendKeys(ResidentialPincode);
	}
	
	public void SelectResidentialOwnershipOwned()
	{
		residenceOwnershipOwned.click();
	}
	
	public void SelectResidentialOwnershipRented()
	{
		residenceOwnershipRented.click();
	}
	
	public void SelectBusinessOwnershipOwned()
	{
		businessOwnershipOwned.click();
	}
	
	public void SelectBusinessOwnershipRented()
	{
		businessOwnershipRented.click();
	}
	
	public void EnterPersonalPan(String pan)
	{
		personalPAN.sendKeys(pan);
	}
	
	public void SelectLegalStatusProprietorship()
	{
		legal_statusProprietorship.click();
	}
	
	public void SelectLegalStatusPartnership()
	{
		legal_statusPartnership.click();
	}
	
	public void SelectLegalStatusPvtLtd()
	{
		legal_statusPvtLtd.click();
	}
	
	public void SelectLegalStatusPublicLimited()
	{
		legal_statusPublicLimited.click();
	}
	
	public void SelectLegalStatusOPC()
	{
		legal_statusOPC.click();
	}
	
	public void ClickFormStep2NextBtn() {
		formStep2NextBtn.click();
		
	}

}
