package NewSahara;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Utility.ConfigReader;
import Utility.GenericUtility;

public class Newsahara_rateplan {
	
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
            WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
            gu.ClickByJS(driver, closeButton);
            //closeButton.click();
            // Continue with the rest of your code after clicking the element
            //LogPrinter(" Continue with the rest of your code after clicking the Close Button");
        } catch (NoSuchElementException e) {
            // Element not found, continue without clicking
        	//LogPrinter(" Close Button not found, continue without clicking");
            // Add any desired actions or leave it empty
        }  
	    /*try {
	    WebElement BookBtn=driver.findElement(By.xpath("//button[@class=\"bkrm tabBtnNone m-md-0 notranslate\"]"));
	    gu.ClickByJS(driver, BookBtn);
	        }
	        catch(Exception e) {
	        	 gu.LogPrinter("Rooms not available for Booking ");
		            gu.LogPrinter("");
					gu.LogPrinter("");
		            driver.close();	
		            return;
	        }*/
	}
	@Test
	//Testcase_1(search adult one and book single room )
	public void SearchingRoom_onTheBascesOf_Adult() throws InterruptedException {
	 WebElement Adult_1_search = driver.findElement(By.xpath("//*[@value=\"1 Room, 2 Adult, 0 Child\"]"));
	 gu.ClickByJS(driver,Adult_1_search );
	 WebElement Decrease_Adult = driver.findElement(By.xpath("(//*[@data-action=\"decrease\"])[1]"));
	 gu.ClickByJS(driver, Decrease_Adult);
	 WebElement search =driver.findElement(By.xpath("//*[@class=\"Apply-btn\"]"));
	 gu.ClickByJS(driver, search);
	 WebElement BookButton = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusRoom\"]"));
	 gu.ClickByJS(driver, BookButton);
	 WebElement CompleteBookingBtn = driver.findElement(By.xpath("//button[@class=\"sr-sbmt\" and text()=\"Complete Booking\"]"));
	 gu.ClickByJS(driver, CompleteBookingBtn);
	 
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
	}
	
	@Test
	//Testcase_2(search child one and book one room for two adult and 1 child )
	public void SearchingRoom_onTheBascesOf_Child() throws InterruptedException {
		
	
		 WebElement child_1_search = driver.findElement(By.xpath("//*[@value=\"1 Room, 2 Adult, 0 Child\"]"));
		 gu.ClickByJS(driver,child_1_search );
	   
	     WebElement increase_child = driver.findElement(By.xpath("(//*[@data-action=\"increase\"])[2]"));
	   	 gu.ClickByJS(driver, increase_child);
	   	WebElement search =driver.findElement(By.xpath("//*[@class=\"Apply-btn\"]"));
		 gu.ClickByJS(driver, search);
		 
		 WebElement Appartment_Book = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusRoom2\"]"));
		 gu.ClickByJS(driver, Appartment_Book);
		 WebElement Appartment_CompleteBookig = driver.findElement(By.xpath("//*[@class=\"sr-sbmt\"]"));
		 gu.ClickByJS(driver, Appartment_CompleteBookig);
		 
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
	    	
	    	
	    }
	
	  @Test
	  //Test_3(Single_night_single_room)
      public void Single_night_single_room() throws InterruptedException {
		 System.out.println("beforemethods works properly");
		 WebElement BookButton = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusRoom\"]"));
		 gu.ClickByJS(driver, BookButton);
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
	    
	   @Test
	   // Testcase_ (to check SmartPrize which is in the from of discount) 
	   public void Addon_ () throws InterruptedException {
		System.out.println("ok");
		WebElement CanlenderClick = driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
  	    gu.ClickByJS(driver, CanlenderClick);	
	    gu.CheckINOUTDateProvider(driver, "Dec 2023", "8", "Dec 2023", "9");
			
		WebElement elementToHover = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/h4"));
		Actions actions = new Actions(driver);
	    actions.moveToElement(elementToHover).perform();
		     
		WebElement Smartprize_Discount = driver.findElement(By.xpath("(//*[text()=\"10.00\"])[1]"));
		String a1 = Smartprize_Discount.getText();
        System.out.println(a1);
      //String a2 = "10.00";
        Assert.assertEquals("10.00", a1);
		     
		     
	   }
	    
	
	    
		
	
	
	
	
	
	//@AfterMethod
	
	public void Payment_getway () throws InterruptedException {
		
	WebElement Confirom_Booking =driver.findElement(By.xpath("//*[text()=\"Confirm Booking\"]"));	
	gu.ClickByJS(driver, Confirom_Booking);

 	
		
	WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
	Credit_Card_No.sendKeys(prop.getProperty("CreditCardNumber"));
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
