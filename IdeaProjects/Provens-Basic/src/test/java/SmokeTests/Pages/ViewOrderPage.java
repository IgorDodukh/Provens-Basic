package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.ProgressBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

/**
 * Created by Ihor on 7/11/2016.
 */
public class ViewOrderPage extends BrowserSettings {
    private WebDriver driver;

    public ViewOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstOrderFromTheListLocator = By.xpath("//tbody//tr[2]/td/a");
    private By orderSummaryTabLocator = By.xpath("//aside[@id='leftNav']//li[1]/a");
    private By customerNameLocator = By.xpath("//tbody//tr[2]/td[4]");
    private By shippingDetailsTabLocator = By.xpath("//aside[@id='leftNav']//li[4]/a");
    private By paymentDetailsTabLocator = By.xpath("//aside[@id='leftNav']//li[6]/a");
    private By customerNumberFieldLocator = By.xpath("//input[@id='customerNumber']");

    private By linkToOrdersGridLocator = By.xpath("//section[@id='titleSection']//li[1]");
    private By addOrderButtonLocator = By.xpath("//a[@href='/web/Order/OrderCreating']");
    private By addItemButtonLocator = By.xpath("//div[@class='input-group-btn']/button[@class='btn btn-default']");

    private By orderedSkuListLocator = By.xpath("//div[@id='ship_items_list']/div//span[1]");

    private By shippingMethodLocator = By.xpath("//section[@class='columns shipping_details shipment ng-scope']//div/p[2]/span[1]");

    public void openViewOrderPage() throws InterruptedException {
        totalResultMessage += "Open 'View Order' page\n";
        Thread.sleep(2000);
        orderedCustomerName = driver.findElement(customerNameLocator).getText();

        int nameLength = orderedCustomerName.length();
        int nameSpace = orderedCustomerName.indexOf(" ");
        StringBuffer buffer = new StringBuffer(orderedCustomerName);
        buffer.replace(nameSpace, nameLength, "");
        orderedCustomerName = Objects.toString(buffer);
        System.out.println(orderedCustomerName);
        ProgressBar.addProgressValue(progressVariable);

        driver.findElement(firstOrderFromTheListLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'View Order' page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(orderSummaryTabLocator));

        shippingMethod = driver.findElement(shippingMethodLocator).getText();
        ProgressBar.addProgressValue(progressVariable);

        System.out.println("Shipping Method " + shippingMethod);
    }

    public void getOrderItemsInfo() {
        totalResultMessage += "Get Ordered Items Info\n";
        driver.findElement(shippingDetailsTabLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Shipping Details' tab is not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(orderSummaryTabLocator));
        orderedItems = driver.findElement(orderedSkuListLocator).getText();

        List<WebElement> totalLinks = driver.findElements(orderedSkuListLocator);
        int totalLinkSize = totalLinks.size();
        ProgressBar.addProgressValue(progressVariable);
        System.out.println("Total Links size : " + totalLinkSize);
        System.out.println("Total Links values : " + orderedItems);
    }

    public void backToOrdersGrid() {
        totalResultMessage += "Back To Orders Grid\n";
        driver.findElement(linkToOrdersGridLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Orders grid is not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(addOrderButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openOrderCreatingForm () throws InterruptedException {
        totalResultMessage += "Open Order creating form\n";
        Thread.sleep(2000);
        driver.findElement(addOrderButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Order creating form is not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(addItemButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }
}
