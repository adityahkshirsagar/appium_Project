package core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import core.ThreadLocalClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class BaseClass {
	
//	public Databaseutil databaseutil=new Databaseutil();
//	public ReportUtility reportUtil=new ReportUtility();
	public ExcelUtil excelUtil=new ExcelUtil();
	public static AppiumDriver driver;
	public AppiumDriverLocalService service;
	
	
	protected String TCID;

	
	@BeforeClass(alwaysRun = true)
	public void setup() {
		
//		service=new AppiumServiceBuilder().withAppiumJS(new File ("/Users/opt/homebrew/lib/node_modules/appium/build/lib/main.js"))
//		.usingDriverExecutable(new File ("/opt/homebrew/bin/node"))
//		.withIPAddress("127.0.0.1")
//		.usingPort(4723)
//		.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
//		.build();
//		
//		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		
//		options.setPlatformName("Android");
//		options.setPlatformVersion("13");
//		options.setDeviceName("Pixel 2 XL API 33");
//		options.setApp("/Users/fllap0470/Downloads/app-universal-staging.apk");
//		options.setAutomationName("UiAutomator2");
//		options.setEnsureWebviewsHavePages(true);
//		options.setNativeWebScreenshot(true);
		
		options.setPlatformName("Android");
		options.setPlatformVersion("12");
		options.setDeviceName("Galaxy M21");
		options.setUdid("RZ8NA0YN0FT");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.flexiloan");
		options.setAppActivity("com.flexiloan.Activity.Registration.SplashActivity");
		options.setEnsureWebviewsHavePages(true);
		options.setNativeWebScreenshot(true);
		
		try {
			driver=new AppiumDriver((new URL("http://127.0.0.1:4723")),options);
		} catch (MalformedURLException e) {
	        e.printStackTrace();
	      }		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ThreadLocalClass.setexcelUtil(excelUtil);
		excelUtil.openExcelFile(FilePaths.APPIUM_DDT_EXCEL);
	}
	
	@BeforeMethod(alwaysRun = true)

	public void checkingToken(Method mtd) throws Exception {
		 TCID=mtd.getDeclaringClass().getSimpleName()+"_"+mtd.getName();
		//System.out.println(ThreadLocalclass.gettoken());
		 }
	
	public String captureScreen(String picname) throws IOException {
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

//		String target = ("/Users/fllap0470/eclipse-workspace/Appium_Test/Screenshots/" + picname + ".png");
		String target = (FilePaths.SCREENSHOTS + picname + ".png");

		File destination = new File(target);

		FileUtils.copyFile(source, destination);

		System.out.println("Screenshot Taken");

		return target;
	}
	
		
//	@AfterClass
//	  public void tearDown() {
//	    driver.quit(); 
//	    service.stop();
//	  }
	
	public String randome10string() {
		String generatedstring = RandomStringUtils.randomAlphabetic(10);
		return (generatedstring);
	}

	public String randome5string() {
		String generatedstring1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedstring1);
	}

	public static String randome4Num() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}

	public static String randome9Num() {
		String generatedString3 = RandomStringUtils.randomNumeric(9);
		return (generatedString3);
	}

	public static String randome6Num() {
		String generatedString4 = RandomStringUtils.randomNumeric(6);
		return (generatedString4);
	}
	
	public static String randome5Num() {
		String generatedString5 = RandomStringUtils.randomNumeric(5);
		return (generatedString5);
	}
}