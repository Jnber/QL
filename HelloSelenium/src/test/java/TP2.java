import io.github.bonigarcia.wdm.WebDriverManager;
import models.Account;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TP2 {
    WebDriver driver;
    JavascriptExecutor js;

    @Before
    public void prepareDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void buyMacTestCase() throws InterruptedException {
        driver.get("https://www.tunisianet.com.tn/");

        //SignIN
        Thread.sleep(1000);
        userInfoDropdown = driver.findElement(By.cssSelector("#_desktop_user_info > div > div > svg"));
        userInfoDropdown.click();
        Thread.sleep(1000);
        signinButton = driver.findElement(By.cssSelector(".user-down > li > a > span"));
        signinButton.click();
        Thread.sleep(1000);
        WebElement emailTextField = driver.findElement(By.cssSelector(".form-group > div > input"));
        emailTextField.sendKeys("mail");
        Thread.sleep(1000);
        WebElement pwdTextField = driver.findElement(By.cssSelector(".form-group > div > div > input"));
        pwdTextField.sendKeys("password");
        Thread.sleep(1000);
        WebElement submitButton = driver.findElement(By.id("submit-login"));
        submitButton.click();

        // Search for Mac
        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.className("search_query"));
        searchBar.sendKeys("PC portable MacBook M1 13.3");
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.cssSelector("#sp-btn-search > button"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> productsTitle = driver.findElements(By.className("product-title"));
        productsTitle.get(0).click();

        // Add product to cart
        Thread.sleep(1000);
        WebElement addToCartButton = driver.findElement(By.className("add-to-cart"));
        addToCartButton.click();
        Thread.sleep(1000);
        WebElement orderButton = driver.findElement(By.cssSelector("a.btn-block"));
        orderButton.click();
    }

    @After
    public void quitDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}

