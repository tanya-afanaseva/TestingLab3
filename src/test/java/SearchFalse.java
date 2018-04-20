import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SearchFalse {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/helen/Documents/itmo6/chromedriver-2-7");
		System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
		//driver = new ChromeDriver();

		driver = new FirefoxDriver();
		driver.navigate().to( "https://spb.tiu.ru/");
		//driver.get( "https://spb.tiu.ru/");
	}

	@Test
	public void testSearch_false() throws Exception {
		Thread.sleep(5000);

		driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div/span")).click();

		Thread.sleep(5000);

		driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[2]/form/div/div/div/input")).sendKeys("jffhhdd");
		driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[2]/form/div/div/div/input")).submit();

		Thread.sleep(5000);
		assertEquals("По запросу ничего не найдено", driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[3]/div/div[2]/div/div[1]/div[2]/div/div/div/div/div[2]/div[1]/div")).getText());
		//assert(true);
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
		//driver.quit();
	}
}
