
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;

public class GoToComment {
  private WebDriver driver;
  private String baseUrl;

  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/helen/Documents/itmo6/chromedriver-2-7");
    System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
    //driver = new ChromeDriver();
    driver = new FirefoxDriver();
    baseUrl = "https://tiu.ru/";
  }

  @Test
  public void testGo_to_comment() throws Exception {
    driver.get("https://tiu.ru/" );
    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div/div/div/div[1]/a/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[1]/input")).sendKeys("tanyaaf03.11@gmail.com");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[2]/input")).sendKeys("test3");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[3]/div[1]/button")).click();
    Thread.sleep(5000);
    driver.get(baseUrl + "comparison/list");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[3]/div/div[2]/a")).click();
    assertEquals("Оценки покупателей 12 месяцев", driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[3]/div/div/div[1]/div/div[1]/div/div[3]/div")).getText());
  }

  @After
  public void tearDown() throws Exception {
     driver.close();
    //driver.quit();
  }


}
