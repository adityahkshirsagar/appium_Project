package Flexiloans;


import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObject.AppBankStatement;
import PageObject.AppBusinessKYC;
import PageObject.AppDashboard;
import PageObject.AppDashboard_2;
import PageObject.AppForm2;
import PageObject.AppFormStep_1;
import PageObject.AppFormStep_2;
import PageObject.AppFormStep_3;
import PageObject.AppKYC;
import PageObject.AppLandingPage;
import PageObject.AppLoanAmount;
import PageObject.AppLoanApplicationDashScreen;
import PageObject.AppOfferScreen;
import PageObject.AppRequiredDocument;
import PageObject.AppResidentialAddressProof;
import core.BaseClass;
import core.ListenrClass;
import core.ThreadLocalClass;



@Listeners(ListenrClass.class)
public class PositiveFlow extends BaseClass{
	
	String random4no = randome4Num();
	String randome6no = randome6Num();
	String random9no = randome9Num();
	String random5no= randome5Num();
	String name = randome5string()+" "+ randome5string(); //Enter name
	String ranom5charcters = randome5string();
	String mobile_no = "6" + random9no; 				// Enter Mobile number
	String loan_amount="3" + random5no;					// Enter loan amount
	String monthly_sales = "2" + random5no;					// Enter monthly sales
	String email_id = "A" + randome6no + "@gmail.com";  // Enter email field
	String pan = ranom5charcters + random4no + "A"; // Enter pan number 
 


	
	@Test(priority = 0)
	public void LandingPage()
	{		
		
		AppLandingPage lp=new AppLandingPage(driver);
		
		lp.EnterMobilefield(mobile_no);
		
		ThreadLocalClass.gettestlevel().log(Status.INFO, "Mobile No = "+ mobile_no);
		
		lp.SelectMonthlySales();
		
		lp.SelectMonthlySalesFourtoTen();
		
		lp.SelectGSTYes();
		
		lp.Submit();	
	}
	
	@Test (priority = 1)
	public void Form2() {
		
		AppForm2 form2=new AppForm2(driver);
		
		form2.EnterNameField(name);
		
		form2.EnterEmailfield(email_id);
		
		form2.EnterField1("1");
		
		form2.EnterField2("1");
		
		form2.EnterField3("1");
		
		form2.EnterField4("1");
		
		form2.Form2Submit();
	}
		
		@Test(priority = 2)
		public void Dashboard () throws InterruptedException
		{
			AppDashboard dashboard=new AppDashboard(driver);
		
		// Below if else array handle whatsapp popup	
			if(dashboard.isWhatsappPopupDisplayed())
				{
				  	dashboard.ClickWhatsappSkip();
				  	dashboard.ClickDashboardApplyNow();
				}
			
			else
				{
					System.out.println("Whatsapp popup not shown");
					dashboard.ClickDashboardApplyNow();
					
				}
			
		// Below if else array handle permission1 popup	
			if(dashboard.isPermission1PopupDisplayed())
			{
			  	dashboard.ClickPermissionWhileUsingApp1();
			  	dashboard.ClickPermissionWhileUsingApp2();
			}
			
			else 
			{
				System.out.println("Dashboard done");
				
			}

		}
		
		@Test (priority=3)
		public void LoanAmountScreen()
		{
			AppLoanAmount loanAmount = new AppLoanAmount(driver);
			
			loanAmount.EnterLoanAmount(loan_amount);
			
			System.out.println("Loan amount = "+ loan_amount);
			
			loanAmount.ClickCheckLoanEligibilityBtn();
		}
		
		
		@Test (priority=4)
		public void FormStep_1() throws InterruptedException
		{
			
			AppFormStep_1 formStep1= new AppFormStep_1(driver);
			
			formStep1.SelectGenderMale();
			
			formStep1.SelectDOBField();
			
			int startX = (int) (formStep1.dobYearPicker.getLocation().getX() + formStep1.dobYearPicker.getSize().getWidth()/2);
			
			int startY = (int) (formStep1.dobYearPicker.getLocation().getY() + formStep1.dobYearPicker.getSize().getHeight()*0.60);
			
			String desiredValue = "1996"; // Change this to your desired value
			
			int maxInterations=05;

			int iterationCount=0;
			
			while (iterationCount < maxInterations)
			{
			
			int endX = startX; // Adjust the distance to scroll as needed

			int endY = startY + 300; // Adjust the distance to scroll as needed
		
			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
		        .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), endX, endY))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		    
		    driver.perform(Collections.singletonList(sequence));
		    
		    iterationCount ++;
		    
		    if (driver.getPageSource().contains(desiredValue))
		    	{
		    		break;
		    	}
		    
			}
			
			Thread.sleep(2000);
			
			formStep1.SelectDOB();
						
			formStep1.SelectBusinessAge2to5Years();
			
			formStep1.SelectCurrentAccountYes();
			
			formStep1.SelectGSTRegistrationYes();
			
			formStep1.SelectOccupationBusinessMan();
			
			formStep1.ClickFormStep1NextBtn();
		}
		
		@Test(priority = 5)
		public void FormStep_2()
		{
			AppFormStep_2 formStep2=new AppFormStep_2(driver);
			
			formStep2.EnterBusinessPincode("400016");
			
			formStep2.EnterResidentialPincode("411062");
			
			formStep2.SelectResidentialOwnershipOwned();
			
			formStep2.SelectBusinessOwnershipOwned();
			
			formStep2.EnterPersonalPan(pan);
			
			formStep2.SelectLegalStatusProprietorship();
			
			formStep2.ClickFormStep2NextBtn();
		}
		
		@Test(priority = 6)
		public void FormStep_3() throws InterruptedException
		{
			AppFormStep_3 formStep3=new AppFormStep_3(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			wait.until(ExpectedConditions.visibilityOf(formStep3.natureOfBusinessRetailer));
			
			formStep3.SelectNatureBusinessRetailer();
			
			formStep3.SelectProductListField();
			
			formStep3.SelectProductListSearchField("Dairy");
			
			formStep3.SelectMarkCheckboxForSearchedProduct();
			
			formStep3.SubmitSelectedProduct();
			
			formStep3.EnterBusinessName("RIDEX LUBRICANTS");
			
			formStep3.EnterBusinessAddressLineOne(ranom5charcters);
			
			formStep3.EnterBusinessAddressLineTwo(ranom5charcters);

			Dimension size = driver.manage().window().getSize();

			int startX = size.width / 2;

			int startY = size.height / 2;
			
			int maxInterations=1;

			int iterationCount=0;
			
			while (iterationCount < maxInterations)
			{
			int endY = size.height / 4; 

			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    Sequence sequence = new Sequence(finger1, 1)
		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
		        .addAction(finger1.createPointerMove(Duration.ofMillis(300), PointerInput.Origin.viewport(), startX, endY))
		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		    
		    driver.perform(Collections.singletonList(sequence));
		    
		    iterationCount ++;
		    
			}
			
			formStep3.EnterResidentialAddressLineOne("Test Address");
			
			formStep3.EnterResidentialAddressLineTwo("Test Street");
			
			formStep3.ClickFormStep3NextBtn();
		}
		
		@Test (priority = 7)
		public void OfferScreen() throws InterruptedException
		{
			AppOfferScreen offerscreen=new AppOfferScreen(driver);
			AppDashboard_2 appdashboard_2=new AppDashboard_2(driver);
			
			Thread.sleep(4000);
			
			if(offerscreen.ifOfferDisplayed())
			{
				Thread.sleep(4000);
				offerscreen.SelectAcceptOfferBtn();
			}
			
			else if (appdashboard_2.ifDashboardDisplayed())
			{
				appdashboard_2.ClickLoanApplicationTab();
			}
			
			
		}
		
		
		@Test (priority = 8)
		public void BankStatementUpload() throws InterruptedException
		{
			AppLoanApplicationDashScreen appLoanApplicationDashScreen = new AppLoanApplicationDashScreen(driver);
			AppBankStatement appBankStatement = new AppBankStatement(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			appLoanApplicationDashScreen.ClickBankStatementUpload();
			appBankStatement.ClickBankListDropdown();
			
			appBankStatement.EnterBankNameInSearchBox("HDFC");
			
			appBankStatement.SelectSearchedBank();
			
			appBankStatement.ClickBankStatementDoneBtn();
			
			appBankStatement.ClickSelectedBankNextArrow();
			
			appBankStatement.ClickUploadManualBankStatement();
			
			appBankStatement.SelectFileToUploadDoc();
			
			appBankStatement.SelectSearchOptioninDeviceStorage();
			
			appBankStatement.EnterSearchKeywordForDocument("Bank Statement");
			
			Thread.sleep(20000);
			
			driver.navigate().back();
			
			wait.until(ExpectedConditions.visibilityOf(appBankStatement.bankStatementFromLocalStorage));
			
			appBankStatement.SelectBankStatementFromLocalStorage();
			
			appBankStatement.ClickBankStatementSubmit();
			
			wait.until(ExpectedConditions.elementToBeClickable(appBankStatement.addMoreBanksOption));
			
			driver.navigate().back();
			
			wait.until(ExpectedConditions.visibilityOf(appLoanApplicationDashScreen.bankingCompleteTick));
			
			System.out.println("Bank statement uploaded successfully");
			
				
		}
		
		@Test (priority = 9)
		public void DocumentUpload()
		{
			AppLoanApplicationDashScreen appLoanApplicationDashScreen = new AppLoanApplicationDashScreen(driver);
			AppRequiredDocument appRequiredDocument = new AppRequiredDocument(driver);
			AppBankStatement appBankStatement = new AppBankStatement(driver); 
			AppBusinessKYC appBusinessKYC=new AppBusinessKYC(driver);
			AppResidentialAddressProof appResidentialAddressProof=new AppResidentialAddressProof(driver);
			AppKYC appkyc=new AppKYC(driver);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			appLoanApplicationDashScreen.ClickDocumentsAddMore();
			
			appRequiredDocument.ClickBusinessKYC();
			
			wait.until(ExpectedConditions.visibilityOf(appBusinessKYC.businessKYCdocDropdown));
			
			appBusinessKYC.SelectBusinessKYCDropdown();
			
			appBusinessKYC.ClickGSTcertificateCheckbox();
			
			appBusinessKYC.ClickGSTcertificateUpload();
			
			appBankStatement.SelectCameraToUploadDoc();
			
			appBankStatement.ClickCameraFlipForDoc();
			
			appBankStatement.ClickCameraCaptureForDoc();
			
			appBankStatement.ClickConfirmForClickedImage();
			
			appBankStatement.ClickConfirmForClickedImage2();
			
			appBusinessKYC.ClickSubmitForUploadedDocs();
			
			wait.until(ExpectedConditions.visibilityOf(appRequiredDocument.receivedMessageForBusinessKYC));
			
			System.out.println("Business KYC Uploaded successfully");
			
//			-----------------------------------------------------------------------------
			
			wait.until(ExpectedConditions.visibilityOf(appRequiredDocument.docKYC));
			
			appRequiredDocument.ClickKYC();
			
			appkyc.SelectKYCDropdown();
			
			appkyc.SelectPANCheckbox();
			
			appkyc.SelectPANUpload();
			
			appkyc.cameraOptionToUpalodDoc.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(appkyc.cameraCaptureToUpalodDoc));
			
			appkyc.cameraCaptureToUpalodDoc.click();
			
			appkyc.confirmToCapturedImageToUpalodDoc.click();
			
			appkyc.confirmToCapturedImageToUpalodDoc2.click();
			
			appkyc.submitForUploadedDoc.click();
			
			wait.until(ExpectedConditions.visibilityOf(appRequiredDocument.receivedMessageForKYC));
			
			System.out.println("Pesonal KYC Uploaded successfully");
			
//			-----------------------------------------------------------------------	
			
			appRequiredDocument.ClickResidentialAddressProof();
			
			appResidentialAddressProof.residentialAddProofdocDropdown.click();
			
			appResidentialAddressProof.aadharCheckbox.click();
			
			appResidentialAddressProof.aadharUpload.click();
			
			appResidentialAddressProof.cameraOptionToUpalodDoc.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(appResidentialAddressProof.cameraCaptureToUpalodDoc));			
			
			appResidentialAddressProof.cameraCaptureToUpalodDoc.click();
			
			appResidentialAddressProof.confirmToCapturedImageToUpalodDoc.click();
			
			appResidentialAddressProof.confirmToCapturedImageToUpalodDoc2.click();
			
			appResidentialAddressProof.submitForUploadedDoc.click();
			
			wait.until(ExpectedConditions.visibilityOf(appRequiredDocument.receivedMessageForResidentialAddressProof));
			
			System.out.println("Residential Address Proof Uploaded successfully");

//			-------------------------------------------------------------------------			
			
			
			driver.navigate().back();
			
			wait.until(ExpectedConditions.visibilityOf(appLoanApplicationDashScreen.documentCompleteTick));
			
			System.out.println("-------- Loan Application Completed Successfully -----------");
		}	
}
