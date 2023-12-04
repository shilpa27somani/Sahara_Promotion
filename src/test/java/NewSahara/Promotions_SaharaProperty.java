package NewSahara;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.collections.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Utility.ConfigReader;
import Utility.GenericUtility;

public class Promotions_SaharaProperty {
	
	private GenericUtility gu = new GenericUtility();
	private WebDriver driver;
	private ConfigReader cr = new ConfigReader();
	private Properties prop;
	

	@BeforeSuite
	public void getProperty() {
		ConfigReader cr = new ConfigReader();
		prop = cr.init_prop();
	}	
	
	
	//Multinight_Discount
    @Test(priority=0)
	public void MULTINIGHT () throws InterruptedException {
		
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
		System.out.println("");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	     
	    try {
            WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
            gu.ClickByJS(driver, closeButton);
          
        } catch (NoSuchElementException e) {
          
        }  
	   
	WebElement canlender_click =  driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
	gu.ClickByJS(driver, canlender_click);
	gu.CheckINOUTDateProvider(driver, "Dec 2023", "30", "Dec 2023", "31");
	gu.LogPrinter("Check In Date 30 Dec");
	gu.LogPrinter("Check Out Date 31 Dec");
	System.out.println("");

	 //mouse over action
	 WebElement elementToHover1 = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/h5"));
     Actions actions = new Actions(driver);
     actions.moveToElement(elementToHover1).perform();
     
    WebElement Smartprize_Discount = driver.findElement(By.xpath("(//*[text()=\"10.00\"])[1]"));
	String a1 = Smartprize_Discount.getText();
    gu.LogPrinter(a1+ "   --Multinight type of discount prize");
    //String a2 = "10.00";
    Assert.assertEquals("10.00", a1);
	System.out.println("");

   
     WebElement totalvalue_AfterDiscout = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/div/table/tbody/tr[6]/td[2]"));
     String Total_Value_After_Discount  = totalvalue_AfterDiscout.getText();
     gu.LogPrinter(Total_Value_After_Discount+ "  --this is total value of the std room after discount before the click on book");
		System.out.println("");

     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,1000)");
     WebElement std_Book = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusSTD\"]"));
	 gu.ClickByJS(driver,std_Book );
	 Thread.sleep(3000);

	 WebElement Totalvalue_AfterDiscout_clickonBook = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/div/div[2]/div/div/div[4]/div/span"));
     String Total_Value_After_Discount_clickonBook  = Totalvalue_AfterDiscout_clickonBook.getText();
     gu.LogPrinter(Total_Value_After_Discount_clickonBook+ "  --this is total value of the std room with discount after click on book");
     String D4= Total_Value_After_Discount_clickonBook.replaceAll("INR ", "");	
     gu.LogPrinter(D4);
	 System.out.println("");


   
     WebElement flat_tax_Fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[1]"));
     String flat_tax_Fixed_type1 =flat_tax_Fixed_type.getText();
     gu.LogPrinter(flat_tax_Fixed_type1);
	 System.out.println("");


     WebElement flat_tax_for_percentage = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[2]"));
     String flat_tax_for_percentage1 =flat_tax_for_percentage.getText();
     gu.LogPrinter(flat_tax_for_percentage1);
	 System.out.println("");

     
     
     WebElement slab_tax_on_rack_rate_fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[3]"));
     String slab_tax_on_rack_rate_fixed_type1 =slab_tax_on_rack_rate_fixed_type.getText();
     gu.LogPrinter(slab_tax_on_rack_rate_fixed_type1);
	 System.out.println("");

	   
	    WebElement complete_Booking = driver.findElement(By.xpath("//*[text()=\"Complete Booking\"and@class=\"complete-booking-head\"]"));
	    gu.ClickByJS(driver, complete_Booking);
		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"f_0_0\"]"));
		FirstName.sendKeys("shilpa");
		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
		LastName.sendKeys("Somani");
		Thread.sleep(1000);
		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		MobileNo.sendKeys("8600207649");
		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		MailId.sendKeys("shilpa@staah.com");
		WebElement dropdownElement = driver.findElement(By.xpath("//*[@class=\"form-control form-select\"]"));
     Select dropdown = new Select(dropdownElement);
     dropdown.selectByVisibleText("2");
     JavascriptExecutor js1 = (JavascriptExecutor) driver;
     js1.executeScript("window.scrollBy(0,1000)");
		//Addon_//
     
     // WebElement Addon1 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[1]"));
    // gu.ClickByJS(driver, Addon1);
    // driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
    // driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();
	  WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
	  gu.ClickByJS(driver, ConfirmBookingBtn);
		
		
		WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
		Credit_Card_No.sendKeys("4111 1111 1111 1111");
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
		
		WebElement finalvalue_ofBooking = driver.findElement(By.xpath("//*[@style=\"padding: 5px 0;text-align: right; font-weight: 600; font-size: 20px;\"]"));
		String final_Amount = finalvalue_ofBooking.getText();
		System.out.println(final_Amount+ " -final amount ");
		String D5= final_Amount.replaceAll("Tax inclusive INR ", "");
		gu.LogPrinter(D5);
	    System.out.println("");
 

	       
	       
	         boolean areEqual = Total_Value_After_Discount.equals(D4) && Total_Value_After_Discount.equals(D5);

	        if (areEqual) {
	            System.out.println("All  Total value on card page and on completBooking page are equal.");
	        } else {
	            System.out.println("All Total value on card page and on completBooking page  are not equal.");
	        }
	 
	    }
		
    	

    
  //ADVANCE_PURCHASE
    @Test(priority=1)
	public void ADVANCE_PURCHASE () throws InterruptedException {
		
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
          
        } catch (NoSuchElementException e) {
          
        }  
	   
	WebElement canlender_click =  driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
	gu.ClickByJS(driver, canlender_click);
	gu.CheckINOUTDateProvider(driver, "Jan 2024", "1", "Jan 2024", "2");
	gu.LogPrinter("CheckInDate - 3oJan");
	gu.LogPrinter("CheckOutDate - 31Jan");


	 //mouse over action
	 WebElement elementToHover1 = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/h5"));
     Actions actions = new Actions(driver);
     actions.moveToElement(elementToHover1).perform();
     
    WebElement Smartprize_Discount = driver.findElement(By.xpath("(//*[text()=\"20.00\"])[1]"));
	String D2 = Smartprize_Discount.getText();
    gu.LogPrinter(D2+"  -- ADVANCE_PURCHASE discount prize");
    Assert.assertEquals("20.00", D2);
    System.out.println("Assertion passed");
	System.out.println("");

 
     
    WebElement totalvalue_AfterDiscout = driver.findElement(By.xpath("(//*[@class=\"text-end border-top border-color\"])[1]"));
    String Total_Value_After_Discount  = totalvalue_AfterDiscout.getText();
    gu.LogPrinter(Total_Value_After_Discount+ "  --this is total value of the std room after discount before the click on book");
  
    
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("window.scrollBy(0,1000)");
     WebElement std_Book = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusSTD\"]"));
	 gu.ClickByJS(driver,std_Book );
	 
	 
	 WebElement Totalvalue_AfterDiscout_clickonBook = driver.findElement(By.xpath("(//*[text()=\"INR 130.00\"])[2]"));
     String Total_Value_After_Discount_clickonBook  = Totalvalue_AfterDiscout_clickonBook.getText();
     System.out.println(Total_Value_After_Discount_clickonBook+ "  --this is total value of the std room with discount after click on book");
     String D4 = Total_Value_After_Discount_clickonBook.replaceAll("INR ", "");
	 System.out.println(D4);
	    System.out.println("");

	 
	     WebElement flat_tax_Fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[1]"));
	     String flat_tax_Fixed_type1 =flat_tax_Fixed_type.getText();
	     gu.LogPrinter(flat_tax_Fixed_type1);
	     System.out.println();

	     WebElement flat_tax_for_percentage = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[2]"));
	     String flat_tax_for_percentage1 =flat_tax_for_percentage.getText();
	     gu.LogPrinter(flat_tax_for_percentage1);
	     System.out.println();

	     
	     WebElement slab_tax_on_rack_rate_fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[3]"));
	     String slab_tax_on_rack_rate_fixed_type1 =slab_tax_on_rack_rate_fixed_type.getText();
	     gu.LogPrinter(slab_tax_on_rack_rate_fixed_type1);
	     System.out.println();

	 
	 WebElement complete_Booking = driver.findElement(By.xpath("//*[text()=\"Complete Booking\"and@class=\"complete-booking-head\"]"));
	 gu.ClickByJS(driver, complete_Booking);
		

		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"f_0_0\"]"));
		FirstName.sendKeys("shilpa");
		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
		LastName.sendKeys("Somani");
		Thread.sleep(1000);
		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
		MobileNo.sendKeys("8600207649");
		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		MailId.sendKeys("shilpa@staah.com");
		WebElement dropdownElement = driver.findElement(By.xpath("//*[@class=\"form-control form-select\"]"));
     Select dropdown = new Select(dropdownElement);
     dropdown.selectByVisibleText("2");
     JavascriptExecutor js1 = (JavascriptExecutor) driver;
     js1.executeScript("window.scrollBy(0,1000)");
		
    //Addon_//
    // WebElement Addon1 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[1]"));
     //gu.ClickByJS(driver, Addon1);
     //driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
	// driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();
	 WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
     gu.ClickByJS(driver, ConfirmBookingBtn);
		
		
		WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
		Credit_Card_No.sendKeys("4111 1111 1111 1111");
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
		
		WebElement finalvalue_ofBooking = driver.findElement(By.xpath("//*[@style=\"padding: 5px 0;text-align: right; font-weight: 600; font-size: 20px;\"]"));
		String final_Amount = finalvalue_ofBooking.getText();
		System.out.println(final_Amount+ " -final amount ");
		String D5 =final_Amount.replaceAll("Tax inclusive INR ", "");
		gu.LogPrinter(D5);
	    System.out.println("");

	   
	         boolean areEqual = Total_Value_After_Discount.equals(D4) && Total_Value_After_Discount.equals(D5);

	        if (areEqual) {
	            System.out.println("All  Total value on card page and on completBooking page are equal.");
	        } else {
	            System.out.println("All Total value on card page and on completBooking page  are not equal.");
	        }	
	       

    }	
    
    //DISCOUNT PER STAY
    @Test(priority=3)
   	public void DISCOUNT_PER_STAY () throws InterruptedException {
   		
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
             
           } catch (NoSuchElementException e) {
             
           }  
   	   
   	WebElement canlender_click =  driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
   	gu.ClickByJS(driver, canlender_click);
   	gu.CheckINOUTDateProvider(driver, "Feb 2024", "27", "Feb 2024", "28");
    System.out.println("CheckInDate - Feb27 ");
    System.out.println("CheckOutDate - 28Feb ");
    System.out.println("");


   	 //mouse over action
   	 WebElement elementToHover1 = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/h5"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementToHover1).perform();
        
        WebElement Smartprize_Discount = driver.findElement(By.xpath("//*[@id=\"BAR\"]/div/div/div/div[3]/div/div/table/tbody/tr[5]/td[2]"));
   	   String D3 = Smartprize_Discount.getText();
       System.out.println(D3+ "-This is discount value");
      //String a2 = "10.00";
       Assert.assertEquals("5.00", D3);
      
        
       WebElement totalvalue_AfterDiscout = driver.findElement(By.xpath("(//*[@class=\"text-end border-top border-color\"])[1]"));
       String Total_Value_After_Discount  = totalvalue_AfterDiscout.getText();
       System.out.println(Total_Value_After_Discount+ "  --this is total value of the std room after discount before the click on book");
     
       
      
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement std_Book = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusSTD\"]"));
   	   gu.ClickByJS(driver,std_Book );
   	   
   	   Thread.sleep(3000);
   	 WebElement Totalvalue_AfterDiscout_clickonBook = driver.findElement(By.xpath("//*[@class=\"tt-amount notranslate\"]"));
     String Total_Value_After_Discount_clickonBook  = Totalvalue_AfterDiscout_clickonBook.getText();
     System.out.println(Total_Value_After_Discount_clickonBook+ " -this is total value of the std room with discount after click on book");
     String D4 = Total_Value_After_Discount_clickonBook.replaceAll("INR ", "");
     System.out.println(D4);
     System.out.println("");

   	   
     WebElement flat_tax_Fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[1]"));
     String flat_tax_Fixed_type1 =flat_tax_Fixed_type.getText();
     gu.LogPrinter(flat_tax_Fixed_type1);
     System.out.println("");

     WebElement flat_tax_for_percentage = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[2]"));
     String flat_tax_for_percentage1 =flat_tax_for_percentage.getText();
     gu.LogPrinter(flat_tax_for_percentage1);
     System.out.println("");

     
     WebElement slab_tax_on_rack_rate_fixed_type = driver.findElement(By.xpath("(//*[@class=\"rs-rm-prc1\"])[3]"));
     String slab_tax_on_rack_rate_fixed_type1 =slab_tax_on_rack_rate_fixed_type.getText();
     gu.LogPrinter(slab_tax_on_rack_rate_fixed_type1);
     System.out.println("");

   	WebElement complete_Booking = driver.findElement(By.xpath("//*[text()=\"Complete Booking\"and@class=\"complete-booking-head\"]"));
   	gu.ClickByJS(driver, complete_Booking);
   		

   		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"f_0_0\"]"));
   		FirstName.sendKeys("shilpa");
   		WebElement LastName = driver.findElement(By.xpath("//input[@id=\"l_0_0\"]"));
   		LastName.sendKeys("Somani");
   		Thread.sleep(1000);
   		WebElement MobileNo = driver.findElement(By.xpath("//input[@id=\"phone\"]"));
   		MobileNo.sendKeys("8600207649");
   		WebElement MailId = driver.findElement(By.xpath("//input[@id=\"email\"]"));
   		MailId.sendKeys("shilpa@staah.com");
   		WebElement dropdownElement = driver.findElement(By.xpath("//*[@class=\"form-control form-select\"]"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("2");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");
   		//Addon_//
        
       // WebElement Addon1 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[1]"));
       // gu.ClickByJS(driver, Addon1);
      //  driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
   	  //  driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();
   	    WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
   		gu.ClickByJS(driver, ConfirmBookingBtn);
   		
   		
   		WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
   		Credit_Card_No.sendKeys("4111 1111 1111 1111");
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
   		
   		WebElement finalvalue_ofBooking = driver.findElement(By.xpath("//*[@style=\"padding: 5px 0;text-align: right; font-weight: 600; font-size: 20px;\"]"));
		String final_Amount = finalvalue_ofBooking.getText();
		System.out.println(final_Amount+ " -final amount ");
		String D5= final_Amount.replaceAll("Tax inclusive INR ", "");
		System.out.println(D5);
	    System.out.println("");

		
		
   	 
        boolean areEqual = Total_Value_After_Discount.equals(D4) && Total_Value_After_Discount.equals(D5);

       if (areEqual) {
           System.out.println("All  Total value on card page and on completBooking page are equal.");
       } else {
           System.out.println("All Total value on card page and on completBooking page  are not equal.");
       }

     

       }	



}
