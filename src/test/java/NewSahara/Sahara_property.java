package NewSahara;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Utility.ConfigReader;
import Utility.GenericUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Sahara_property {

	private GenericUtility ge = new GenericUtility();
	private  WebDriver driver;
	private ConfigReader cr = new ConfigReader();
	private Properties prop;
	
	
	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.mybookingsite.io/inst/#home?propertyId=262Ij2CUHwHmrboe3lUxOTkzNSI=&JDRN=Y");
		driver.manage().window().maximize();
		WebElement alert = driver.findElement(By.xpath("//*[@class=\"btn-close\"]"));
		ge.ClickByJS(driver, alert);
		
		//canlender
		WebElement CanlenderClick = driver.findElement(By.xpath("//*[@id=\"start-Date-Input\"]"));
		ge.ClickByJS(driver, CanlenderClick);
		
		ge.CheckINOUTDateProvider(driver, "Dec 2023", "8", "Dec 2023", "9");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement std_Book = driver.findElement(By.xpath("//*[@id=\"reserve-onclick-focusSTD\"]"));
	   ge.ClickByJS(driver,std_Book );
	   WebElement complete_Booking = driver.findElement(By.xpath("//*[text()=\"Complete Booking\"and@class=\"complete-booking-head\"]"));
		ge.ClickByJS(driver, complete_Booking);
		

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
        dropdown.selectByVisibleText("1");
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");
		//Addon_//
        
        WebElement Addon1 = driver.findElement(By.xpath("(//*[@class=\"addon-add-btn bkrm m-0\"and@value=\"[object Object]\"])[1]"));
        ge.ClickByJS(driver, Addon1);
        driver.findElement(By.xpath("//*[@class=\"form-check-input mt-0\"]")).click();
 	    driver.findElement(By.xpath("//*[@class=\"bkrm w-auto fs14 fw500 btn btn-primary\"]")).click();
 	    WebElement ConfirmBookingBtn = driver.findElement(By.xpath("//button[@class=\"bkrm confirm-booking mb-0\" and @name=\"payMethod\"]"));
		ge.ClickByJS(driver, ConfirmBookingBtn);
		
		
		WebElement Credit_Card_No=driver.findElement(By.xpath("//input[@class=\"form-control card-number-input\"]"));
		Credit_Card_No.sendKeys("4111 1111 1111 1111");
		driver.findElement(By.xpath("//*[@id=\"cc_name\"]")).sendKeys("shilpa somani");		
		WebElement ExpiryDateMM=driver.findElement(By.xpath("//i[@class=\"fa-solid fa-angle-down\"]"));
		ge.ClickByJS(driver, ExpiryDateMM);
		WebElement ExpiryMonth=driver.findElement(By.xpath("//li[@id=\"MM6\"]"));
		ge.ClickByJS(driver, ExpiryMonth);
		WebElement ExpiryYear=driver.findElement(By.xpath("(//i[@class=\"fa-solid fa-angle-down\"])[2]"));
		ge.ClickByJS(driver, ExpiryYear);
		WebElement ExpYear=driver.findElement(By.xpath("//li[@id=\"2028\"]"));
		ge.ClickByJS(driver, ExpYear);
		WebElement CVV=driver.findElement(By.xpath("//input[@placeholder=\"CVV\"]"));
		CVV.sendKeys("123");
		WebElement ConfirmBtnCredit=driver.findElement(By.xpath("//button[@id=\"btn1\"]"));
		ge.ClickByJS(driver, ConfirmBtnCredit);
		
	}
        
     
		
	
	
					
		
	

	}	
	
	
	

