package StepDefs;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;

public class Hooks {
    public static WebDriver driver;

    @Before
    /**
     * Delete all cookies at the start of each scenario to avoid
     * shared state between tests
     */
    public void openBrowser() {
        String exePath = "src/test/drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", exePath);
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
    }

    @After
    public String captureScreen() throws IOException {
        TakesScreenshot screen = (TakesScreenshot) driver;
        File src = screen.getScreenshotAs(OutputType.FILE);
        String dest = "target/screenshots/" + "Screenshots" + new Date().getTime() + ".png";
        File target = new File(dest);
        FileUtils.copyFile(src, target);
        return dest;
    }

    @After
    /**
     * Close the Browser
     */
    public void closeBrowser() {
        driver.quit();
    }
}
