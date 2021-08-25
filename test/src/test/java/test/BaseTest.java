package test;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {

	WebDriver driver;
	WebDriverWait wait;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");           
		driver = new ChromeDriver(); 
		wait = new WebDriverWait(driver, 10);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
