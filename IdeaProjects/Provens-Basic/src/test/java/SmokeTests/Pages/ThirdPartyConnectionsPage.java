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
    private By authorizeTestResultPopupLocator = By.xpath("//div[@id='ThirdPartyConnectionsManagement']");
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



    public void configureAuthorizeAccount(String apiLoginId, String transactionKey) {
        log("Add API login ID");
        WebElement loginField = driver.findElement(authorizeLoginFieldLocator);
        loginField.clear();
        loginField.click();
        loginField.sendKeys(apiLoginId);

        log("Add Transaction Key");
        WebElement keyField = driver.findElement(authorizeKeyFieldLocator);
        keyField.clear();
        keyField.click();
        keyField.sendKeys(transactionKey);

        log("Make Test for Authorize");
        driver.findElement(authorizeTestButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Authorize test result popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(authorizeTestResultPopupLocator));

        String currentPopupMessage = driver.findElement(authorizeTestResultPopupLocator).getText();
        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "Authorize test result unexpected popup message");

        driver.findElement(confirmPopupButtonLocator).click();
    }

    public void configureUPSAccount(String userName, String password, String licenseNumber, String shipperNumber) {
        log("Select Carrier Getaway Tab");
        driver.findElement(carrierGetawayTabLocator).click();
        log("Click UPS checkbox");
        driver.findElement(upsConfigurationCheckboxLocator).click();

        log("Enter UPS username");
        WebElement userNameField = driver.findElement(upsUserNameFieldLocator);
        userNameField.clear();
        userNameField.click();
        userNameField.sendKeys(userName);

        log("Enter UPS password");
        WebElement passwordField = driver.findElement(upsPasswordFieldLocator);
        passwordField.clear();
        passwordField.click();
        passwordField.sendKeys(password);

        log("Enter UPS License Number");
        WebElement licenseNumberField = driver.findElement(upsLicenseNumberFieldLocator);
        licenseNumberField.clear();
        licenseNumberField.click();
        licenseNumberField.sendKeys(licenseNumber);

        log("Enter UPS Shipper Number");
        WebElement shipperNumberField = driver.findElement(upsShipperNumberFieldLocator);
        shipperNumberField.clear();
        shipperNumberField.click();
        shipperNumberField.sendKeys(shipperNumber);

        log("Make Test for UPS");
        driver.findElement(upsTestButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("UPS test result popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));

        String currentPopupMessage = driver.findElement(testResultPopupLocator).getText();
        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "UPS test result unexpected popup message");

        driver.findElement(confirmPopupButtonLocator).click();
    }

    public void configureUSPSAccount(String accountId, String passPhrase) throws InterruptedException {
        log("Click USPS checkbox");
        driver.findElement(uspsConfigurationCheckboxLocator).click();

        log("Enter USPS Account ID");
        WebElement accountIdField = driver.findElement(uspsAccountIdFieldLocator);
        accountIdField.clear();
        accountIdField.click();
        accountIdField.sendKeys(accountId);

        log("Enter USPS Pass Phrase");
        WebElement passPhraseField = driver.findElement(uspsPasswordFieldLocator);
        passPhraseField.clear();
        passPhraseField.click();
        passPhraseField.sendKeys(passPhrase);

        log("Make Test for USPS");
        driver.findElement(uspsTestButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("USPS test result popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(testResultPopupLocator));

        String currentPopupMessage = driver.findElement(testResultPopupLocator).getText();
        Assert.assertEquals(currentPopupMessage, "The connection test was successful.", "USPS test result unexpected popup message");
        Thread.sleep(5000);

        driver.findElement(confirmPopupButtonLocator).click();
        Thread.sleep(5000);
        driver.findElement(saveAndCloseContextualButtonLocator).click();
    }
}
