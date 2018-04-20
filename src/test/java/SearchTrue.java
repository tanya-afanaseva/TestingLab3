import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchTrue {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    //driver = new ChromeDriver();
    System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
    driver = new FirefoxDriver();
    driver.get("https://spb.tiu.ru/");
  }

  @Test
  public void testSearchTrue() throws Exception {
    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[2]/form/div/div/div/input")).clear();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[2]/form/div/div/div/input")).sendKeys("Куртка");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[1]/div/div[2]/form/div/div/div/button")).click();
    assertEquals("Результаты поиска по запросу «Куртка» в разделе потребительские товары в Санкт-Петербурге.", driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[4]/div/div[2]/h1")).getText());
  }

  @After
  public void tearDown() throws Exception {
    //driver.close();
    //driver.quit();
  }

}