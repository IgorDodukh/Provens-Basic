package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class AddCustomerPage extends BrowserSettings {
    public WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    By customersButtonLocator = By.xpath(".//*[@id='HUD']/nav[2]/div/ul/li[1]/a");
    By addCustomerButtonLocator = By.xpath("//li/a[@href='/web/Customer/CreateCustomerView']");
    By customerInfoTabLocator = By.xpath("//h2[@tooltipid='Customer_CustomerInfo']");
    By firstNameFieldLocator = By.xpath("//input[@id='customer_first_name']");
    By lastNameFieldLocator = By.xpath("//input[@id='customer_last_name']");
    By emailFieldLocator = By.xpath("//input[@id='customer_email']");
    By phoneFieldLocator = By.xpath("//input[@id='customer_phone']");

    By billingAddressTabLocator = By.xpath("//*[@id='tabBillingAddresses']");
    By billingAddressTitleLocator = By.xpath("(//*[@class='columns colx_h2'])[1]");
    By getBillingAddressBtnLocator = By.xpath("//a[@id='addNewBillingAddressBtn']");
    By newBillingAddressSectionLocator = By.xpath("//div[@id='new_billing_address_section_basic']");
    By billingAddressFirstNameLocator = By.xpath("//input[@id='first_name_basic']");
    By billingAddressLastNameLocator = By.xpath("//input[@id='last_name_basic']");
    By billingAddressAddr1Locator = By.xpath("//input[@id='address_basic']");
    By billingAddressZipLocator = By.xpath("//input[@id='zip_basic']");

    By sameAsBillingButtonLocator = By.xpath("(//input[@class='sameAddBtn primary-button sameBillingAddBtn'])[3]");

    By shippingAddressTabLocator = By.xpath("//*[@id='tabShippingAddresses']");
    By shippingAddressTitleLocator = By.xpath("(//*[@class='columns colx_h2'])[2]");
    By getShippingAddressBtnLocator = By.xpath("//a[@id='addNewshippingAddressBtn']");
    By newShippingAddressSectionLocator = By.xpath("(//div[@id='new_billing_address_section_basic'])[3]");

    By paymentDetailsTabLocator = By.xpath("//li[@id='tabPaymentMethods']");
    By paymentDetailsTabTitleLocator = By.xpath("//*[@tooltipid='Customer_PaymentMethods']");
    By addNewCardBtnLocator = By.xpath("//*[@id='linkAddNewCard']");
    By cardStackLocator = By.xpath("(//*[@class='card stack'])[2]");
    By cardNumberFieldLocator = By.xpath("(//*[@name='card_no'])[2]");
    By cardExpiredYearLocator = By.xpath("(//*[@id='card_expYear'])[2]/option[7]");
    By saveCardLinkLocator = By.xpath("(//*[@id='linkSaveCard'])[2]");
    By editCardLinkLocator = By.xpath("(//*[@id='linkEditCard'])[2]");
//    By saveContextualButton = By.xpath("//a[@id='btnSave']");
    By saveAndCloseContextualButtonLocator = By.xpath("//a[@id='btnSaveAndClose']");
    By popupBoxMessageLocator = By.xpath("(//div[@id='customerMessageBox']//*)[1]");
    By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");


    By filterCustomersFieldLocator = By.xpath("//*[@aria-controls='searchCustomerResult']");
    By customerNameInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[4]");
    By customerEmailInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[5]");
    By customerAddressInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[7]");
    By customerCityInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[8]");
//    By customerStateInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[9]");
    By customerZipInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[10]/div[1]");


    public void openAddCustomerPage() {
        log("Open 'Add customer' page");
        driver.findElement(customersButtonLocator).click();
        driver.findElement(addCustomerButtonLocator).click();
        Assert.assertEquals(driver.findElement(customerInfoTabLocator).isDisplayed(), true, "Customer creating page is not loaded");
    }

    public void addCustomerInfo() {
        log("Add customer info");
        log("Add First Name");
        WebElement firstNameField = driver.findElement(firstNameFieldLocator);
        firstNameField.clear();
        firstNameField.click();
        firstNameField.sendKeys(customerFirstName);

        log("Add Last Name");
        WebElement lastNameField = driver.findElement(lastNameFieldLocator);
        lastNameField.clear();
        lastNameField.click();
        lastNameField.sendKeys(customerLastName);

        log("Add email");
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.clear();
        emailField.click();
        emailField.sendKeys(merchantEmail);

        log("Add phone");
        WebElement phoneField = driver.findElement(phoneFieldLocator);
        phoneField.clear();
        phoneField.click();
        phoneField.sendKeys(customerPhone);
    }
    public void addBillingAddress() {
        log("Add Billing Address");
        log("Select Billing Address tab");
        driver.findElement(billingAddressTabLocator).click();
        String currentBillingAddressTitle = driver.findElement(billingAddressTitleLocator).getText();
        Assert.assertEquals(currentBillingAddressTitle, billingAddressTitle, "Unexpected Billing Address tab title");

        log("Click 'Add Billing Address' button");
        driver.findElement(getBillingAddressBtnLocator).click();
        Assert.assertEquals(driver.findElement(newBillingAddressSectionLocator).isDisplayed(), true, "Add new billing address form does not appear");

        log("Add Billing Address info");
        log("Add Billing Address First Name");
        WebElement billingFirstNameField = driver.findElement(billingAddressFirstNameLocator);
        billingFirstNameField.clear();
        billingFirstNameField.click();
        billingFirstNameField.sendKeys(billingAddressFirstName);

        log("Add Billing Address Last Name");
        WebElement billingLastNameField = driver.findElement(billingAddressLastNameLocator);
        billingLastNameField.clear();
        billingLastNameField.click();
        billingLastNameField.sendKeys(billingAddressLastName);

        log("Add Billing Address Addr line 1");
        WebElement billingAddrLine1Field = driver.findElement(billingAddressAddr1Locator);
        billingAddrLine1Field.clear();
        billingAddrLine1Field.click();
        billingAddrLine1Field.sendKeys(billingAddressAddrLine1);

        log("Add Billing Address Zip");
        WebElement billingZipField = driver.findElement(billingAddressZipLocator);
        billingZipField.clear();
        billingZipField.click();
        billingZipField.sendKeys(billingAddressZip);
        driver.findElement(newBillingAddressSectionLocator).click();
    }

    public void addShippingAddress() {
        log("Add Shipping Address");
        log("Select Shipping Address tab");
        driver.findElement(shippingAddressTabLocator).click();
        String currentShippingAddressTitle = driver.findElement(shippingAddressTitleLocator).getText();
        Assert.assertEquals(currentShippingAddressTitle, shippingAddressTitle, "Unexpected Shipping Address tab title");

        log("Click 'Add Shipping Address' button");
        driver.findElement(getShippingAddressBtnLocator).click();
        Assert.assertEquals(driver.findElement(newShippingAddressSectionLocator).isDisplayed(), true, "Add new Shipping address form does not appear");

        log("Add Shipping Address info. Same as Billing Address");
        driver.findElement(sameAsBillingButtonLocator).click();
    }

    public void addCreditCard() throws InterruptedException {
        log("Add Credit Card");
        log("Select Payment Methods tab");
        driver.findElement(paymentDetailsTabLocator).click();
        String currentPaymentMethodsTitle = driver.findElement(paymentDetailsTabTitleLocator).getText();
        Assert.assertEquals(currentPaymentMethodsTitle, paymentMethodsTitle, "Unexpected Payment Methods tab title");

        log("Add Credit Card");
        driver.findElement(addNewCardBtnLocator).click();
        Assert.assertEquals(driver.findElement(cardStackLocator).isDisplayed(), true, "New Card stack does not appear");

        log("Add Card info");
        WebElement cardNumberField = driver.findElement(cardNumberFieldLocator);
        cardNumberField.clear();
        cardNumberField.click();
        cardNumberField.sendKeys(visaTestCardNumber);

        driver.findElement(cardExpiredYearLocator).click();
        driver.findElement(saveCardLinkLocator).click();

        Thread.sleep(5000);
        Assert.assertEquals(driver.findElement(editCardLinkLocator).isDisplayed(), true, "New Card is added");
    }

    public void saveNewCustomer() throws InterruptedException {
        log("Save new Customer");
        log("Click 'Save and Close' button");
        driver.findElement(saveAndCloseContextualButtonLocator).click();

        Thread.sleep(2000);

        String currentPopupMessage = driver.findElement(popupBoxMessageLocator).getText();
        Assert.assertEquals(currentPopupMessage, addCustomerPopupMessage, "Unexpected popup message");
        driver.findElement(popupOkBtnLocator).click();
    }

    public void searchNewCustomerInTheGrid () throws InterruptedException {
        log("Search new Customer in the grid");
        WebElement searchField = driver.findElement(filterCustomersFieldLocator);
        searchField.clear();
        searchField.click();
        searchField.sendKeys(customerFirstName);
        searchField.sendKeys(Keys.ENTER);

        Thread.sleep(1000);

        log("Compare Customer's data from the grid");
        Assert.assertEquals(driver.findElement(customerNameInTheGridLocator).getText(), customerFirstName + " " + customerLastName, "Unexpected Customer name");
        Assert.assertEquals(driver.findElement(customerEmailInTheGridLocator).getText(), merchantEmail, "Unexpected Customer Email");
        Assert.assertEquals(driver.findElement(customerAddressInTheGridLocator).getText(), billingAddressAddrLine1, "Unexpected Customer address");
        Assert.assertEquals(driver.findElement(customerZipInTheGridLocator).getText(), billingAddressZip, "Unexpected Customer Zip");
    }
}
