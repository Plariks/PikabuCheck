package baseFunc;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DecimalFormat;
import java.util.List;

public class BaseFunc {

    WebDriver driver;
    public WebDriverWait wait;
    Actions actions;
    WebElement target;


    public BaseFunc() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/694039/Desktop/pycharm/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);
    }

    public void openPage(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "https://" + url;
        }
        driver.get(url);
    }

    public WebElement getElement(By locator) {
        Assertions.assertFalse(getAllElements(locator).isEmpty(), "this element is not found!");
        return driver.findElement(locator);
    }

    public List<WebElement> getAllElements(By locator) {
        Assertions.assertFalse(driver.findElements(locator).isEmpty(), "this element is not found!");
        Assertions.assertFalse(driver.findElements(locator).isEmpty(), "this element is not found!");
        return driver.findElements(locator);
    }

//    public double roundTheNumber(Double needed, Integer value) {
//        if (value == 1) {
//            DecimalFormat twoform = new DecimalFormat("0.0");
//            return Double.valueOf(twoform.format(needed));
//        } else if (value == 2) {
//            DecimalFormat twoform = new DecimalFormat("0.00");
//            return Double.valueOf(twoform.format(needed));
//        } else if (value == 3) {
//            DecimalFormat twoform = new DecimalFormat("0.000");
//            return Double.valueOf(twoform.format(needed));
//        } else if (value == 4) {
//            DecimalFormat twoform = new DecimalFormat("0.0000");
//            return Double.valueOf(twoform.format(needed));
//
//        }
//        else;
//        DecimalFormat twoform = new DecimalFormat("0.00000");
//        return Double.valueOf(twoform.format(needed));
//    }

    public void moveOverElement(By locator) {
        actions = new Actions(driver);
        target = driver.findElement(locator);
        actions.moveToElement(target).perform();
    }

    public void waitPage(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public boolean isElementPresent(By locator) {
        waitPage(locator);
        return getAllElements(locator).isEmpty();
    }
}
