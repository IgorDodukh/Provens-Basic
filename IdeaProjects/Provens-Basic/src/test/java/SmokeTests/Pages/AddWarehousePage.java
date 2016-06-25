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
 * Created by igor on 18.04.16.
 */
public class AddWarehousePage extends BrowserSettings {

    public WebDriver driver;

    public AddWarehousePage(WebDriver driver) {
        this.driver = driver;
    }

    private By warehouseNameFieldLocator = By.xpath("//input[@id='warehouseName']");
    private By warehouseContactNameFieldLocator = By.xpath("//input[@id='contactName']");
    private By warehousePhoneFieldLocator = By.xpath("//input[@id='phoneNumber']");
    private By pickingReadyTimeFieldLocator = By.xpath("//input[@id='pickingReadyTime']");
    private By pickingCutoffTimeFieldLocator = By.xpath("//input[@id='pickingCutoffTime']");
    private By addressFieldLocator = By.xpath("//input[@id='address_warehouse']");
    private By zipFieldLocator = By.xpath("//input[@id='zip_warehouse']");
    private By warehouseInfoTitleLocator = By.xpath("//*[@id='subTitle']/h2/strong");
    private By binsTabLocator = By.xpath("//*[@id='leftNav']/ul/li[2]/a");
    private By addWarehouseBinButtonLocator = By.xpath("//input[@id='add_bin']");
    private By addBinPopupTitleLocator = By.xpath("//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']");

    private By newBinNameLocator = By.xpath("//*[@id='txtBinName']");
    private By pickBinTypeLocator = By.xpath("//*[@id='selectBinType']/option[@value='2']");
    private By saveNewBinBtnLocator = By.xpath("//*[@id='save_BinAddClone']");
    private By newBinNameInBinsGridLocator = By.xpath("((//*[@id='warehouseBinsResult']//tr/*)[6])");

    private By saveContextualButton = By.xpath("//a[@id='btnSave']");
//    private By saveAndCloseContextualButtonLocator = By.xpath("//a[@id='btnSaveAndClose']");

    private By popupBoxMessageLocator = By.xpath("(//div[@id='warehouseMessageBox']//*)[1]");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");
    private By currentPageModePopup = By.xpath(".//*[@id='breadCrumb']/ul/li[2]/h1");


    public void addWarehouseInfo(String warehouseName, String contactName, String phone, String startTime, String endTime, String addressLine1, String zip) {
        log("Add Warehouse info");
        log("Add Warehouse Name");
        WebElement warehouseNameField = driver.findElement(warehouseNameFieldLocator);
        warehouseNameField.clear();
        warehouseNameField.click();
        warehouseNameField.sendKeys(warehouseName);

        log("Add contact name");
        WebElement contactNameField = driver.findElement(warehouseContactNameFieldLocator);
        contactNameField.clear();
        contactNameField.click();
        contactNameField.sendKeys(contactName);

        log("Add phone number");
        WebElement phoneField = driver.findElement(warehousePhoneFieldLocator);
        phoneField.clear();
        phoneField.click();
        phoneField.sendKeys(phone);

        log("Add Earliest Pickup Time");
        WebElement startTimeField = driver.findElement(pickingReadyTimeFieldLocator);
        startTimeField.clear();
        startTimeField.click();
        startTimeField.sendKeys(startTime);

        log("Add Latest Pickup Time");
        WebElement endTimeField = driver.findElement(pickingCutoffTimeFieldLocator);
        endTimeField.clear();
        endTimeField.click();
        endTimeField.sendKeys(endTime);

        log("Add address line");
        WebElement addressLineField = driver.findElement(addressFieldLocator);
        addressLineField.clear();
        addressLineField.click();
        addressLineField.sendKeys(addressLine1);

        log("Add zip code");
        WebElement zipField = driver.findElement(zipFieldLocator);
        zipField.clear();
        zipField.click();
        zipField.sendKeys(zip);
        driver.findElement(warehouseInfoTitleLocator).click();
    }

    public void addWarehouseBin (String name) throws InterruptedException {
        log("Select Bins tab");
        driver.findElement(binsTabLocator).click();
        log("Open 'Add Bin' popup");
        driver.findElement(addWarehouseBinButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Add Bin' popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addBinPopupTitleLocator));

        Assert.assertEquals(element.isDisplayed(), true, "Popup for the 'Add Bin' form is not displayed");

        log("Put Bin name");
        WebElement binName = driver.findElement(newBinNameLocator);
        binName.clear();
        binName.click();
        binName.sendKeys(name);

        log("Select Bin type");
        driver.findElement(pickBinTypeLocator).click();

        log("Save new Bin");
        driver.findElement(saveNewBinBtnLocator).click();
        Assert.assertEquals(driver.findElement(newBinNameInBinsGridLocator).getText(), newBinName, "Unexpected new created bin's name");
    }

    public void saveWarehouse() throws InterruptedException {
        log("Save Warehouse");
        driver.findElement(saveContextualButton).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupBoxMessageLocator));

        log("Confirm popup message");
        String currentMessage = driver.findElement(popupBoxMessageLocator).getText();
        Assert.assertEquals(currentMessage, saveWarehousePopupMessage, "Unexpected popup message");
        driver.findElement(popupOkBtnLocator).click();

        log("Check displayed page with the created WH name");
        final Wait<WebDriver> wait1 = new WebDriverWait(driver, timeoutVariable).withMessage("Waiting popup is not hidden for a long time");
        wait1.until(ExpectedConditions.elementToBeClickable(binsTabLocator));
    }
}