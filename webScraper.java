/**
 *
 */
package SeleniumScraper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * @author kiril
 *
 */
public class webScraper {
    static String driverName = "webdriver.gecko.driver";
    //This one is user specific. Replace with user's path of the geckodriver.
    static String driverPath = "C:\\SeleniumDocs\\geckodriver.exe";
    static String ScreenShotPath = "C:\\SeleniumDocs\\ScreenShot";

    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String tst = "Universities in Calgary";
        searchMaps(tst);

        return;
    }

    private static void searchMaps(String tst) {
        System.setProperty(driverName, driverPath);
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        initSearch(driver);
        performSearch(tst,driver);

        getData(driver);

        driver.quit();
    }

    public static void getData(WebDriver driver) {
        File searchResult = new File(ScreenShotPath);
        waitForLoad();
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFileToDirectory(source, searchResult);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }

    private static void waitForLoad() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return;
    }

    private static void initSearch(WebDriver driver) {
        driver.get("https://maps.google.com");

        driver.getTitle(); // => "Google"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        return;
    }

    private static void performSearch(String tst, WebDriver driver) {
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.id("searchbox-searchbutton"));

        searchBox.sendKeys(tst);
        searchButton.click();
        return;
    }
}
