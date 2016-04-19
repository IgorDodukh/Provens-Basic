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

    By warehouseNameFieldLocator = By.xpath("//input[@id='warehouseName']");
    By warehouseContactNameFieldLocator = By.xpath("//input[@id='contactName']");
    By warehousePhoneFieldLocator = By.xpath("//input[@id='phoneNumber']");
    By pickingReadyTimeFieldLocator = By.xpath("//input[@id='pickingReadyTime']");
    By pickingCutoffTimeFieldLocator = By.xpath("//input[@id='pickingCutoffTime']");
    By addressFieldLocator = By.xpath("//input[@id='address_warehouse']");
    By zipFieldLocator = By.xpath("//input[@id='zip_warehouse']");
    By warehouseInfoTitleLocator = By.xpath("//*[@id='subTitle']/h2/strong");
    By binsTabLocator = By.xpath("//*[@id='leftNav']/ul/li[2]/a");
    By addWarehouseBinButtonLocator = By.xpath("//input[@id='add_bin']");
    By addBinPopupTitleLocator = By.xpath("//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-draggable']");

    By newBinNameLocator = By.xpath("//*[@id='txtBinName']");
    By pickBinTypeLocator = By.xpath("//*[@id='selectBinType']/option[@value='2']");
    By saveNewBinBtnLocator = By.xpath("//*[@id='save_BinAddClone']");
    By newBinNameInBinsGridLocator = By.xpath("((//*[@id='warehouseBinsResult']//tr/*)[6])");

    By saveContextualButton = By.xpath("//a[@id='btnSave']");
//    By saveAndCloseContextualButtonLocator = By.xpath("//a[@id='btnSaveAndClose']");

    By popupBoxMessageLocator = By.xpath("(//div[@id='warehouseMessageBox']//*)[1]");
    By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");
    By currentPageModePopup = By.xpath(".//*[@id='breadCrumb']/ul/li[2]/h1");


    public void addWarehouseInfo() {
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
        contactNameField.sendKeys(warehouseContactName);

        log("Add phone number");
        WebElement phoneField = driver.findElement(warehousePhoneFieldLocator);
        phoneField.clear();
        phoneField.click();
        phoneField.sendKeys(customerPhone);

        log("Add Earliest Pickup Time");
        WebElement startTimeField = driver.findElement(pickingReadyTimeFieldLocator);
        startTimeField.clear();
        startTimeField.click();
        startTimeField.sendKeys(startPickupTime);

        log("Add Latest Pickup Time");
        WebElement endTimeField = driver.findElement(pickingCutoffTimeFieldLocator);
        endTimeField.clear();
        endTimeField.click();
        endTimeField.sendKeys(endPickupTime);

        log("Add address line");
        WebElement addressLineField = driver.findElement(addressFieldLocator);
        addressLineField.clear();
        addressLineField.click();
        addressLineField.sendKeys(billingAddressAddrLine1);

        log("Add zip code");
        WebElement zipField = driver.findElement(zipFieldLocator);
        zipField.clear();
        zipField.click();
        zipField.sendKeys(billingAddressZip);
        driver.findElement(warehouseInfoTitleLocator).click();
    }

    public void addWarehouseBin () throws InterruptedException {
        log("Select Bins tab");
        driver.findElement(binsTabLocator).click();
        log("Open 'Add Bin' popup");
        driver.findElement(addWarehouseBinButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(addBinPopupTitleLocator));

        Assert.assertEquals(element.isDisplayed(), true, "Popup for the 'Add Bin' form is not displayed");

        log("Put Bin name");
        WebElement binName = driver.findElement(newBinNameLocator);
        binName.clear();
        binName.click();
        binName.sendKeys(newBinName);

        log("Select Bin type");
        driver.findElement(pickBinTypeLocator).click();

        log("Save new Bin");
        driver.findElement(saveNewBinBtnLocator).click();
        Assert.assertEquals(driver.findElement(newBinNameInBinsGridLocator).getText(), newBinName, "Unexpected new created bin's name");
    }

    public void saveWarehouse() throws InterruptedException {
        driver.findElement(saveContextualButton).click();

        Thread.sleep(5000);

        String currentMessage = driver.findElement(popupBoxMessageLocator).getText();
        Assert.assertEquals(currentMessage, saveWarehousePopupMessage, "Unexpected popup message");
        driver.findElement(popupOkBtnLocator).click();

        Thread.sleep(5000);

        Assert.assertEquals(driver.findElement(warehouseInfoTitleLocator).isDisplayed(), true, "Unexpected page title");
        Assert.assertEquals(driver.findElement(currentPageModePopup).getText(), "View " + warehouseName, "Unexpected page mode. Should be view.");
    }
}
