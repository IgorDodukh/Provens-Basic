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
 * Created by igor on 17.04.16.
 */
public class MainPage extends BrowserSettings {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By customersMenuButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/a");
    private By addCustomerMenuButtonLocator = By.xpath("//li/a[@href='/web/Customer/CreateCustomerView']");

    private By productsMenuButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[2]");
    private By addProductMenuButtonLocator = By.xpath("//li/a[@href='/web/Product/ProductCreate']");

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
    private By siteLogoIconLocator = By.xpath("//img[@id='logoIcon']");

    private By shippingMethodsPageTitleLocator = By.xpath("//button[@id='btnShippingMethods']");

    private By orderProcessingTabLocator = By.xpath("//aside[@id='leftNav']//li[4]");



    public void openAddCustomerPage() {
        log("Open 'Add customer' page");
        driver.findElement(customersMenuButtonLocator).click();
        driver.findElement(addCustomerMenuButtonLocator).click();
        Assert.assertEquals(driver.findElement(customerInfoTabLocator).isDisplayed(), true, "Customer creating page is not loaded");
    }

    public void openCustomersGrid () {
        log("Open Customers grid");
        driver.findElement(customersMenuButtonLocator).click();
        driver.findElement(customersGridButtonLocator).click();
    }

    public void openAddWarehousePage () {
        log("Open 'Add warehouse' page");
        driver.findElement(headerMenuLocator).click();
        driver.findElement(searchWarehouseButtonLocator).click();
        driver.findElement(addWarehouseButtonLocator).click();
        Assert.assertEquals(driver.findElement(addPageBreadcrumpLocator).getText(), "Add", "Warehouse creating page is not loaded");
        }

    public void openAddProductPage() throws InterruptedException {
        driver.findElement(productsMenuButtonLocator).click();
        driver.findElement(addProductMenuButtonLocator).click();
        Assert.assertEquals(driver.findElement(addPageBreadcrumpLocator).getText(), "Add", "Customer creating page is not loaded");
        Assert.assertEquals(driver.findElement(addCustomerPageTitleLocator).getText(), "Product Details", "Unexpected page title");
        Thread.sleep(5000);
    }

    public void openSetUpPage() {
        log("Open 'Settings' page");
        driver.findElement(setupButtonLocator).click();
        driver.findElement(settingsButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Basic Settings' page popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(basicSettingTitleLocator));
        WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(orderProcessingTabLocator));

        Assert.assertEquals(element.isDisplayed(), true, "'Basic Settings' page title was not found");
        Assert.assertEquals(element2.isDisplayed(), true, "'Basic Settings' page was not loaded");

    }

    public void openThirdPartyConnectionsPage() {
        log("Open 'Third Party Connections' page");
        driver.findElement(setupButtonLocator).click();
        driver.findElement(thirdPartyConnectionsButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Third Party Connections' page popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(authorizeNetTitleLocator));

        Assert.assertEquals(element.isDisplayed(), true, "'Third Party Connections' page title was not found");
    }

    public void openMainPage() {
        log("Navigate to Main Page");
        driver.findElement(siteLogoIconLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Main Page is loaded for a long time");
        wait2.until(ExpectedConditions.elementToBeClickable(siteLogoIconLocator));
    }

    public void openShippingMethodsPage() {
        log("Open 'Shipping Methods' page");
        driver.findElement(setupButtonLocator).click();
        driver.findElement(shippingMethodsButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Shipping Methods' page popup was not found");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodsPageTitleLocator));

        Assert.assertEquals(element.isDisplayed(), true, "'Shipping Methods' page title was not found");
    }
}
