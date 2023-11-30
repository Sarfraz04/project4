package com.onlinebanking.GenericUtils;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ImplementClass  implements ITestListener{

	

	//ExtentSparkReporter  htmlreport;
		ExtentReports report;
		ExtentTest test;
		
		@Override
		public void onTestStart(ITestResult result) 
		{
			// Starting of report
			String MethodName = result.getMethod().getMethodName();
			test = report.createTest(MethodName);
			Reporter.log(MethodName+"---->Testscript execution starts from here<----");
		}

		@Override
		public void onTestSuccess(ITestResult result) 
		{
			String MethodName = result.getMethod().getMethodName();
			test.log(Status.PASS, MethodName+"--> PASSED");
			Reporter.log(MethodName+"---->Test Script Executed Successfully<----");
		}

		@Override
		public void onTestFailure(ITestResult result) 
		{
			String fs=result.getMethod().getMethodName();
			String FScript = fs+ new JavaUtils().systemDateFormat();
			test.addScreenCaptureFromPath(FScript);
			try {
			WebDriverUtils.getScreenshot(BaseClass.sDriver, FScript);
			}
			catch(Throwable e) {
				e.printStackTrace();
			}
			test.log(Status.FAIL, result.getThrowable());
			test.log(Status.FAIL, FScript+"---> FAILED");
			Reporter.log(FScript+"---->Test Script Failed<----");
		}

		@Override
		public void onTestSkipped(ITestResult result) 
		{
			String MethodName = result.getMethod().getMethodName();
			test.log(Status.SKIP, MethodName+"--SKIPPED");
			test.log(Status.SKIP, result.getThrowable());
			Reporter.log(MethodName+"---->Test Script Skipped<----");
		}

		@Override
		public void onStart(ITestContext context) 
		{
			
			//It is used to create/ configure the report
			ExtentSparkReporter htmlReport=new ExtentSparkReporter("./ExtentReport/report.html");
		//	 Custiomize the extent report
			
			htmlReport.config().setDocumentTitle("SDET-52");
			htmlReport.config().setTheme(Theme.STANDARD);
			htmlReport.config().setReportName("kredVista");
			
			 report = new ExtentReports();
			report.attachReporter(htmlReport);
			report.setSystemInfo("Base-Browser", "chrome");
			report.setSystemInfo("url", "http://rmgtestingserver/domain/Online_Banking_System/");
			report.setSystemInfo("Reporter", "Md Sarfraz alam");
			
		}

		@Override
		public void onFinish(ITestContext context) 
		{
			//consolidate the report/ clean older report
			report.flush();
			
		}
		
	}
	
	


