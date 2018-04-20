
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AddNewItemTest {
  private WebDriver driver;


  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/home/helen/Documents/itmo6/chromedriver-2-7");
    System.setProperty("webdriver.gecko.driver", "/home/helen/Documents/itmo6/geckodriver");
    //driver = new ChromeDriver();
    driver = new FirefoxDriver();
  }

  @Test
  public void testAddNew() throws Exception {
    driver.get("https://tiu.ru/" );
    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div/div/div/div[1]/a/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[1]/input")).sendKeys("tanyaaf03.11@gmail.com");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[2]/input")).sendKeys("test3");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[3]/div[1]/button")).click();
    Thread.sleep(5000);
    driver.get("https://my.tiu.ru/comparison/list");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try {
    	  if ("В корзине".equals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).getText()))
    	    break;
    	} catch (Exception e) {}
    	Thread.sleep(1000);
    }

    assertEquals("В корзине", driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).getText());
  }

  @Ignore
  @Test
  public void testDelete() throws Exception {
    driver.get("https://tiu.ru/" );
    Thread.sleep(2000);
    driver.findElement(By.xpath("//html/body/div[1]/div[2]/div/div/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[1]/div/div/div[2]/div/div/div/div/div/div[1]/a/span")).click();
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[1]/input")).sendKeys("tanyaaf03.11@gmail.com");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[2]/input")).sendKeys("test3");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div/div/div[1]/div/div[1]/form/div[3]/div[1]/button")).click();
    Thread.sleep(5000);
    driver.get("https://my.tiu.ru/comparison/list");
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).click();
    for (int second = 0;; second++) {
      if (second >= 60) fail("timeout");
      try { if ("В корзине".equals(driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).getText())) break; } catch (Exception e) {}
      Thread.sleep(1000);
    }

    assertEquals("В корзине", driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/div[3]/table/tbody/tr/td[4]/div/div/div[1]/div/a/span")).getText());

    driver.findElement(By.xpath("//html/body/div[12]/div/div/span")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[1]/div[3]/div/div/div[2]/ul/li[4]/a/svg/use")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//html/body/div[11]/div/div/div/div/div[2]/div[1]/div/div[3]/span[1]/svg[1]")).click();
    //[@class, 'x-shc-item__control-icon']

    Thread.sleep(2000);

    for (int second = 0;; second++) {
      if (second >= 60) fail("timeout");
      try {
        assertEquals("В корзине нет товаров", driver.findElement(By.xpath("html/body/div[12]/div/div/div/div/div/div[2]/div[1]/div[1]")).getText());
        break;
      } catch (Exception e) { }
      Thread.sleep(2000);
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.close();
    //driver.quit();

  }

}
