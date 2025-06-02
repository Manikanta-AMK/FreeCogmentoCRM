package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;
import utills.constants;

public class baseTest {

	public ExtentReports extent;
	public ExtentTest logger;
	public ExtentSparkReporter sparkReporter;
	public static WebDriver driver;

	@BeforeTest
	public void extentReportMethod() {
		sparkReporter = new ExtentSparkReporter(
				"C:\\Users\\phani\\eclipse-workspace\\FreeCogmentoCRM\\ExtentReports\\Extentreport.html");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setDocumentTitle("FreeCogmentoCRM");
		sparkReporter.config().setReportName("Automation Test Result Report");
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Author", "AMK");
		extent.setSystemInfo("Os", "windows 11");
		extent.setSystemInfo("Browser", "Chrome");
	}

	@BeforeMethod
	@Parameters("browser")
	public void initialization(String browser, Method testmethod) {
		logger = extent.createTest(testmethod.getName());
		setupDriver(browser);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(constants.url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterTest
	public void onFinish(ITestContext context) {
		extent.flush();
	}

	@AfterMethod
	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getName() + " - Testcase failed ", ExtentColor.RED));
			logger.log(Status.FAIL,
					MarkupHelper.createLabel(result.getThrowable() + " - Testcase failed ", ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getName() + " - Testcase failed ", ExtentColor.BLUE));
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Testcase failed ", ExtentColor.BLUE));
		} else {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Testcase failed ", ExtentColor.GREEN));
		}
		driver.quit();
	}

	public void setupDriver(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
	}

}
