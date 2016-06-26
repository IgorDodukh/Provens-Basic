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
 * Created by igor on 21.04.16.
 */
public class AddProductPage extends BrowserSettings{
    private WebDriver driver;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productDetailsTabTitleLocator = By.xpath("//section[@class='tabContainer columns']/h2/strong");
    private By productSkuFieldLocator = By.xpath("//input[@name='productInfo_Sku']");
    private By productNameFieldLocator = By.xpath("//input[@name='productInfo_Name']");
    private By productWeightFieldLocator = By.xpath("//input[@name='productInfo_WeightLB']");
    private By productShortDescriptionLocator = By.xpath("//textarea[@id='productInfo_Desc']");

    private By productPricingTabLocator = By.xpath("//li[@id='pricingTab']");
    private By productPricingTabTitleLocator = By.xpath("//*[@id='pricingModule']//h4/strong");
    private By productRetailPriceLocator = By.cssSelector("#retail-price");

    private By salesChannelsTabTitleLocator = By.xpath("//*[@id='subTitle']/h2");
    private By productSalesChannelsTabLocator = By.xpath("//li[@id='salesChannelsTab']");
    private By salesChannelNameFieldLocator = By.xpath("//*[@id='control_autoCompleteSingle_1']");
    private By salesChannelTooltipLocator = By.xpath("//li[@class='ui-menu-item']");
    private By salesChannelAddButtonLocator = By.xpath("//*[@id='salesChannelsTable']//img[2]");

    private By suppliersTabTitleLocator = By.xpath("//*[@id='subTitle']/h2/strong");
    private By productSuppliersTabLocator = By.xpath("//li[@id='suppliersTab']");
    private By addSupplierButtonLocator = By.xpath("//*[@id='add_supplier']");
    private By addSupplierPopupLocator = By.xpath("//*[@id='dydacomp_messagebox']");
    private By selectSupplierCheckboxLocator = By.xpath("//input[@name='chxBox_supplier']");
    private By addSelectedSupplierButtonLocator = By.xpath("//*[@id='add_selected_supplier']");
    private By selectAddedSupplierLocator = By.xpath("//*[@id='SuppliersItemsTable']/tbody/tr");
    private By openAddedSupplierToEditButtonLocator = By.xpath("//*[@id='rowActions']/input[1]");
    private By warehouseTabLocator = By.xpath("//*[@id='li_Warehouse']");
    private By unitCostFieldLocator = By.xpath("//*[@id='txtPrice']");
    private By unitCostAddButtonLocator = By.xpath("//*[@id='add_item']");
    private By supplierSaveOkButton = By.xpath("//*[@id='btnOkButton1']");
    private By viewCostLinkLocator = By.xpath("//*[@id='SuppliersItemsTable']/tbody/tr/td[3]/a");
    private By saveAndCloseProductButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");

    private By productMessageBoxLocator = By.xpath("//*[@id='productMessageBox']");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");
    private By saveProductPopupMessage = By.xpath("(//div[@id='customerMessageBox']//*)[1]");
    private By filterProductsFieldLocator = By.xpath("//*[@id='searchProductResult_filter']/label/input");
    private By productSkuInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[2]");
    private By productNameInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[3]");
    private By productRetailPriceInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[4]");


    public void addProductInfo(String sku, String name, String weight, String shortDescription) {
        log("Add product info");
        System.out.println("Add product info");
        log("Add product SKU");
        System.out.println("Add product SKU");
        WebElement productSkuField = driver.findElement(productSkuFieldLocator);
        productSkuField.clear();
        productSkuField.sendKeys(sku);

        log("Add product Name");
        System.out.println("Add product Name");
        WebElement productNameField = driver.findElement(productNameFieldLocator);
        productNameField.clear();
        productNameField.sendKeys(name);

        log("Add product weight");
        System.out.println("Add product weight");
        WebElement productWeightField = driver.findElement(productWeightFieldLocator);
        productWeightField.clear();
        productWeightField.sendKeys(weight);

        log("Add product Short Description");
        System.out.println("Add product Short Description");
        WebElement productShortDescriptionField = driver.findElement(productShortDescriptionLocator);
        productShortDescriptionField.clear();
        productShortDescriptionField.sendKeys(shortDescription);
    }

    public void addProductPrices(String retailPrice) {
        log("Select 'Pricing' tab");
        System.out.println("Select 'Pricing' tab");
        driver.findElement(productPricingTabLocator).click();

        log("Add product Retail Price");
        System.out.println("Add product Retail Price");
        WebElement productRetailPriceField = driver.findElement(productRetailPriceLocator);
        productRetailPriceField.clear();
        productRetailPriceField.sendKeys(retailPrice);
    }

    public void addProductSalesChannel(String channelName) {
        log("Select 'Sales Channels' tab");
        System.out.println("Select 'Sales Channels' tab");
        driver.findElement(productSalesChannelsTabLocator).click();

        log("Add 'Call Center' sales channel");
        System.out.println("Add 'Call Center' sales channel");
        WebElement productChannelNameField = driver.findElement(salesChannelNameFieldLocator);
        productChannelNameField.clear();
        productChannelNameField.sendKeys(channelName);

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Call Center' tooltip was not found");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(salesChannelTooltipLocator));

        Assert.assertEquals(element.isDisplayed(), true, "'Call Center' tooltip is not displayed");

        System.out.println("Click 'Call Center' tooltip");
        driver.findElement(salesChannelTooltipLocator).click();
        driver.findElement(salesChannelAddButtonLocator).click();
    }

    public void addProductSupplier(String unitCost) throws InterruptedException {
        log("Select 'Suppliers' tab");
        System.out.println("Select 'Suppliers' tab");
        driver.findElement(productSuppliersTabLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Add Supplier tab was not loaded");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addSupplierButtonLocator));
        Assert.assertEquals(element.isDisplayed(), true, "Add Supplier tab was not loaded");

        Thread.sleep(2000);

        log("Add default Supplier");
        System.out.println("Add default Supplier");
        driver.findElement(addSupplierButtonLocator).click();

        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("'Add Supplier' popup was not found");
        WebElement element2 = wait2.until(ExpectedConditions.elementToBeClickable(selectSupplierCheckboxLocator));

        Assert.assertEquals(element2.isDisplayed(), true, "Popup for the 'Add Supplier' form is not displayed");

        System.out.println("Add Supplier info");
        driver.findElement(selectSupplierCheckboxLocator).click();
        driver.findElement(addSelectedSupplierButtonLocator).click();
        driver.findElement(selectAddedSupplierLocator).click();
        driver.findElement(openAddedSupplierToEditButtonLocator).click();
        driver.findElement(warehouseTabLocator).click();

        System.out.println("Add Supplier Unit Cost");
        WebElement supplierWHUnitCostField = driver.findElement(unitCostFieldLocator);
        supplierWHUnitCostField.clear();
        supplierWHUnitCostField.sendKeys(unitCost);

        driver.findElement(unitCostAddButtonLocator).click();
        driver.findElement(supplierSaveOkButton).click();
    }

    public void saveProduct() {
        log("Save Product");
        System.out.println("Save Product");
        driver.findElement(saveAndCloseProductButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(productMessageBoxLocator));

        log("Confirm popup message");
        System.out.println("Confirm popup message");
        String currentMessage = driver.findElement(productMessageBoxLocator).getText();
        Assert.assertEquals(currentMessage, saveProductPopupMessage, "Unexpected popup message");
        driver.findElement(popupOkBtnLocator).click();

//        log("Check displayed page with the created WH name");
//        final Wait<WebDriver> wait1 = new WebDriverWait(driver, timeoutVariable).withMessage("Waiting popup is not hidden for a long time");
//        wait1.until(ExpectedConditions.elementToBeClickable(filterProductsFieldLocator));
    }
}
