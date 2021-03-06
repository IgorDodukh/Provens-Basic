package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.ProgressBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class MainPage extends BrowserSettings {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By customersMenuButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/a");
    private By addCustomerMenuButtonLocator = By.xpath("//li/a[@href='/web/Customer/CreateCustomerView']");

    private By productsMenuButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[2]");
    private By addProductMenuButtonLocator = By.xpath("//li/a[@href='/web/Product/ProductCreate']");

    private By suppliersMenuButtonLocator = By.xpath("//li/a[@href='/web/Product/SearchSupplier']");
    private By addSupplierButtonLocator = By.xpath("//button[@id='add_supplier']");
    private By supplierAccountNumberFieldLocator = By.xpath("//input[@id='acct_no']");

    private By customersGridButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/ul/li[1]/a");
    private By customerInfoTabLocator = By.xpath("//h2[@tooltipid='Customer_CustomerInfo']");

    private By headerMenuLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[4]/a");
    private By searchWarehouseButtonLocator = By.xpath("//a[@href='/web/Inventory/SearchWarehouse']");
    private By addWarehouseButtonLocator = By.xpath("//button[@tooltipid='addWarehouse']");
    private By addPageBreadcrumpLocator = By.xpath("//*[@id='breadCrumb']/ul/li[2]/h1");

    private By addCustomerPageTitleLocator = By.xpath("//*[@class='tabContainer columns']//h2/strong");
    private By productInfoTabLocator = By.xpath("//*[@id='productInfoTab']");

    private By setupButtonLocator = By.xpath("//li[@id='Help'][2]");
    private By settingsButtonLocator = By.xpath("//a[@href='/web/Configuration/ConfigurationManagement']");
    private By thirdPartyConnectionsButtonLocator = By.xpath("//a[@href='/web/Configuration/ThirdPartyConnectionsManagement']");
    private By shippingMethodsButtonLocator = By.xpath("//a[@href='/web/Configuration/ShippingMethods']");
    private By basicSettingTitleLocator = By.xpath("//section[@id='basicSettingTabpage']/div[1]");
    private By authorizeNetTitleLocator = By.xpath("//section[@id='paymentGateTabpage']/div[1]");
    private By siteLogoIconLocator = By.xpath("//img[@src='/web/Content/Images/nextgen_logo-white.png']");

    private By shippingMethodsPageTitleLocator = By.xpath("//button[@id='btnShippingMethods']");
    private By addShippingMethodButtonLocator = By.xpath("//button[@id='add_shippingMethod']");

    private By orderProcessingTabLocator = By.xpath("//aside[@id='leftNav']//li[4]");

    private By inventoryMenuButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[4]");
    private By binsButtonLocator = By.xpath("//a[@href='/web/Inventory/SearchWarehouseBin']");
    private By productInventoryButtonLocator = By.xpath("//a[@href='/web/Inventory/ProductInventory']");
    private By addBinButtonLocator = By.xpath("//button[@id='add_bin']");
    private By productInventoryFilterByFieldLocator = By.xpath("//label/input");

    private By ordersMenuButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[3]");
    private By viewAllOrdersMenuButtonLocator = By.xpath("//li/a[@href='/web/Order/SearchOrderAdvance']");
    private By allOrdersTabButtonLocator = By.xpath("//section[@id='tabsSection']/button[6]");

    private By syncButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[7]");

    public void openAddCustomerPage() {
        totalResultMessage += "Open 'Add Customer' page\n";
        driver.findElement(customersMenuButtonLocator).click();
        driver.findElement(addCustomerMenuButtonLocator).click();
        Assert.assertEquals(driver.findElement(customerInfoTabLocator).isDisplayed(), true, "Customer creating page is not loaded");
        ProgressBar.addProgressValue(progressVariable);
    }

// --Commented out by Inspection START (7/14/2016 10:10 PM):
//    public void openCustomersGrid () {
//        totalResultMessage += "Open Customers grid\n";
//        driver.findElement(customersMenuButtonLocator).click();
//        driver.findElement(customersGridButtonLocator).click();
//    }
// --Commented out by Inspection STOP (7/14/2016 10:10 PM)

    public void openAddWarehousePage () {
        totalResultMessage += "Open 'Add Warehouse' page\n";
        driver.findElement(headerMenuLocator).click();
        driver.findElement(searchWarehouseButtonLocator).click();
        driver.findElement(addWarehouseButtonLocator).click();
        Assert.assertEquals(driver.findElement(addPageBreadcrumpLocator).getText(), "Add", "Warehouse creating page is not loaded");
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openAddProductPage() throws InterruptedException {
        totalResultMessage += "Open 'Add Product' page\n";
        driver.findElement(productsMenuButtonLocator).click();
        driver.findElement(addProductMenuButtonLocator).click();
        Assert.assertEquals(driver.findElement(addPageBreadcrumpLocator).getText(), "Add", "Customer creating page is not loaded");
        Assert.assertEquals(driver.findElement(addCustomerPageTitleLocator).getText(), "Product Details", "Unexpected page title");
        ProgressBar.addProgressValue(progressVariable);
        Thread.sleep(5000);
    }

    public void openSetUpPage() {
        totalResultMessage += "Open 'Settings' page\n";
        driver.findElement(setupButtonLocator).click();
        driver.findElement(settingsButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Basic Settings' page popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(basicSettingTitleLocator));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(orderProcessingTabLocator));
        Assert.assertEquals(element.isDisplayed(), true, "'Basic Settings' page title was not found");
        Assert.assertEquals(element2.isDisplayed(), true, "'Basic Settings' page was not loaded");
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openMainPage() {
        totalResultMessage += "Navigate to Main Page\n";
        driver.findElement(siteLogoIconLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Main Page is loaded for a long time");
        wait2.until(ExpectedConditions.elementToBeClickable(siteLogoIconLocator));
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openShippingMethodsPage() throws InterruptedException {
        totalResultMessage += "Open 'Shipping Methods' page\n";
        driver.findElement(setupButtonLocator).click();
        driver.findElement(shippingMethodsButtonLocator).click();
        ProgressBar.addProgressValue(progressVariable);

        Thread.sleep(2000);
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Shipping Methods' page popup was not loaded");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addShippingMethodButtonLocator));
        Assert.assertEquals(element.isDisplayed(), true, "'Shipping Methods' page title was not found");
    }

    public void openSuppliersPage() {
        totalResultMessage += "Open 'Suppliers' page\n";
        ProgressBar.addProgressValue(5);
        driver.findElement(productsMenuButtonLocator).click();
        driver.findElement(suppliersMenuButtonLocator).click();
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openAddSupplierPage() {
        totalResultMessage += "Open 'Add Supplier' page\n";
        ProgressBar.addProgressValue(5);
        driver.findElement(addSupplierButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Add Supplier' page popup was not loaded");
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(supplierAccountNumberFieldLocator));
        Assert.assertEquals(element.isDisplayed(), true, "'Shipping Methods' page title was not found");
        ProgressBar.addProgressValue(progressVariable);
    }

// --Commented out by Inspection START (7/14/2016 10:10 PM):
//    public void openBinsPage() {
//        totalResultMessage += "Open 'Bins' page\n";
//        driver.findElement(inventoryMenuButtonLocator).click();
//        driver.findElement(binsButtonLocator).click();
//        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Bins' page popup was not loaded");
//        wait.until(ExpectedConditions.elementToBeClickable(addBinButtonLocator));
//    }
// --Commented out by Inspection STOP (7/14/2016 10:10 PM)

// --Commented out by Inspection START (7/14/2016 10:10 PM):
//    public void openInventoryPage() {
//        totalResultMessage += "Open 'Product Inventory' page\n";
//        driver.findElement(inventoryMenuButtonLocator).click();
//        driver.findElement(productInventoryButtonLocator).click();
//        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Product Inventory' page popup was not loaded");
//        wait.until(ExpectedConditions.elementToBeClickable(productInventoryFilterByFieldLocator));
//    }
// --Commented out by Inspection STOP (7/14/2016 10:10 PM)

    public void openOrdersGrid() throws InterruptedException {
        totalResultMessage += "Open 'Orders' grid\n";
        driver.findElement(ordersMenuButtonLocator).click();
        driver.findElement(viewAllOrdersMenuButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Orders' grid was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(siteLogoIconLocator));
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Select 'All' tab\n";
        Thread.sleep(2000);
        driver.findElement(allOrdersTabButtonLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("'All Orders' grid was not loaded");
        wait2.until(ExpectedConditions.elementToBeClickable(allOrdersTabButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openSyncPage() {
        totalResultMessage += "Open 'Sync' page\n";
        driver.findElement(syncButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Sync' page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(siteLogoIconLocator));
    }
}
