package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.print.PageFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage
{
    WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void implicitWait(long timeToWait)
    {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }
    public void waitForPageLoadComplete(Duration timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void waitForPaginatorLinkIsActive(Duration timeToWait, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver,timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForPriceSearchButtonIsVisible(Duration timeToWait, WebElement element)
    {
        new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOf(element));
    }
}
