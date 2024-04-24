//package core;
//	
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.checkerframework.common.reflection.qual.GetMethod;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import core.BaseClass;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//
//	public class ReportUtility extends BaseClass implements ITestListener {
//		
//		public ExtentSparkReporter htmlReporter;
//    	public ExtentReports extent;
//    	public ExtentTest logger;
//
//	    public ExtentTest intialLogForTest(String testCaseName)
//	    {
//	        ExcelUtil excelUtil = ThreadLocalClass.getexcelUtil();
//	        excelUtil.initSheet(ExcelUtil.INTIAL_TESTSCRIPT_REPORT_LOG_SHEET);
//	        ExtentTest test= ThreadLocalClass.gettestlevel();
//	        test.log(Status.INFO, "Description :- "+excelUtil.getExcelDataForSingleRow(testCaseName, "TC Description"));
//	        test.log(Status.INFO, "TestcaseType :- "+excelUtil.getExcelDataForSingleRow(testCaseName,"TC Type"));
//	        test.addScreenCaptureFromPath(testCaseName, testCaseName);
//	        return test;
//	    }
//	    
////	    public ExtentTest logScreenshot(String picname)
////	    {	
////	    	ExtentTest test= ThreadLocalClass.gettestlevel();
////	    	test.addScreenCaptureFromPath((FilePaths.SCREENSHOTS + picname + ".png"), "Screenshot");
////	    	return test;
////
////	    }
//	    
//	   
//	    	public void onStart(ITestContext testContext)
//	    	{
//	    		String timeStamp = new SimpleDateFormat("dd:MM:yyyy HH:mm").format(new Date());//time stamp
//	    		String repName="Test-Report-"+timeStamp+".html";
//
//	    		htmlReporter=new ExtentSparkReporter(FilePaths.EXTENT_REPORT+repName);//specify location of the report
//	    		
//	    		try 
//	    		{
//	    			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
//	    		} 
//	    		catch (IOException e) 
//	    		{
//	    		
//	    			e.printStackTrace();
//	    		}
//	    		
//	    		extent=new ExtentReports();
//	    		
//	    		extent.attachReporter(htmlReporter);
//	    		extent.setSystemInfo("Host name","localhost");
//	    		extent.setSystemInfo("Environemnt","Staging-QA");
//	    		extent.setSystemInfo("user","Aditya");
//	    		
//	    		
//
//	    		htmlReporter.config().setDocumentTitle("Mobile Automation Test Report"); // Tile of report
//	    		htmlReporter.config().setReportName(timeStamp); // name of the report
////	    		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
//	    		htmlReporter.config().setTheme(Theme.STANDARD);
//	    	}
//
//	    	public void onTestSuccess(ITestResult tr)
//	    	{
//	    		logger=extent.createTest(tr.getName()); // create new entry in the report
//	    		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
//	    				
//	    		
//	    	}
//	    	
//	    	public void onTestFailure(ITestResult tr)
//	    	{
//	    		String ScrDir=FilePaths.SCREENSHOTS;
//	    		
//	    		logger=extent.createTest(tr.getName()); // create new entry in the report
//	    		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the failed information to the report with GREEN color highlighted
//	    		
//	    		logger.addScreenCaptureFromPath(ScrDir+tr.getName()+".png");
//	    		
//	    		try 
//	    		{
//	    			captureScreen(tr.getName());
//	    		} 
//	    		
//	    		catch (IOException e) 
//	    		{
//	    			
//	    			e.printStackTrace();
//	    		}
//	    		
//	    	}
//
//	    	public void onTestSkipped(ITestResult tr)
//	    	{
//	    		logger=extent.createTest(tr.getName()); // create new entry in th report
//	    		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
//	    	}
//
//	    	
//
//	    	public void onFinish(ITestContext testContext)
//	    	{
//	    		extent.flush();
//	    	}
//	}
