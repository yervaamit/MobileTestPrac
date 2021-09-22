package mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class AppiumUtils {
    @SneakyThrows
    public static void scrollDownTo(By byOfElementToBeFound, AppiumDriver<MobileElement> driver) {
        List<MobileElement> elements;
        int i = 0;
        Thread.sleep(500);
        while (i < 12) {
            Thread.sleep(500);
            elements=driver.findElements(byOfElementToBeFound);
            if (elements.size() > 0 && elements.get(0).isDisplayed())
                return;
            scrollDown(driver);
            i++;
        }
//        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    @SneakyThrows
    public static void scrollUpTo(By byOfElementToBeFound, AppiumDriver<MobileElement> driver) {
        List<MobileElement> elements;
        int i = 0;
        Thread.sleep(500);
        while (i < 12) {
            Thread.sleep(500);
            elements=driver.findElements(byOfElementToBeFound);
            if (elements.size() > 0 && elements.get(0).isDisplayed())
                return;
            scrollUp(driver);
            i++;
        }
//        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    @SneakyThrows
    public static void scrollDownOnElementTo(By byOfElementToScrollOn, By byOfElementToBeFound, AppiumDriver<MobileElement> driver) {
        int i = 0;
        while (i < 12) {
            Thread.sleep(500);
            if (driver.findElements(byOfElementToBeFound).size() > 0)
                return;
            scrollDownOnElement(byOfElementToScrollOn, driver);
            i++;
        }
//        Assert.fail("Did not find : " + byOfElementToBeFound.toString());
    }

    public static void scrollDown(AppiumDriver<MobileElement> driver) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        swipe(width / 2, height * 2 / 3, width / 2, height / 3, 1000, driver);
    }
    public static void scrollUp(AppiumDriver<MobileElement> driver) {
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        swipe(width / 2, height / 3, width / 2, height * 2 / 3, 1000, driver);
    }

    public static void scrollDownOnElement(By byOfElementToScrollOn, AppiumDriver<MobileElement> driver) {
        int x = driver.findElement(byOfElementToScrollOn).getLocation().getX();
        int y = driver.findElement(byOfElementToScrollOn).getLocation().getY();
        int height = driver.findElement(byOfElementToScrollOn).getSize().getHeight();
        int width = driver.findElement(byOfElementToScrollOn).getSize().getWidth();
        int startX = (width / 2) + x;
        int endX = (width / 2) + x;
        int startY = (height * 2 / 3) + y;
        int endY = (height / 3) + y;
        swipe(startX, startY, endX, endY, 1000, driver);
    }

    public static void swipe(int startX, int startY, int endX, int endY, int durationInMilliSeconds, AppiumDriver<MobileElement> driver) {
        new TouchAction(driver)
                .press(point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(durationInMilliSeconds)))
                .moveTo(point(endX, endY)).release().perform();
    }

    public static WebElement waitForElementToVisible(AppiumDriver driver, WebElement element, int seconds) {
        WebDriverWait wait=new WebDriverWait(driver, seconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
