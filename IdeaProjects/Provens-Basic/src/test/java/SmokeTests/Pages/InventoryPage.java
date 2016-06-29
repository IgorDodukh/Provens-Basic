package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Objects;

/**
 * Created by Ihor on 6/29/2016.
 */
public class InventoryPage extends BrowserSettings {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productInventoryFilterByFieldLocator = By.xpath("//label/input");
    private By firstProductLocator = By.xpath("//tr[1]");
    private By firstProductSKULocator = By.xpath("//tr[1]/td[2]");
    private By firstProductAddButtonLocator = By.xpath("//tr[1]//button[@id='create_Inventory']");

    private By lotNumberFieldLocator = By.xpath("//input[@id='txtLotNum']");
    private By unitCostFieldLocator = By.xpath("//input[@id='txtUnitCost']");
    private By binDropdownLocator = By.xpath("//select[@id='bin_1']");
    private By binDropdownFirstExistingLocator = By.xpath("//select[@id='bin_1']//option[1]");

    private By addBinNameFieldLocator = By.xpath("//input[@id='txtBinName']");
    private By addBinPickBinDropdownLocator = By.xpath("//select[@id='selectBinType']/option[2]");
    private By addBinPriorityFieldLocator = By.xpath("//input[@id='binPriority']");
    private By addBinLowLevelFieldLocator = By.xpath("//input[@id='productInfo_LowLevel']");
    private By addBinQuantityFieldLocator = By.xpath("//input[@id='quantity_1']");
    private By addBinNotesFieldLocator = By.xpath("//textarea[@id='txtComment']");

    private By saveBinButtonLocator = By.xpath("//input[@id='save_BinAddClone']");

    private By saveAndCloseProductButtonLocator = By.xpath("//a[@id='btnSaveAndClose']");
    private By popupBoxMessageLocator = By.xpath("//*[@id='dydacomp_messagebox']");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");




    public void openAddInventoryForm() {
        totalResultMessage += "Search created Product\n";
        driver.findElement(productInventoryFilterByFieldLocator).sendKeys(productSku);
        driver.findElement(productInventoryFilterByFieldLocator).sendKeys(Keys.ENTER);

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Product search didn't finished");
        wait.until(ExpectedConditions.elementToBeClickable(firstProductSKULocator));

        Assert.assertEquals(driver.findElement(firstProductSKULocator).getText(), productSku, "Found Product has not expected SKU");

        totalResultMessage += "Select first found Product\n";
        driver.findElement(firstProductLocator).click();

        totalResultMessage += "Click 'Add' button\n";
        driver.findElement(firstProductAddButtonLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Inventory adding form was not loaded");
        wait2.until(ExpectedConditions.elementToBeClickable(lotNumberFieldLocator));
    }

    public void addInventoryInfo() {
        totalResultMessage += "Adding Inventory info:\n";
        totalResultMessage += " - Add Lot number\n";
        driver.findElement(productInventoryFilterByFieldLocator).sendKeys(inventoryLotNumber);

        totalResultMessage += " - Add unit cost\n";
        driver.findElement(unitCostFieldLocator).sendKeys(inventoryUnitCost);

        totalResultMessage += " - Is Bin exist\n";
        if(Objects.equals(driver.findElement(binDropdownFirstExistingLocator).getText(), "+ Add New Bin")){
            totalResultMessage += " - Bin doesn't exist\n";
            driver.findElement(binDropdownLocator).click();
            driver.findElement(binDropdownFirstExistingLocator).click();
            final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Bin creating form was not loaded");
            wait.until(ExpectedConditions.elementToBeClickable(addBinNameFieldLocator));

            totalResultMessage += "Adding Bin info:\n";
            totalResultMessage += " - Add Bin name\n";
            driver.findElement(addBinNameFieldLocator).sendKeys(binName);

            totalResultMessage += " - Select Bin type\n";
            driver.findElement(addBinPickBinDropdownLocator).click();

            totalResultMessage += " - Add Bin priority\n";
            driver.findElement(addBinPriorityFieldLocator).sendKeys(binPriority);

            totalResultMessage += " - Add Bin low level\n";
            driver.findElement(addBinLowLevelFieldLocator).sendKeys("0");

            totalResultMessage += " - Save Bin\n";
            driver.findElement(saveBinButtonLocator).click();
            final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Bin creating popup was not hidden");
            wait2.until(ExpectedConditions.elementToBeClickable(lotNumberFieldLocator));

        } else {
            totalResultMessage += " - Bin does exist\n";
            driver.findElement(binDropdownFirstExistingLocator).click();
        }

        totalResultMessage += " - Add qty value\n";
        driver.findElement(addBinQuantityFieldLocator).sendKeys(inventoryQty);

        totalResultMessage += " - Add Notes\n";
        driver.findElement(addBinNotesFieldLocator).sendKeys(inventoryNotes);
    }

    public void saveInventory() throws InterruptedException {
        totalResultMessage += "Saving inventory:\n";
        totalResultMessage += " - Click 'Save and Close' button\n";
        driver.findElement(saveAndCloseProductButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupBoxMessageLocator));

        totalResultMessage += " - Confirm success popup\n";
        driver.findElement(popupOkBtnLocator).click();
    }

}
