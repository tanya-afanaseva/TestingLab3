

import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LogEmailFalse {
  private WebDriver driver;

  @Before
  public void setUp() throws Exception {
    //driver = new ChromeDriver();
    System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
    driver = new FirefoxDriver();
    driver.get("https://tiu.ru/");
  }

  @Test
  public void testLog_email_false() throws Exception {
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div/div/div/div[1]/a/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[1]/input")).sendKeys("tanyaaf03.11@gmail.com");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[2]/input")).sendKeys("test");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[3]/div[1]/button")).click();
    Thread.sleep(5000);
    assertNotEquals("https://my.tiu.ru/cabinet/user", driver.getCurrentUrl());
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
    //driver.quit();
  }


}
