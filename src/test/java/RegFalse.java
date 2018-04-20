
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;



public class RegFalse {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		//driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://tiu.ru/join-customer?source_id=txt.register.customer&locale=ru");
	}

	@Test
	public void testReg_false() throws Exception {
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[2]/div/form/div[3]/input")).sendKeys("tanyaaf03.11@gmail.com");
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[2]/div/form/div[4]/input")).sendKeys("testtest1");
		driver.findElement(By.xpath("//html/body/div[3]/div[2]/div/div[2]/div/form/div[7]/button")).click();
		Thread.sleep(5000);
		assertNotEquals("https://my.tiu.ru/cabinet/user/profile/info", driver.getCurrentUrl());
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
	}
}
