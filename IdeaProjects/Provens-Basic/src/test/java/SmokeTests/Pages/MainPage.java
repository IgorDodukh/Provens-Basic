package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    By customersMenuButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/a");
    By addCustomerMenuButtonLocator = By.xpath("//li/a[@href='/web/Customer/CreateCustomerView']");

    By productsMenuButtonLocator = By.xpath("//*[@class='nav navbar-nav']/li[2]");
    By addProductMenuButtonLocator = By.xpath("//li/a[@href='/web/Product/ProductCreate']");

    By customersGridButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/ul/li[1]/a");
    By customerInfoTabLocator = By.xpath("//h2[@tooltipid='Customer_CustomerInfo']");

    By headerMenuLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[4]/a");
    By searchWarehouseButtonLocator = By.xpath("//a[@href='/web/Inventory/SearchWarehouse']");
    By addWarehouseButtonLocator = By.xpath("//button[@tooltipid='addWarehouse']");
    By addPageBreadcrumpLocator = By.xpath("//*[@id='breadCrumb']/ul/li[2]/h1");

    By addCustomerPageTitleLocator = By.xpath("//*[@class='tabContainer columns']//h2/strong");
    By productInfoTabLocator = By.xpath("//*[@id='productInfoTab']");


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
}
