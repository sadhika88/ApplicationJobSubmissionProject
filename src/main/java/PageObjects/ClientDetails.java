package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClientDetails {
	WebDriver driver;
	public ClientDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(id = "firstName")WebElement fname;
	@FindBy(id = "lastName")WebElement lname;
	@FindBy(id = "email")WebElement em;
	@FindBy(id = "phone")WebElement ph;
	@FindBy(id = "position")WebElement posn;
	@FindBy(xpath ="/html[1]/body[1]/div[1]/form[1]/input[5]")WebElement SD;
	@FindBy(id = "student")WebElement stdnt;
	@FindBy(id = "uploadFile")WebElement UPF;
	@FindBy(id = "resume")WebElement UPlResume;
	@FindBy(id = "streetAddress")WebElement Add1;
	@FindBy(id = "streetAddress2")WebElement Add2;
	@FindBy(id = "city")WebElement cty;
	@FindBy(id = "state")WebElement State;
	@FindBy(id = "zipCode")WebElement Zc;
	@FindBy(xpath = "//*[@type='submit']")WebElement sb;
	
	public void FName(String FN) {
		fname.sendKeys(FN);
		
	}
	public void LName(String LN) {
		lname.sendKeys(LN);
		
	}
	public void EM(String email) {
		em.sendKeys(email);
		
	}
	public void PHNo(String phn) {
		ph.sendKeys(phn);
		
	}
	public void selectPosition(String pos) {
		Select c=new Select(posn);
		c.selectByVisibleText(pos);
		
	}
	public void stDate(String StaDate) {
		SD.sendKeys(StaDate);
		
	}
	public void Stud() {
		stdnt.click();;
		
	}
	public void UplF() {
		UPF.click();
		
	}
	public void UplR(String UpR) {
		UPlResume.sendKeys(UpR);
		
	}
	public void Ad1(String Addrs1) {
		Add1.sendKeys(Addrs1);
		
	}
	public void Ad2(String Addrs2) {
		Add2.sendKeys(Addrs2);
		
	}
	public void City(String Cty) {
		cty.sendKeys(Cty);
	}
	public void Ste(String state) {
		State.sendKeys(state);
		
	}
	public void Zc(String Zipcode) {
		Zc.sendKeys(Zipcode);
		
	}
	public void Submit() {
		sb.click();
	}
}
