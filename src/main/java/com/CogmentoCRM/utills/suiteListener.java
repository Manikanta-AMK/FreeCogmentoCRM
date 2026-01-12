package com.CogmentoCRM.utills;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import com.CogmentoCRM.base.baseTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class suiteListener extends baseTest implements ITestListener, IAnnotationTransformer{

	  public ExtentTest test;
//	  public ExtentReports extent;
	
	public void onTestFailure(ITestResult result) 
	{
		String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
	    File file = ((TakesScreenshot)baseTest.driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(file, new File(filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void onTestSuccess(ITestResult result) {
		Reporter.log(result.getName()+"method passed",true);
		String filename = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+result.getMethod().getMethodName();
	    File file = ((TakesScreenshot)baseTest.driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(file, new File(filename+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void transform(
		      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
              annotation.setRetryAnalyzer(retryAnalyzer.class);
	}
	
//	public void onTestStart(ITestResult result) {
//		test = extent.createTest(result.getName());
//		test.log(Status.INFO, result.getName() + "method started");
//	}
	
	@Override
	public void onTestStart(ITestResult result) {

//	    if (extent == null) {
//	        throw new RuntimeException("ExtentReports not initialized");
//	    }
//
//	    test = extent.createTest(result.getMethod().getMethodName());
//	    test.log(Status.INFO, "Test started");
	    
	    if (extent == null) {
            ExtentSparkReporter spark = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/ExtentReports/ExtentReport.html");

            extent = new ExtentReports();
            test = extent.createTest(result.getMethod().getMethodName());
    	    test.log(Status.INFO, "Test started");
            extent.attachReporter(spark);
        }
        return;
	    
	    
	    
	}

}
