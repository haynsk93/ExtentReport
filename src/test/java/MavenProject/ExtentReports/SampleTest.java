package MavenProject.ExtentReports;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import junit.framework.Assert;

public class SampleTest {
	ExtentReports extent;
@Test
public void test1() {
	ExtentTest test=extent.createTest("test1"); //to tell that a test is going to happen
	System.setProperty("webdriver.edge.driver", "C:\\Selenium\\Udemy\\edgedriver_win64 (1)\\msedgedriver.exe");
	WebDriver driver = new EdgeDriver();
	test.log(Status.INFO, "Starting");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.flipkart.com/mobiles/pr?sid=tyy%2C4io&p%5B%5D=facets.brand%255B%255D%3DSAMSUNG&otracker=clp_metro_expandable_6_3.metroExpandable.METRO_EXPANDABLE_Shop%2BNow_mobile-phones-store_Q0QIS4SPJNLH_wp3&fm=neo%2Fmerchandising&iid=M_2a40aaff-122b-48f9-a099-d2e457903dd6_3.Q0QIS4SPJNLH&ppt=hp&ppn=homepage&ssid=p3dj7dmycw0000001644903391439");
	test.log(Status.INFO, "Opening page");
	System.out.println(driver.getTitle());
//Assert.assertTrue(false); // if you give this, extent.flush is not executed, then no reports are prepared, then add it in after test.
//test.log(Status.FAIL, "explicitely failed"); //this will show test as failed eventhough its not failed
//test.fail("Explicitly failed by the user");
	test.log(Status.PASS, "Pass");
extent.flush(); // to tell that test is over. it can be added at end of  test
driver.quit();
}
@Test
public void demo() {
	ExtentTest test=extent.createTest("test1");
	System.out.println("this test is made for practising git");
	test.log(Status.PASS, "This project is take from git, initialy made in udemy workspace, this method"
			+ "is added in Nikul worspace and push to GIT");
	extent.flush();
	
}
@BeforeTest
public void config() {
	String path=System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter=new ExtentSparkReporter(path); //spark reporter is free. other reporters are paid
	reporter.config().setReportName("Reprt Name");
	reporter.config().setDocumentTitle("Project Name");
	reporter.config().setTheme(Theme.DARK);
	
	
	
	 extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Hayns Kurian");
	extent.setSystemInfo("Platform", "Windows 10");
}


}
