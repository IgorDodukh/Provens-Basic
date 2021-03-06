package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.ProgressBar;
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

    private WebDriver driver;
    public SettingsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderProcessingTabLocator = By.xpath("//aside[@id='leftNav']//li[4]");
    private By alwaysShipAheadNoSettingChangesAllowedRadiobuttonLocator = By.xpath("//div[@id='shipahead']/span[1]//input");
    private By saveAndCloseContextualButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");
    private By saveSettingsSuccessPopupLocator = By.xpath("//*[@id='dydacomp_messagebox']");
    private By confirmPopupButtonLocator = By.xpath("//div[1]/button[@class='primary-button']");



    public void setShipaheadSetting() throws InterruptedException {
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Basic Settings' page popup was not found");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(orderProcessingTabLocator));
        Assert.assertEquals(element.isDisplayed(), true, "'Basic Settings' page was not loaded");

        totalResultMessage += "Open 'Order Processing' tab\n";
        Thread.sleep(1000);
        driver.findElement(orderProcessingTabLocator).click();
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Set 'Always Ship Ahead' setting\n";

        WebElement element2=driver.findElement(alwaysShipAheadNoSettingChangesAllowedRadiobuttonLocator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element2);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Click 'Save and Close' button\n";
        driver.findElement(saveAndCloseContextualButtonLocator).click();

        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait2.until(ExpectedConditions.elementToBeClickable(confirmPopupButtonLocator));
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Confirm success popup\n";
        String currentPopupMessage = driver.findElement(saveSettingsSuccessPopupLocator).getText();
        ProgressBar.addProgressValue(1);
        Assert.assertEquals(currentPopupMessage, saveSettingsPopupMessage, "Unexpected popup message");
        driver.findElement(confirmPopupButtonLocator).click();
        ProgressBar.addProgressValue(progressVariable);
        Thread.sleep(1000);
    }
}
