package TestCase;

import java.time.Duration;

import javax.swing.text.Position;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.ClientDetails;
import Utilites.ExtentReport;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;

public class ClientJobApplicationExecuted {
	public static WebDriver driver;
	//ChromeOptions options=new ChromeOptions();
	
	
	@BeforeClass
    @Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws Exception {
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options=new ChromeOptions();
			driver=new ChromeDriver(options);
			System.out.println("chrome is launched");
		}else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			EdgeOptions options=new EdgeOptions();
			driver=new EdgeDriver(options);
			System.out.println("edge is launched");
		}else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			driver=new FirefoxDriver(options);
			System.out.println("firefox is launched");
			
		}else {
		
	            throw new IllegalArgumentException("Invalid browser: " + browser);
	        }
		
		//driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("C:\\Users\\Dell\\OneDrive\\Desktop\\mywebsite\\new 1.html");
		ExtentReport.driver=driver;
		}

	
	@Test(dataProvider = "ClientDetails")
	public void ClientFormDetails(String FN,String LN,String email,String phn,String pos,String StaDate,String UpR,String Addrs1,String Addrs2,String Cty,String state,String Zipcode) throws Exception {
		
		ScreenRecorderUtil.startRecord("ClientFormDetails");
		ClientDetails c=new ClientDetails(driver);
		c.FName(FN);
		c.LName(LN);
		c.EM(email);
		c.PHNo(phn);
		c.selectPosition(pos);
		c.stDate(StaDate);
		c.Stud();
		c.UplF();
		c.UplR(UpR);
		c.Ad1(Addrs1);
		c.Ad2(Addrs2);
		c.City(Cty);
		c.Ste(state);
		c.Zc(Zipcode);
		c.Submit();
		//ScreenRecorderUtil.stopRecord();
		}
@DataProvider(name="ClientDetails")
public Object[][] submissionDetails(){
	return  new Object[][] {
		{"Prachi","Hada","Prachihada@gmail.com","5679084566","Developer","03/10/2025","C:\\Users\\Dell\\Downloads\\Purple and White Clean and Professional Resume (1).pdf","Hayatnagar","Hadafsar","Pune","Maharashtra","123456"}		
		
	};
}
	 @AfterClass
	    public void tearDown() throws Exception {
	        if (driver != null) {
	            driver.quit();
	            ScreenRecorderUtil.stopRecord();
	            
	        }
}
}
