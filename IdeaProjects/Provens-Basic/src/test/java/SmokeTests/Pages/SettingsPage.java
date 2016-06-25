package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by igor on 27.05.16.
 */
public class SettingsPage extends BrowserSettings {

    public WebDriver driver;
    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderProcessingTabLocator = By.xpath("//aside[@id='leftNav']//li[4]");
    private By alwaysShipAheadNoSettingChangesAllowedRadiobuttonLocator = By.xpath("//div[@id='shipahead']/span[1]//input");
    private By saveAndCloseContextualButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");
    private By saveSettingsSuccessPopupLocator = By.xpath("//*[@id='dydacomp_messagebox']");
    private By confirmPopupButtonLocator = By.xpath("//div[1]/button[@class='primary-button']");



    public void setShipaheadSetting() throws InterruptedException {
        log("Open 'Order Processing' tab locator");
        System.out.println("Open 'Order Processing' tab locator");
        driver.findElement(orderProcessingTabLocator).click();

        log("Set 'Always Ship Ahead, no setting changes allowed' setting");
        System.out.println("Set 'Always Ship Ahead, no setting changes allowed' setting");

        WebElement element=driver.findElement(alwaysShipAheadNoSettingChangesAllowedRadiobuttonLocator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);

        log("Click 'Save and Close' button");
        System.out.println("Click 'Save and Close' button");
        driver.findElement(saveAndCloseContextualButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveSettingsSuccessPopupLocator));

        log("Confirm success popup");
        System.out.println("Confirm success popup");
        String currentPopupMessage = driver.findElement(saveSettingsSuccessPopupLocator).getText();
        Assert.assertEquals(currentPopupMessage, saveSettingsPopupMessage, "Unexpected popup message");
        driver.findElement(confirmPopupButtonLocator).click();

        Thread.sleep(5000);
        log("Check displaying settings page after saving changes");
        System.out.println("Check displaying settings page after saving changes");
        final Wait<WebDriver> wait1 = new WebDriverWait(driver, timeoutVariable).withMessage("Success popup is not hidden for a long time");
        wait1.until(ExpectedConditions.elementToBeClickable(orderProcessingTabLocator));
    }
}
