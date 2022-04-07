<<<<<<< HEAD:src/application/webScraper.java
package application;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

/**
 * @author Kiril, Vincent and Izzah.
 * The following is a class in which a screenshot of
 * the results from google maps is made and saved into
 * the directory. The search is conducted through the
 * headless variant of the Selenium automated webbrowser,
 * which goes to google maps and searches a passed in string.
 */
public class webScraper {
    /*This requires user to setup files. A future method could
     * automate the directory creation, but the user would have
     * to manually insert the geckodriver into that location.
     */
    static String driverName = "webdriver.gecko.driver";
    static String driverPath = "C:\\SeleniumDocs\\geckodriver.exe";
    static String ScreenShotPath = "C:\\SeleniumDocs\\ScreenShot";

    /*The following is for formatting of the output image.*/
    static int topLeftX = 0;
    static int topLeftY = 70;
    static int imgWidth = 400;
    static int imgHeight = 480;
    /**
     * This is used as a test driver.
     */

    /**
    * The following searches the passed in term and saves the
    * results on google maps as a screenshot to a directory defined
    * at the beginning of the class.
    */
    public void searchMaps(String tst) {
        System.setProperty(driverName, driverPath);
       // ProfilesIni profilesIni = new ProfilesIni();
      //  FirefoxProfile profile = profilesIni.getProfile("AutomatedBrowser");
        FirefoxOptions options = new FirefoxOptions();
      //  options.setProfile(profile);
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        initSearch(driver);
        performSearch(tst,driver);

        getData(driver);

        driver.quit();
        return;
    }

    /**
    * getData passes in the web browser and screenshots the page. Then, it
    * crops the image to only show the result and then writes this image to
    * a directory.
    */
    public static void getData(WebDriver driver) {
        File searchResult = new File(ScreenShotPath);
        waitForLoad();
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File edit = new File("searchResult.png");
        try {
            BufferedImage trim = ImageIO.read(source);
            trim = trim.getSubimage(topLeftX,topLeftY,imgWidth,imgHeight);
            ImageIO.write(trim, "png", edit);
            FileUtils.copyFileToDirectory(edit, searchResult);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }

    /**
    * The following subroutine gets used to delay the program for elements of
    * the webdriver to load.
    */
    private static void waitForLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return;
    }

    /**
    * This subroutine passes in the headless web browser
    * and loads google maps.
    */
    private static void initSearch(WebDriver driver) {
        driver.get("https://maps.google.com");

        driver.getTitle(); // => "Google"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        return;
    }

    /**
    * This subroutine searches the web browser holding google maps 
    * with a given term that gets passed in as a string.
    */
    private static void performSearch(String tst, WebDriver driver) {
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.id("searchbox-searchbutton"));

        searchBox.sendKeys(tst);
        searchButton.click();
        return;
    }
}
=======
package SeleniumScraper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

/**
 * @author Kiril, Vincent and Izzah.
 * The following is a class in which a screenshot of
 * the results from google maps is made and saved into
 * the directory. The search is conducted through the
 * headless variant of the Selenium automated webbrowser,
 * which goes to google maps and searches a passed in string.
 */
public class webScraper {
    /*This requires user to setup files. A future method could
     * automate the directory creation, but the user would have
     * to manually insert the geckodriver into that location.
     */
    static String driverName = "webdriver.gecko.driver";
    static String driverPath = "C:\\SeleniumDocs\\geckodriver.exe";
    static String ScreenShotPath = "C:\\SeleniumDocs\\ScreenShot";

    /*The following is for formatting of the output image.*/
    static int topLeftX = 0;
    static int topLeftY = 70;
    static int imgWidth = 400;
    static int imgHeight = 480;

    /**
    * The following searches the passed in term and saves the
    * results on google maps as a screenshot to a directory defined
    * at the beginning of the class.
    */
    public void searchMaps(String tst) {
        //System.setProperty(driverName, driverPath);
        //ProfilesIni profilesIni = new ProfilesIni();
        FirefoxProfile profile = profilesIni.getProfile("AutomatedBrowser");
        //FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        options.addArguments("--headless");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();

        initSearch(driver);
        performSearch(tst,driver);

        getData(driver);

        driver.quit();
        return;
    }

    /**
    * getData passes in the web browser and screenshots the page. Then, it
    * crops the image to only show the result and then writes this image to
    * a directory.
    */
    public static void getData(WebDriver driver) {
        File searchResult = new File(ScreenShotPath);
        waitForLoad();
        TakesScreenshot screenshot = (TakesScreenshot)driver;

        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File edit = new File("search result.png");
        try {
            BufferedImage trim = ImageIO.read(source);
            trim = trim.getSubimage(topLeftX,topLeftY,imgWidth,imgHeight);
            ImageIO.write(trim, "png", edit);
            FileUtils.copyFileToDirectory(edit, searchResult);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return;
    }

    /**
    * The following subroutine gets used to delay the program for elements of
    * the webdriver to load.
    */
    private static void waitForLoad() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return;
    }

    /**
    * This subroutine passes in the headless web browser
    * and loads google maps.
    */
    private static void initSearch(WebDriver driver) {
        driver.get("https://maps.google.com");

        driver.getTitle(); // => "Google"

        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        return;
    }

    /**
    * This subroutine searches the web browser holding google maps 
    * with a given term that gets passed in as a string.
    */
    private static void performSearch(String tst, WebDriver driver) {
        WebElement searchBox = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.id("searchbox-searchbutton"));

        searchBox.sendKeys(tst);
        searchButton.click();
        return;
    }
}
>>>>>>> 1d88c39a4ce1497ecc30316a6aa9d316fd82cb10:webScraper.java
