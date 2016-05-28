package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class AddCustomerPage extends BrowserSettings {
    private WebDriver driver;

    public AddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameFieldLocator = By.xpath("//input[@id='customer_first_name']");
    private By lastNameFieldLocator = By.xpath("//input[@id='customer_last_name']");
    private By emailFieldLocator = By.xpath("//input[@id='customer_email']");
    private By phoneFieldLocator = By.xpath("//input[@id='customer_phone']");

    private By billingAddressTabLocator = By.xpath("//*[@id='tabBillingAddresses']");
    private By billingAddressTitleLocator = By.xpath("(//*[@class='columns colx_h2'])[1]");
    private By getBillingAddressBtnLocator = By.xpath("//a[@id='addNewBillingAddressBtn']");
    private By newBillingAddressSectionLocator = By.xpath("//div[@id='new_billing_address_section_basic']");
    private By billingAddressFirstNameLocator = By.xpath("//input[@id='first_name_basic']");
    private By billingAddressLastNameLocator = By.xpath("//input[@id='last_name_basic']");
    private By billingAddressAddr1Locator = By.xpath("//input[@id='address_basic']");
    private By billingAddressZipLocator = By.xpath("//input[@id='zip_basic']");

    private By sameAsBillingButtonLocator = By.xpath("(//input[@class='sameAddBtn primary-button sameBillingAddBtn'])[3]");

    private By shippingAddressTabLocator = By.xpath("//*[@id='tabShippingAddresses']");
    private By shippingAddressTitleLocator = By.xpath("(//*[@class='columns colx_h2'])[2]");
    private By getShippingAddressBtnLocator = By.xpath("//a[@id='addNewshippingAddressBtn']");
    private By newShippingAddressSectionLocator = By.xpath("(//div[@id='new_billing_address_section_basic'])[3]");

    private By paymentDetailsTabLocator = By.xpath("//li[@id='tabPaymentMethods']");
    private By paymentDetailsTabTitleLocator = By.xpath("//*[@tooltipid='Customer_PaymentMethods']");
    private By addNewCardBtnLocator = By.xpath("//*[@id='linkAddNewCard']");
    private By cardStackLocator = By.xpath("(//*[@class='card stack'])[2]");
    private By cardNumberFieldLocator = By.xpath("(//*[@name='card_no'])[2]");
    private By cardExpiredYearLocator = By.xpath("(//*[@id='card_expYear'])[2]/option[7]");
    private By saveCardLinkLocator = By.xpath("(//*[@id='linkSaveCard'])[2]");
    private By editCardLinkLocator = By.xpath("(//*[@id='linkEditCard'])[2]");
//    private By saveContextualButton = By.xpath("//a[@id='btnSave']");
    private By saveAndCloseContextualButtonLocator = By.xpath("//a[@id='btnSaveAndClose']");
    private By popupBoxMessageLocator = By.xpath("(//div[@id='customerMessageBox']//*)[1]");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");


    private By filterCustomersFieldLocator = By.xpath("//*[@aria-controls='searchCustomerResult']");
    private By customerNameInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[4]");
    private By customerEmailInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[5]");
    private By customerAddressInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[7]");
    private By customerCityInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[8]");
//    private By customerStateInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[9]");
    private By customerZipInTheGridLocator = By.xpath("((//*[@id='searchCustomerResult'])//tbody/tr/*)[10]/div[1]");

    private By waitingPopupLocator = By.xpath("//*[@id='waitingPopup']");
    private By waitingPopupTextLocator = By.xpath("//*[@id='waitingPopup']//*[@id='waiting-popup-text']");
    private By numberOfCustomersLocator = By.xpath("//*[@id='searchCustomerResult']//tbody/tr");


    public void addCustomerInfo(String customerFirstName, String customerLastName, String customerEmail, String customerPhone) {
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
        emailField.sendKeys(customerEmail);

        log("Add phone");
        WebElement phoneField = driver.findElement(phoneFieldLocator);
        phoneField.clear();
        phoneField.click();
        phoneField.sendKeys(customerPhone);
    }
    public void addBillingAddress(String billingFirstName, String billingLastName, String billingAddressLine1, String billingZip) {
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
        billingFirstNameField.sendKeys(billingFirstName);

        log("Add Billing Address Last Name");
        WebElement billingLastNameField = driver.findElement(billingAddressLastNameLocator);
        billingLastNameField.clear();
        billingLastNameField.click();
        billingLastNameField.sendKeys(billingLastName);

        log("Add Billing Address Address line 1");
        WebElement billingAddressLine1Field = driver.findElement(billingAddressAddr1Locator);
        billingAddressLine1Field.clear();
        billingAddressLine1Field.click();
        billingAddressLine1Field.sendKeys(billingAddressLine1);

        log("Add Billing Address Zip");
        WebElement billingZipField = driver.findElement(billingAddressZipLocator);
        billingZipField.clear();
        billingZipField.click();
        billingZipField.sendKeys(billingZip);
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

    public void addCreditCard(String testCardNumber) throws InterruptedException {
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
        cardNumberField.sendKeys(testCardNumber);

        driver.findElement(cardExpiredYearLocator).click();
        driver.findElement(saveCardLinkLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, 10).withMessage("Waiting popup is not hidden for a long time");
        wait.until(ExpectedConditions.elementToBeClickable(editCardLinkLocator));

        Assert.assertEquals(driver.findElement(editCardLinkLocator).isDisplayed(), true, "Credit card is not saved");
    }

    public void saveNewCustomer() throws InterruptedException {
        log("Save new Customer");
        log("Click 'Save and Close' button");
        driver.findElement(saveAndCloseContextualButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, 5).withMessage("Confirmation popup was not found");
        wait.until(ExpectedConditions.visibilityOfElementLocated(popupBoxMessageLocator));

        String currentPopupMessage = driver.findElement(popupBoxMessageLocator).getText();
        Assert.assertEquals(currentPopupMessage, addCustomerPopupMessage, "Unexpected popup message");
        driver.findElement(popupOkBtnLocator).click();
    }

    public void searchNewCustomerInTheGrid (String customerFirstName) throws InterruptedException {
        log("Search new Customer in the grid");
        WebElement searchField = driver.findElement(filterCustomersFieldLocator);
        searchField.clear();
        searchField.click();
        searchField.sendKeys(customerFirstName);
        searchField.sendKeys(Keys.ENTER);

        int numberOfElements = driver.findElements(numberOfCustomersLocator).size();

        final Wait<WebDriver> wait = new WebDriverWait(driver, 2).withMessage("Waiting popup was not found");
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(numberOfCustomersLocator, numberOfElements));

        log("Compare Customer's data from the grid");
        Assert.assertEquals(driver.findElement(customerNameInTheGridLocator).getText(), firstName + " " + lastName, "Unexpected Customer name");
        Assert.assertEquals(driver.findElement(customerEmailInTheGridLocator).getText(), email, "Unexpected Customer Email");
        Assert.assertEquals(driver.findElement(customerAddressInTheGridLocator).getText(), addressLine1, "Unexpected Customer address");
        Assert.assertEquals(driver.findElement(customerZipInTheGridLocator).getText(), addressZip, "Unexpected Customer Zip");
    }
}
