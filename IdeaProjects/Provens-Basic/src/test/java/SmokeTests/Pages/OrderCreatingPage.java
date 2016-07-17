package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

/**
 * Created by Ihor on 7/16/2016.
 */
public class OrderCreatingPage extends BrowserSettings {
    private WebDriver driver;

    public OrderCreatingPage(WebDriver driver) {
        this.driver = driver;
    }

    int i ;
    String dropdownValue = "";
    String totalValue = "";
    private By addItemButtonLocator = By.xpath("//div[@class='input-group-btn']/button[@class='btn btn-default']");
    private By quickAddFieldLocator = By.xpath("//div[@class='input-group']/input[@placeholder='Quick add']");
    private By addedItemSectionLocator = By.xpath("//tbody[@class='order-item row-with-input ng-scope']");
    private By customerNumberFieldLocator = By.xpath("//input[@id='accountNumber']");
    private By customerLastNameFieldLocator = By.xpath("//input[@id='lastName']");
    private By isExistingCustomerLocator = By.xpath("//div[@class='panel panel-default panel-success']");
    private By selectCustomerButtonLocator = By.xpath("//div[@class='panel panel-default panel-success']//tr[1]/td[3]/a");
    private By shippingMethodDropdownLocator = By.xpath("//button//span[@class='caret']");
    private By shippingMethodMoreButtonLocator = By.xpath("//ul[@class='uib-dropdown-menu dropdown-menu']/li[" + i + "]");
    private By orderTotalValueLocator = By.xpath("//section[@id='Tallys and Buttons']/div/div[2]/strong");
    private By placeOrderButtonLocator = By.xpath("//button[@ng-click='placeOrder()']");
    private By orderSummaryTabLocator = By.xpath("//aside[@id='leftNav']//li[1]/a");


    public void addOrderItems() throws InterruptedException {
        totalResultMessage += "Add Order items\n";
        Thread.sleep(2000);
        driver.findElement(quickAddFieldLocator).sendKeys(orderedItems);
        driver.findElement(addItemButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Item was not added");
        wait.until(ExpectedConditions.visibilityOfElementLocated(addedItemSectionLocator));
    }

    public void addCustomer() {
        totalResultMessage += "Add Customer to the Order\n";
        driver.findElement(customerNumberFieldLocator).sendKeys(orderedCustomerNumber);
        driver.findElement(customerLastNameFieldLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Is Existing Customer' popup not appear");
        wait.until(ExpectedConditions.visibilityOfElementLocated(isExistingCustomerLocator));

        driver.findElement(selectCustomerButtonLocator).click();
    }

    public void selectShippingMethod() {
        totalResultMessage += "Select Shipping Method\n";
        driver.findElement(shippingMethodDropdownLocator).click();

        for (i = 1; i < 10; i++){
            dropdownValue = driver.findElement(shippingMethodMoreButtonLocator).getText();
            if (Objects.equals(dropdownValue, shippingMethod)) {
                driver.findElement(shippingMethodMoreButtonLocator).click();
                break;
            }
        }

        totalResultMessage += "Wait Order Total value\n";
        while (true){
            totalValue = driver.findElement(orderTotalValueLocator).getText();
            if(!Objects.equals(totalValue, "--")){
                break;
            }
        }
    }

    public void placeOrder() {
        totalResultMessage += "Click 'Place Order' button\n";
        driver.findElement(placeOrderButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Edit Order' page is not appear");
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderSummaryTabLocator));

    }
}
