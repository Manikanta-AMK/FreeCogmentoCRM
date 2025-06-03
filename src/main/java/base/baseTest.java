package base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	public static Logger log;

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
		log.info("cookies deleted");
		driver.manage().window().maximize();
		log.info("Browser maximized");
		driver.get(constants.url);
		log.info("url launched");
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
					MarkupHelper.createLabel(result.getName() + " - Testcase skipped ", ExtentColor.BLUE));
			logger.log(Status.SKIP,
					MarkupHelper.createLabel(result.getThrowable() + " - Testcase skipped ", ExtentColor.BLUE));
		} else {
			logger.log(Status.PASS,
					MarkupHelper.createLabel(result.getName() + " - Testcase passed ", ExtentColor.GREEN));
		}
		driver.quit();
	}

	public void setupDriver(String browserName) {
		
		log = Logger.getLogger("CogmentoCRM");
		 PropertyConfigurator.configure(constants.log4jPath);
		 
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome browser opened");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox browser opened");
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.info("Edge browser opened");
		}
		
	}

}
