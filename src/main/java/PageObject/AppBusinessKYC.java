package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppBusinessKYC {
	
	AppiumDriver ldriver;

	public AppBusinessKYC(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_select_doc_type\"]")
	@CacheLookup
	public WebElement businessKYCdocDropdown;
	
	@AndroidFindBy(xpath="(//android.widget.RadioButton[@resource-id=\"com.flexiloan:id/radio\"])[1]")
	@CacheLookup
	WebElement GSTcertificateCheckbox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_connect\"]")
	@CacheLookup
	WebElement GSTcertificateUpload;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/btn_submit\"]")
	@CacheLookup
	WebElement submitForUploadedDoc;
	
	
//	-------------------------------------------------------------------
	
	public void SelectBusinessKYCDropdown()
	{
		businessKYCdocDropdown.click();
	}
	
	public void ClickGSTcertificateCheckbox()
	{
		GSTcertificateCheckbox.click();
	}
	
	public void ClickGSTcertificateUpload()
	{
		GSTcertificateUpload.click();
	}
	
	public void ClickSubmitForUploadedDocs()
	{
		submitForUploadedDoc.click();
	}

}
