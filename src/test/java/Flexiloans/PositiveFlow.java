package Flexiloans;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import PageObject.AppDashboard;
import PageObject.AppForm2;
import PageObject.AppFormStep_1;
import PageObject.AppFormStep_2;
import PageObject.AppLandingPage;
import PageObject.AppLoanAmount;
import core.BaseClass;
import core.ListenrClass;


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
	AppDashboard dashboard = new AppDashboard(driver);

	
	
	@Test (priority = 0)
	public void landingPage()
	{
	//	reportUtil.intialLogForTest(TCID);
		
		AppLandingPage lp=new AppLandingPage(driver);
		
		lp.EnterMobilefield(mobile_no);
		
		System.out.println("Mobile No = "+ mobile_no);
		
		lp.SelectMonthlySales();
		
		lp.SelectMonthlySalesFourtoTen();
		
		lp.SelectGSTYes();
		
		lp.Submit();	
	}
	
	@Test (priority = 1)
	public void form2() {
		
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
			
			formStep1.SelectDOBField1("20/03/1997");
			
//			formStep1.SelectDOBField();
			
			List<WebElement> listOfElements = driver.findElements(By.xpath("//android.view.View[@resource-id=\"com.flexiloan:id/picker_day\"]"));
						
			System.out.println("list= "+listOfElements);
			
//			--------------------------------------------------------
			
//			WebElement DOB_Element = driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.flexiloan:id/picker_day\"]"));
//			
//			int startX = DOB_Element.getLocation().getX() + DOB_Element.getSize().getWidth() / 3;
//
//			int startY = DOB_Element.getLocation().getY() + DOB_Element.getSize().getHeight() / 2;
//
//			int endY = startY - 200; // Adjust the distance to scroll as needed
//			
//			Actions actions=new Actions(driver);
//			
//			actions.moveToElement(DOB_Element, startX, endY).clickAndHold().moveByOffset(0, -endY).release().perform();
//			

//			PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
//		    Sequence sequence = new Sequence(finger1, 1)
//		        .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
//		        .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
//		        .addAction(new Pause(finger1, Duration.ofMillis(200)))
//		        .addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
//		        .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
//		    
//		    driver.perform(Collections.singletonList(sequence));
			
			
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
			
			formStep2.EnterBusinessPincode(randome6no);
			
			formStep2.EnterResidentialPincode(randome6no);
			
			formStep2.SelectResidentialOwnershipOwned();
			
			formStep2.SelectBusinessOwnershipOwned();
			
			formStep2.EnterPersonalPan(pan);
			
			formStep2.SelectLegalStatusProprietorship();
			
			formStep2.ClickFormStep2NextBtn();
		}
		
		
	
}
