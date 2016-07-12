package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ihor on 7/11/2016.
 */
public class ViewOrderPage extends BrowserSettings {
    public WebDriver driver;

    public ViewOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstOrderFromTheListLocator = By.xpath("//tbody//tr[2]/td/a");
    private By orderSummaryTabLocator = By.xpath("//aside[@id='leftNav']//li[1]/a");
    private By customerInfoTabLocator = By.xpath("//aside[@id='leftNav']//li[2]/a");
    private By customerNumberFieldLocator = By.xpath("//input[@id='customerNumber']");
    private By orderedSKUFieldLocator = By.xpath("//tbody//td[1]//input");
    private By orderedQtyListLocator = By.xpath("//tbody//td[3]//input");

    private By orderedSkuListLocator = By.xpath("//div[@id='ship_items_list']//span[1]");


    private By listOfOrderedQtyLocator = By.xpath("//div[@name=\"shipment_items_area\"]//ul//input[@id='shipmentQty']");
    private By listOfOrderedSkuLocator = By.xpath("//div[@name='shipment_items_area']//ul//div[@class='skuValue']//span");

    public void openViewOrderPage() throws InterruptedException {
        totalResultMessage += "Open 'View Order' page\n";
        Thread.sleep(2000);
        driver.findElement(firstOrderFromTheListLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'View Order' page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(orderSummaryTabLocator));
    }

    public void getCustomerInfo() {
        totalResultMessage += "Get Customer Info\n";
        driver.findElement(customerInfoTabLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Customer Number' field is not displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerNumberFieldLocator));
        orderedCustomerNumber = driver.findElement(customerNumberFieldLocator).getText();
    }
    public void getOrderItemsInfo() {

    }

}
