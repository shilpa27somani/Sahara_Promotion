package CrossBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross_Browser {
	public WebDriver driver ;
	@Parameters("browser")
	@Test
	public void lunch(@Optional("chrome") String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Staah\\Desktop\\New folder\\chromedriver-win64\\chromedriver.exe");
		     ChromeOptions ops = new ChromeOptions();
				ops.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(ops);
				
				driver.manage().window().maximize();
				driver.get("http://www.Google.com");
			     String actulTitle = driver.getTitle();
				System.out.println(actulTitle);
				String expTitle = "Google";
				}
				else if (browser.equalsIgnoreCase("firefox")) {
					   WebDriverManager.firefoxdriver().setup();
					   WebDriver driver = new FirefoxDriver();
					   driver.get("https://www.facebook.com/");
				
			
}
	}
}

