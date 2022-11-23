package com.nickczj.fly;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstScriptTest {

  @Test
  public void eightComponents() {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    String title = driver.getTitle();
    assertEquals("Web form", title);

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    WebElement textBox = driver.findElement(By.name("my-text"));
    WebElement submitButton = driver.findElement(By.cssSelector("button"));

    textBox.sendKeys("Selenium");
    submitButton.click();

    WebElement message = driver.findElement(By.id("message"));
    String value = message.getText();
    assertEquals("Received!", value);

    driver.quit();
  }

  @Test
  public void aaa() {
    WebDriverManager.chromedriver().setup();

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.singaporeair.com/en_UK/sg/home#/book/bookflight");

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));

    WebElement loginButton = driver.findElement(By.xpath("//table[@class='lang-profile_login']//div/nobr[.='abc']/.."));;
//    WebElement parent = (WebElement) ((JavascriptExecutor) driver).executeScript("return arguments[0].parentNode;", loginButton);
    loginButton.click();

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(50));

    WebElement userEmailInput = driver.findElement(By.id("userEmailKfPpsClub"));

    userEmailInput.sendKeys("nick.chow.zj@gmail.com");

    driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

    driver.quit();
  }
}