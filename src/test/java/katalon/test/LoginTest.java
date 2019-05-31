package katalon.test;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.Select; 


public class LoginTest {
  private static WebDriver driver;
  private static String baseUrl;
  private static boolean acceptNextAlert = true;
  private static StringBuffer verificationErrors = new StringBuffer();

  @BeforeAll
  public static void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "drivers/geckodriver-v0.24.0-win64/geckodriver.exe");
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_win32/chromedriver.exe");
	  System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer_x64_3.14.0/IEDriverServer.exe");
	  
	 driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		// driver = new HtmlUnitDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin() throws Exception {
    driver.get("http://localhost:8080/login");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("laura_usuario");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("1234");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You have been logged out successfully.'])[1]/following::button[1]")).click();
    assertEquals("Your username and password is invalid.", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::span[2]")).getText());
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("laura_usuario");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("password1234");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Your username and password is invalid.'])[1]/following::button[1]")).click();
    assertEquals("Welcome laura_usuario | Logout", driver.findElement(By.xpath("//h2")).getText());
    driver.findElement(By.linkText("Logout")).click();
    assertEquals("You have been logged out successfully.", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::span[1]")).getText());
  }

  @AfterAll
  public static void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
}
