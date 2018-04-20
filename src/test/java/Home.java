
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Home {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    //driver = new ChromeDriver();
    System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
    driver = new FirefoxDriver();
    baseUrl = "https://spb.tiu.ru/";
  }

  @Test
  public void testHome() throws Exception {
    driver.get(baseUrl + "Grili-barbekyu-i-prinadlezhnosti");
    //driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[1]/a/img")).click();
    assertEquals("https://spb.tiu.ru/", driver.getCurrentUrl());
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
    //driver.quit();

  }


}
