package New;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class abc {

	@Test
	public void test() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		ChromeDriver driver=new ChromeDriver(ops);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.mybookingsite.io/inst/#home?propertyId=262Ij2CUHwHmrboe3lUxOTkzNSI=&JDRN=Y");
		driver.manage().window().maximize();
}
}