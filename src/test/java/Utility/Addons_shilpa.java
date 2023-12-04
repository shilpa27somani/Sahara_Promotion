package Utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Addons_shilpa {
	
	private GenericUtility gu = new GenericUtility();
	private WebDriver driver;
	private ConfigReader cr = new ConfigReader();
	private Properties prop;

	@BeforeSuite
	public void getProperty() {
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
	}	
	
@BeforeMethod
	public void SetUp () throws InterruptedException {
		
		ArrayList<String> randomDates = GenericUtility.SingleNight_SingleRoom_randomCheckInOutMonthYearDate();
		String CheckinMonthandYear = randomDates.get(0);
		String CheckinDate = randomDates.get(1);
		String CheckOutMonthYear = randomDates.get(2);
		String CheckOutDate = randomDates.get(3);
		String API_CheckInDate = randomDates.get(4);
		String API_CheckOutDate = randomDates.get(5);
		String No_of_Booking_Days = randomDates.get(6);
		String API_Checkindate_plus1_=randomDates.get(7); 
		driver = gu.setup("chrome", prop.getProperty("URL"));
		gu.LogPrinter("URL Launched successfully");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	     
	        
	    try {
	    WebElement BookBtn=driver.findElement(By.xpath("//button[@class=\"bkrm tabBtnNone m-md-0 notranslate\"]"));
	    gu.ClickByJS(driver, BookBtn);
	        }
	        catch(Exception e) {
	        	 gu.LogPrinter("Rooms not available for Booking ");
		            gu.LogPrinter("");
					gu.LogPrinter("");
		            driver.close();	
		            return;
	        }  
	        WebElement CompleteBookingBtn = driver.findElement(By.xpath("//button[@class=\"sr-sbmt\" and text()=\"Complete Booking\"]"));
			gu.ClickByJS(driver, CompleteBookingBtn);
	      }
	@Test( priority=0)
	public void AddOns_Recuring_perRoom_perday() throws InterruptedException {
		
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@id=\"f_0_0\"]"));
		FirstName.sendKeys(prop.getProperty("FirstNameGuest1"));
		gu.LogPrinter("First Name of Guest :-" + prop.getProperty("FirstNameGuest1"));
		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
		LastName.sendKeys(prop.getProperty("LastNameGuest1"));
		Thread.sleep(1000);
		gu.LogPrinter("Last Name of Guest  :-" + prop.getProperty("LastNameGuest1"));							
		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		MobileNo.sendKeys(prop.getProperty("MobileNumber1"));
		gu.LogPrinter("Contact no of Guest :-" + prop.getProperty("MobileNumber1"));
		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		MailId.sendKeys(prop.getProperty("MailID1"));
		gu.LogPrinter("Mail id of Guest    :-" + prop.getProperty("MailID1"));
		
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
        WebElement Addon1 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[1]"));
        gu.ClickByJS(driver, Addon1);
        driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
 	    driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();
 	    WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
		gu.ClickByJS(driver, ConfirmBookingBtn);
	}
	
	@Test(priority=1)
	public void Addons_Recuring_perroom_perguest () throws InterruptedException {
		
			WebElement FirstName = driver.findElement(By.xpath("//input[@id=\"f_0_0\"]"));
			FirstName.sendKeys(prop.getProperty("FirstNameGuest1"));
			gu.LogPrinter("First Name of Guest :-" + prop.getProperty("FirstNameGuest1"));
			WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
			LastName.sendKeys(prop.getProperty("LastNameGuest1"));
			Thread.sleep(1000);
			gu.LogPrinter("Last Name of Guest  :-" + prop.getProperty("LastNameGuest1"));							
			WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
			MobileNo.sendKeys(prop.getProperty("MobileNumber1"));
			gu.LogPrinter("Contact no of Guest :-" + prop.getProperty("MobileNumber1"));
			WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
			MailId.sendKeys(prop.getProperty("MailID1"));
			gu.LogPrinter("Mail id of Guest    :-" + prop.getProperty("MailID1"));
			WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
			gu.ClickByJS(driver, ConfirmBookingBtn);
		
			
			   JavascriptExecutor js = (JavascriptExecutor) driver;
			   js.executeScript("window.scrollBy(0,500)");
	        WebElement Addon2 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[2]"));
	        gu.ClickByJS(driver, Addon2);
	        driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
	 	   driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();

		}
	 
		
	
	
	@Test(priority=2)
	public void Addons_one_off_perGust () throws InterruptedException {
		WebElement FirstName = driver.findElement(By.xpath("//input[@id=\"f_0_0\"]"));
		FirstName.sendKeys(prop.getProperty("FirstNameGuest1"));
		gu.LogPrinter("First Name of Guest :-" + prop.getProperty("FirstNameGuest1"));
		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
		LastName.sendKeys(prop.getProperty("LastNameGuest1"));
		Thread.sleep(1000);
		
		gu.LogPrinter("Last Name of Guest  :-" + prop.getProperty("LastNameGuest1"));							
		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		MobileNo.sendKeys(prop.getProperty("MobileNumber1"));
		gu.LogPrinter("Contact no of Guest :-" + prop.getProperty("MobileNumber1"));
		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		MailId.sendKeys(prop.getProperty("MailID1"));
		gu.LogPrinter("Mail id of Guest    :-" + prop.getProperty("MailID1"));
		WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
		gu.ClickByJS(driver, ConfirmBookingBtn);
		
		
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,500)");
        WebElement Addon3 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[3]"));
        gu.ClickByJS(driver, Addon3);
        driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
 	   driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();

	     
		
	}
	
	@Test(priority=3)
	public void Addons_one_off_perItem () throws InterruptedException {
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@id=\"f_0_0\"]"));
		FirstName.sendKeys(prop.getProperty("FirstNameGuest1"));
		gu.LogPrinter("First Name of Guest :-" + prop.getProperty("FirstNameGuest1"));
		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
		LastName.sendKeys(prop.getProperty("LastNameGuest1"));
		Thread.sleep(1000);
		gu.LogPrinter("Last Name of Guest  :-" + prop.getProperty("LastNameGuest1"));							
		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		MobileNo.sendKeys(prop.getProperty("MobileNumber1"));
		gu.LogPrinter("Contact no of Guest :-" + prop.getProperty("MobileNumber1"));
		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		MailId.sendKeys(prop.getProperty("MailID1"));
		gu.LogPrinter("Mail id of Guest    :-" + prop.getProperty("MailID1"));
		WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
		gu.ClickByJS(driver, ConfirmBookingBtn);
		
		
		   JavascriptExecutor js = (JavascriptExecutor) driver;
		   js.executeScript("window.scrollBy(0,500)");
        WebElement Addon4 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[4]"));
        gu.ClickByJS(driver, Addon4);
        driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
 	   driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();

		
	}
	
 @AfterMethod
	
public void Payment_getway () throws InterruptedException {

			
WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
Credit_Card_No.sendKeys(prop.getProperty("CreditCardNumber"));
//*[@id="cc_name"]
driver.findElement(By.xpath("//*[@id=\"cc_name\"]")).sendKeys("shilpa somani");		
WebElement ExpiryDateMM=driver.findElement(By.xpath("//i[@class=\"fa-solid fa-angle-down\"]"));
gu.ClickByJS(driver, ExpiryDateMM);
WebElement ExpiryMonth=driver.findElement(By.xpath("//li[@id=\"MM6\"]"));
gu.ClickByJS(driver, ExpiryMonth);
			
WebElement ExpiryYear=driver.findElement(By.xpath("(//i[@class=\"fa-solid fa-angle-down\"])[2]"));
gu.ClickByJS(driver, ExpiryYear);
WebElement ExpYear=driver.findElement(By.xpath("//li[@id=\"2028\"]"));
gu.ClickByJS(driver, ExpYear);
WebElement CVV=driver.findElement(By.xpath("//input[@placeholder=\"CVV\"]"));
CVV.sendKeys("123");
WebElement ConfirmBtnCredit=driver.findElement(By.xpath("//button[@id=\"btn1\"]"));
gu.ClickByJS(driver, ConfirmBtnCredit);
			
		
	}

}
