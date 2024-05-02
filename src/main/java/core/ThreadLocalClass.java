package core;

import com.aventstack.extentreports.ExtentTest;

import core.ExcelUtil;

public class ThreadLocalClass {
	
	public static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	public  static ThreadLocal<ExtentTest> testlevel=new ThreadLocal<>();
	public static  ThreadLocal<ExtentTest> classlevel=new ThreadLocal<>();
	public static  ThreadLocal<ExcelUtil> excelUtil=new ThreadLocal<>();
	public static  ThreadLocal<String> token=new ThreadLocal<>();
	public static ExtentTest gettest() { return test.get();}
	public static void settest(ExtentTest stest) { test.set(stest);}
	
	public static ExcelUtil getexcelUtil() {
		return excelUtil.get(); }

	public static void setexcelUtil(ExcelUtil sexcelUtil) {excelUtil.set(sexcelUtil);

	}
	
	public static ExtentTest gettestlevel()
	{
		return testlevel.get();
	}


	public static void settestlevel(ExtentTest stestlevel)
	{
		testlevel.set(stestlevel);

	}
	
	public static ExtentTest getclasslevel()
	{
		return classlevel.get();
	}


	public  static void setclasslevel(ExtentTest sclasslevel)
	{
		classlevel.set(sclasslevel);
	}
}
