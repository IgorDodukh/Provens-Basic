package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by igor on 28.05.16.
 */
public class ShippingMethodsPage extends BrowserSettings {
    public WebDriver driver;

    public ShippingMethodsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By addShippingMethodButtonLocator = By.xpath("//button[@id='add_shippingMethod']");
    private By addShippingMethodTitleLocator = By.xpath("//h2/strong");

    private By shippingMethodNameFieldLocator = By.xpath("//input[@id='ShippingMethod_Name']");
    private By upsMethodDropdownLocator = By.xpath("//select[@id='selectCarrierList']/option[2]");
    private By upsTypeGroundDropdownLocator = By.xpath("//select[@id='selectServiceList']/option[6]");
    private By favoriteShippingMethodSetYesLocator = By.xpath("//div[@id='toggleIsFavoriteShippingMethod_div']/span[1]");
    private By shippingChargeFieldLocator = By.xpath("//input[@id='priceValue']");
    private By saveAndCloseContextualButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");
    private By saveSettingsSuccessPopupLocator = By.xpath("//div[@role='dialog']/*[2]");
    private By confirmPopupButtonLocator = By.xpath("//div[1]/button[@class='primary-button']");


    public void openShippingMethodCreatingForm() {
        log("Open 'Add Shipping Method' form");
        driver.findElement(addShippingMethodButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Shipping Method Creating Form was not opened");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addShippingMethodTitleLocator));
        String currentTitle = driver.findElement(addShippingMethodTitleLocator).getText();
        Assert.assertEquals(currentTitle, "Shipping Method Information", "Unexpected page title for Shipping Method Creating Form");
    }

    public void createUPSGroundShippingMethod(String methodName, String shippingCharge) {
        log("Add 'UPS Ground' method");
        log("Set 'UPS Ground' method name");
        WebElement shippingMethodNameField = driver.findElement(shippingMethodNameFieldLocator);
        shippingMethodNameField.clear();
        shippingMethodNameField.click();
        shippingMethodNameField.sendKeys(methodName);

        driver.findElement(upsMethodDropdownLocator).click();
        driver.findElement(upsTypeGroundDropdownLocator).click();
        driver.findElement(favoriteShippingMethodSetYesLocator).click();

        WebElement shippingChargeField = driver.findElement(shippingChargeFieldLocator);
        shippingChargeField.clear();
        shippingChargeField.click();
        shippingChargeField.sendKeys(shippingCharge);

        log("Save 'UPS' method");
        driver.findElement(saveAndCloseContextualButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(saveSettingsSuccessPopupLocator));

        log("Confirm success popup");
        String currentPopupMessage = driver.findElement(saveSettingsSuccessPopupLocator).getText();
        Assert.assertEquals(currentPopupMessage, "Create ShippingMethod successfully!", "Unexpected popup message");
        driver.findElement(confirmPopupButtonLocator).click();

        log("Check displaying Shipping Methods grid after saving changes");
        final Wait<WebDriver> wait1 = new WebDriverWait(driver, 5).withMessage("Success popup is not hidden for a long time");
        wait1.until(ExpectedConditions.elementToBeClickable(addShippingMethodButtonLocator));
    }

}
