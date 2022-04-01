/**
 *
 */
package SeleniumScraper;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author kiril
 *
 */
public class webScraper {
    static String driverName = "webdriver.gecko.driver";
    //This one is user specific. Replace with user's path of the geckodriver.
    static String driverPath = "C:\\Users\\kiril\\eclipse-workspace\\WebScraper\\Resources\\geckodriver.exe";
    static char newline = '\n';
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String tst = "Universities in Calgary";
        searchMaps(tst);

        return;
    }

    private static void searchMaps(String tst) {
        char debugLoop = ' ';
        Scanner sc = new Scanner(System.in);
        System.setProperty(driverName, driverPath);
        Results searchResult = new Results();
        WebDriver driver = new FirefoxDriver();

        initSearch(driver);
        performSearch(tst,driver);

        getData(searchResult,driver);

        while(debugLoop != newline) {
            debugLoop = sc.next().charAt(0);
        }

        driver.quit();
        sc.close();
    }

    public static void getData(Results searchResult, WebDriver driver) {
        WebElement ResultBox = driver.findElement(By.id("Results For"));
        WebElement Single = ResultBox.findElement(By.name("aria-label"));
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
