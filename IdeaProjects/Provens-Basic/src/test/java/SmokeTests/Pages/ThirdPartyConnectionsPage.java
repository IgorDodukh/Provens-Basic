package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;

/**
 * Created by igor on 27.05.16.
 */
public class ThirdPartyConnectionsPage extends BrowserSettings {
    public WebDriver driver;

    public ThirdPartyConnectionsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By authorizeLoginFieldLocator = By.xpath("//input[@id='passwordAuthorizenetLoginId']");
    private By authorizeKeyFieldLocator = By.xpath("//input[@id='passwordTransactionKey']");
    private By authorizeTestButtonLocator = By.xpath("//input[@id='btnPaymentGatewaryTestConnect']");
//    private By authorizeTestResultPopupLocator = By.xpath("//div[@id='ThirdPartyConnectionsManagement']");
    private By confirmPopupButtonLocator = By.xpath("//div[1]/button[@class='primary-button']");

    private By carrierGetawayTabLocator = By.xpath("//a[@id='leftNav_item_2']");
    private By upsConfigurationCheckboxLocator = By.xpath("//input[@id='upsConnectionsChk']");
    private By upsUserNameFieldLocator = By.xpath("//input[@id='txtUPSUserName']");
    private By upsPasswordFieldLocator = By.xpath("//input[@id='passwordUPSPassword']");
    private By upsShipperNumberFieldLocator = By.xpath("//input[@id='txtUPSShipperNumber']");
    private By upsLicenseNumberFieldLocator = By.xpath("//input[@id='txtUPSAccessLicenseNumber']");

    private By upsTestButtonLocator = By.xpath("//input[@id='btnUPSTestConnect']");
    private By testResultPopupLocator = By.xpath("//div[@id='ThirdPartyConnectionsManagement']");

    private By uspsConfigurationCheckboxLocator = By.xpath("//input[@id='uspsConnectionsChk']");
    private By uspsAccountIdFieldLocator = By.xpath("//input[@id='txtUSPSAccountID']");
    private By uspsPasswordFieldLocator = By.xpath("//input[@id='passwordUSPSPassword']");

    private By uspsTestButtonLocator = By.xpath("//input[@id='btnUSPSTestConnect']");

    private By saveAndCloseContextualButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");
    private By saveContextualButtonLocator = By.xpath("//*[@id='btnSave']/div[2]");
    private By popupBoxMessageLocator = By.xpath("(//div[@id='warehouseMessageBox']//*)[1]");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");


    public void configureAuthorizeAccount(String apiLoginId, String transactionKey) {
        log("Add API login ID");
        System.out.println("Add API login ID");
        WebElement loginField = driver.findElement(authorizeLoginFieldLocator);
        loginField.clear();
        loginField.sendKeys(apiLoginId);

        log("Add Transaction Key");
        System.out.println("Add Transaction Key");
        WebElement keyField = driver.findElement(authorizeKeyFieldLocator);
        keyField.clear();
        keyField.sendKeys(transactionKey);

//        log("Make Test for Authorize");
//        driver.findElement(authorizeTestButtonLocator).click();
//        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Authorize test result popup was not found");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));
//
//        String currentPopupMessage = driver.findElement(testResultPopupLocator).getText();
//        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "Authorize test result unexpected popup message.");
//
//        driver.findElement(confirmPopupButtonLocator).click();
    }

    public void configureUPSAccount(String userName, String password, String licenseNumber, String shipperNumber) {
        log("Select Carrier Getaway Tab");
        System.out.println("Select Carrier Getaway Tab");
        driver.findElement(carrierGetawayTabLocator).click();

        log("Click UPS checkbox");
        System.out.println("Click UPS checkbox");

        String upsIsChecked;
        upsIsChecked = driver.findElement(upsConfigurationCheckboxLocator).getAttribute("checked");

        if(!Objects.equals(upsIsChecked, "true")){
            driver.findElement(upsConfigurationCheckboxLocator).click();
            System.out.println("UPS checkbox is selected");
        } else {
            System.out.println("UPS checkbox was selected");
        }

        final Wait<WebDriver> wait3 = new WebDriverWait(driver, timeoutVariable).withMessage("'UPS User Name' field was not found");
        WebElement element2 = wait3.until(ExpectedConditions.elementToBeClickable(upsUserNameFieldLocator));
        Assert.assertEquals(element2.isDisplayed(), true, "'UPS User Name' field was not loaded");

        log("Enter UPS username");
        System.out.println("Enter UPS username");
        WebElement userNameField = driver.findElement(upsUserNameFieldLocator);
        userNameField.clear();
        userNameField.sendKeys(userName);

        log("Enter UPS password");
        System.out.println("Enter UPS password");
        WebElement passwordField = driver.findElement(upsPasswordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);

        log("Enter UPS License Number");
        System.out.println("Enter UPS License Number");
        WebElement licenseNumberField = driver.findElement(upsLicenseNumberFieldLocator);
        licenseNumberField.clear();
        licenseNumberField.sendKeys(licenseNumber);

        log("Enter UPS Shipper Number");
        System.out.println("Enter UPS Shipper Number");
        WebElement shipperNumberField = driver.findElement(upsShipperNumberFieldLocator);
        shipperNumberField.clear();
        shipperNumberField.sendKeys(shipperNumber);

//          Test for UPS connection

//        log("Make Test for UPS");
//        driver.findElement(upsTestButtonLocator).click();
//        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("UPS test result popup was not found");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));
//
//        String currentPopupMessage = driver.findElement(testResultPopupLocator).getText();
//        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "UPS test result unexpected popup message.");
//
//        driver.findElement(confirmPopupButtonLocator).click();
    }

    public void configureUSPSAccount(String accountId, String passPhrase) throws InterruptedException {
        Thread.sleep(2000);
        log("Click USPS checkbox");
        System.out.println("Wait USPS checkbox");

        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("USPS checkbox is not clickable");
        wait2.until(ExpectedConditions.elementToBeClickable(uspsConfigurationCheckboxLocator));

        System.out.println("Click USPS checkbox");
        String uspsIsChecked;
        uspsIsChecked = driver.findElement(uspsConfigurationCheckboxLocator).getAttribute("checked");

        if(!Objects.equals(uspsIsChecked, "true")){
            driver.findElement(uspsConfigurationCheckboxLocator).click();
            System.out.println("USPS checkbox is selected");
        } else {
            System.out.println("USPS checkbox was selected");
        }

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'USPS Account ID' field was not found");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(uspsAccountIdFieldLocator));
        Assert.assertEquals(element.isDisplayed(), true, "'USPS Account ID' field was not loaded");

        log("Enter USPS Account ID");
        System.out.println("Enter USPS Account ID");
        WebElement accountIdField = driver.findElement(uspsAccountIdFieldLocator);
        accountIdField.clear();
        accountIdField.sendKeys(accountId);

        log("Enter USPS Pass Phrase");
        System.out.println("Enter USPS Pass Phrase");
        WebElement passPhraseField = driver.findElement(uspsPasswordFieldLocator);
        passPhraseField.clear();
        passPhraseField.sendKeys(passPhrase);

//        log("Make Test for USPS");
//        driver.findElement(uspsTestButtonLocator).click();
//        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("USPS test result popup was not found");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));
//
//        String currentPopupMessage = driver.findElement(testResultPopupLocator).getText();
//        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "USPS test result unexpected popup message");
//        Thread.sleep(5000);
//
//        driver.findElement(confirmPopupButtonLocator).click();
//        Thread.sleep(5000);

    }

    public void saveThirdPartyConnectionSettings () {
        log("Click 'Save and Close' button");
        System.out.println("Click 'Save and Close' button");
        driver.findElement(saveAndCloseContextualButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));

        log("Confirm popup message");
        System.out.println("Confirm saving settings popup message");
        driver.findElement(popupOkBtnLocator).click();
    }
}
