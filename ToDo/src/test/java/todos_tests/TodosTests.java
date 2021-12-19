package todos_tests;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TodosTests {
    WebDriver driver;
    public static Path localDir = Paths.get(".").toAbsolutePath();
    public static final String screenshotsPath = "\\screenshots\\%s.png";

    @BeforeAll
    public static void initialize() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void prepareDriver() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Backbone.js",
            "AngularJS",
            "Dojo",
            "React"
    })
    public void todosTestCase(String techno) throws Exception {
        driver.get("https://todomvc.com");
        WebElement element = driver.findElement(By.linkText(techno));

        element.click("Clean the room");
        WebElement element = driver.findElement(By.className("new-todo"));
        element.sendKeys();
        element.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        element.click("Make lunch");
        WebElement element = driver.findElement(By.className("new-todo"));
        element.sendKeys();
        element.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        
        element.click("Go to the cinema");
        WebElement element = driver.findElement(By.className("new-todo"));
        element.sendKeys();
        element.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        element.click("Buy grocery");
        WebElement element = driver.findElement(By.className("new-todo"));
        element.sendKeys();
        element.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("li:nth-child(3) > div > input")).click();
        driver.findElement(By.cssSelector("li:nth-child(1) > div > input")).click();
        
        WebElement element = driver.findElement(By.cssSelector("footer > span > strong"));
        ExpectedCondition<Boolean> expectedConditions = ExpectedConditions.textToBePresentInElement(element, 3);
        validateInnerText(element, Integer.toString(3));
        Thread.sleep(2000);

        takeScreenshot(driver, techno);
    }

    public static void takeScreenshot(WebDriver webdriver, String name) throws Exception {

        TakesScreenshot screenshot = ((TakesScreenshot) webdriver);
        File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(localDir.toAbsolutePath().toString() +
                String.format(screenshotsPath, "techno_" + name));
        FileUtils.copyFile(sourceFile, destinationFile);
    }

    @AfterEach
    public void quitDriver() {
        driver.quit();
    }
}
