package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppForm2 {
	
	AppiumDriver ldriver;

	public AppForm2(AppiumDriver rdriver)
	{
		ldriver=rdriver;		
		PageFactory.initElements(new AppiumFieldDecorator(rdriver), this);
	}
	
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_name\"]")
	@CacheLookup
	WebElement nameField;

	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_email\"]")
	@CacheLookup
	WebElement emailField;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_otp_1\"]")
	@CacheLookup
	WebElement otpField1;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_otp_2\"]")
	@CacheLookup
	WebElement otpField2;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_otp_3\"]")
	@CacheLookup
	WebElement otpField3;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.flexiloan:id/et_otp_4\"]")
	@CacheLookup
	WebElement otpField4;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.flexiloan:id/bt_submit\"]")
	WebElement form2submit;
	
	
	public void EnterNameField(String name) {
	nameField.sendKeys(name);
	}
	
	public void EnterEmailfield(String email) {
	emailField.sendKeys(email);
	}
	
	public void EnterField1(String otp1) {
	otpField1.sendKeys(otp1);
	}
		
	public void EnterField2(String otp2) {
	otpField2.sendKeys(otp2);
	}
			
	public void EnterField3(String otp3) {
	otpField3.sendKeys(otp3);
	}
	
	public void EnterField4(String otp4) {
	otpField4.sendKeys(otp4);
	}
	
	public void Form2Submit() {
	form2submit.click();
	}
			
}

