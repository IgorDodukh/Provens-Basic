package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class MainPage extends BrowserSettings {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    By customersButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/a");
    By customersGridButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/ul/li[1]/a");
    By addCustomerButtonLocator = By.xpath("//li/a[@href='/web/Customer/CreateCustomerView']");
    By customerInfoTabLocator = By.xpath("//h2[@tooltipid='Customer_CustomerInfo']");

    By headerMenuLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[4]/a");
    By searchWarehouseButtonLocator = By.xpath("//a[@href='/web/Inventory/SearchWarehouse']");
    By addWarehouseButtonLocator = By.xpath("//button[@tooltipid='addWarehouse']");
    By addPageBreadcrumpLocator = By.xpath("//*[@id='breadCrumb']/ul/li[2]/h1");



    public void openAddCustomerPage() {
        log("Open 'Add customer' page");
        driver.findElement(customersButtonLocator).click();
        driver.findElement(addCustomerButtonLocator).click();
        Assert.assertEquals(driver.findElement(customerInfoTabLocator).isDisplayed(), true, "Customer creating page is not loaded");
    }

    public void openCustomersGrid () {
        log("Open Customers grid");
        driver.findElement(customersButtonLocator).click();
        driver.findElement(customersGridButtonLocator).click();
    }

    public void openAddWarehousePage () {
        log("Open 'Add warehouse' page");
        driver.findElement(headerMenuLocator).click();
        driver.findElement(searchWarehouseButtonLocator).click();
        driver.findElement(addWarehouseButtonLocator).click();
        Assert.assertEquals(driver.findElement(addPageBreadcrumpLocator).getText(), "Add", "Warehouse creating page is not loaded");
        }
}
