package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppResidentialAddressProof {
	
	AppiumDriver ldriver;

	public AppResidentialAddressProof(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_select_doc_type\"]")
	@CacheLookup
	public WebElement residentialAddProofdocDropdown;
	
	@AndroidFindBy(xpath="(//android.widget.RadioButton[@resource-id=\"com.flexiloan:id/radio\"])[1]")
	@CacheLookup
	public WebElement aadharCheckbox;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_connect\"]")
	@CacheLookup
	public WebElement aadharUpload;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text=\"Camera\"]")
	@CacheLookup
	public WebElement cameraOptionToUpalodDoc;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/captureBtn\"]")
	@CacheLookup
	public WebElement cameraCaptureToUpalodDoc;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/confirmImgBtn\"]")
	@CacheLookup
	public WebElement confirmToCapturedImageToUpalodDoc;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/btn_done\"]")
	@CacheLookup
	public WebElement confirmToCapturedImageToUpalodDoc2;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/btn_submit\"]")
	@CacheLookup
	public WebElement submitForUploadedDoc;
	
//	-------------------------------------------------
	
//	public void ClickBankListDropdown()
//	{
//		selectBankDropdown.click();
//	}

}
