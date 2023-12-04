package NewSahara;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.ConfigReader;
import Utility.GenericUtility;

public class Different_NightAndRoomCombitions {


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
		driver = gu.setup("chrome", prop.getProperty("URL1"));
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
	    WebElement StartDateInputField = driver.findElement(By.xpath("//div[@id='start-Date-Input']"));
        gu.ClickByJS(driver, StartDateInputField);
        // StartDateInputField.click();
        gu.ScrollByDpwnarrow(driver, 2);
	    // gu.CheckINOUTDateProvider(driver, CheckinMonthandYear, CheckinDate, CheckOutMonthYear, CheckOutDate);
	    gu.CheckINOUTDateProvider(driver, CheckinMonthandYear, CheckinDate, CheckOutMonthYear, CheckOutDate);
	    
	     }
	
	
	@Test(priority=0)
	public void Single_night_single_room() throws InterruptedException {
		
		System.out.println("beforemethods works properly");
		
		WebElement complete_Booking = driver.findElement(By.xpath("//*[text()=\"Complete Booking\"and@class=\"complete-booking-head\"]"));
		gu.ClickByJS(driver, complete_Booking);
		//First room = Deluxe Double Room with Sea View
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

	        // Scroll down by a specific pixel value (e.g., 500 pixels)
	        js.executeScript("window.scrollBy(0,1000)");
		WebElement Complete_Booking = driver.findElement(By.xpath("//*[@id=\"paymentpage2\"]/div[3]/div[2]/button"));
		gu.ClickByJS(driver, Complete_Booking);
	     

		
		
				
	}
	
	@Test(priority=1)
	public void single_night_MultipleRoom () throws InterruptedException {
		System.out.println("beforemethods works properly");
		WebElement Second_room = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusRoom2\"]"));
		gu.ClickByJS(driver, Second_room);
		
		WebElement Complete_Booking = driver.findElement(By.xpath("(//*[text()=\"Complete Booking\"])[2]"));
		gu.ClickByJS(driver, Complete_Booking);
		
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
		//second room = Apartment 
		WebElement secondguest_firstname =driver.findElement(By.xpath("//*[@id=\"f_1_0\"]"));
		 secondguest_firstname.sendKeys("Deepak");
		WebElement secondguest_lastname =driver.findElement(By.xpath("//*[@id=\"l_1_0\"]"));
		 secondguest_lastname.sendKeys("somani");
		 JavascriptExecutor js = (JavascriptExecutor) driver;

	        // Scroll down by a specific pixel value (e.g., 500 pixels)
	    js.executeScript("window.scrollBy(0,500)");
	    WebElement Complete_Booking1 = driver.findElement(By.xpath("//*[@id=\"paymentpage2\"]/div[3]/div[2]/button"));
		gu.ClickByJS(driver, Complete_Booking1);
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
