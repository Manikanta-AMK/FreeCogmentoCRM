package utills;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.ITestAnnotation;

import base.baseTest;


public class suiteListener implements ITestListener, IAnnotationTransformer{

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
}
