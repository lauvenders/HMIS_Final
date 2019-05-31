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

public class CreateAccountBlankUser {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeAll
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateAccountBlankUser() throws Exception {
    driver.get("http://localhost:8080/login?logout");
    driver.findElement(By.linkText("Create an account")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("contraseña");
    driver.findElement(By.id("passwordConfirm")).click();
    driver.findElement(By.id("passwordConfirm")).clear();
    driver.findElement(By.id("passwordConfirm")).sendKeys("contraseña");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Create your account'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("//div")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
    driver.findElement(By.id("username")).click();
    // ERROR: Caught exception [ERROR: Unsupported command [getEval |  | ]]
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='This field is required.Please use between 6 and 32 characters.'])[1]/following::button[1]")).click();
    assertEquals("Logout", driver.findElement(By.linkText("Logout")).getText());
    driver.findElement(By.linkText("Logout")).click();
    assertEquals("You have been logged out successfully.", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::span[1]")).getText());
  }

  @AfterAll
  public void tearDown() throws Exception {
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
