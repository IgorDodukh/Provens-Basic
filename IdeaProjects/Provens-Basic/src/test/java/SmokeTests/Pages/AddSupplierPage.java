package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Ihor on 6/27/2016.
 */
public class AddSupplierPage extends BrowserSettings {
    private WebDriver driver;

    public AddSupplierPage(WebDriver driver) {
        this.driver = driver;
    }

    private By supplierAccountNumberFieldLocator = By.xpath("//input[@id='acct_no']");
    private By supplierNameFieldLocator = By.xpath("//input[@id='supplier_name']");
    private By supplierURLFieldLocator = By.xpath("//input[@id='siteURL']");
    private By supplierAddressFieldLocator = By.xpath("//input[@id='address']");
    private By supplierZipFieldLocator = By.xpath("//input[@id='zip']");

    private By supplierEmailToFieldLocator = By.xpath("//input[@id='email_to']");
    private By supplierEmailBCCFieldLocator = By.xpath("//input[@id='email_bcc']");
    private By supplierEmailCCFieldLocator = By.xpath("//input[@id='email_cc']");

    private By contactFirstNameFieldLocator = By.xpath("//input[@id='zip']");
    private By contactLastNameFieldLocator = By.xpath("//input[@id='zip']");
    private By contactPhoneFieldLocator = By.xpath("//input[@id='zip']");
    private By contactEmailFieldLocator = By.xpath("//input[@id='zip']");
    private By contactJobTitleFieldLocator = By.xpath("//input[@id='zip']");
    private By contactFaxFieldLocator = By.xpath("//input[@id='zip']");


    public void addSupplierContactInfo(String accountNumber, String name, String url, String address1, String zip, String email, String first, String last) {
        totalResultMessage += "Adding Supplier info:\n";
        totalResultMessage += " - Add Supplier Account Number\n";
        WebElement accountNumberField = driver.findElement(supplierAccountNumberFieldLocator);
        accountNumberField.clear();
        accountNumberField.sendKeys(accountNumber);

        totalResultMessage += " - Add Supplier Name\n";
        WebElement nameField = driver.findElement(supplierNameFieldLocator);
        nameField.clear();
        nameField.sendKeys(name);

        totalResultMessage += " - Add Supplier URL\n";
        WebElement urlField = driver.findElement(supplierURLFieldLocator);
        urlField.clear();
        urlField.sendKeys(url);

        totalResultMessage += " - Add Supplier Address\n";
        WebElement addressField = driver.findElement(supplierAddressFieldLocator);
        addressField.clear();
        addressField.sendKeys(address1);

        totalResultMessage += " - Add Supplier Zip code\n";
        WebElement zipField = driver.findElement(supplierZipFieldLocator);
        zipField.clear();
        zipField.sendKeys(zip);

        totalResultMessage += " - Add Supplier Email To\n";
        WebElement emailToField = driver.findElement(supplierEmailToFieldLocator);
        emailToField.click();
        emailToField.clear();
        emailToField.sendKeys(email);

        totalResultMessage += " - Add Supplier Email BCC\n";
        WebElement emailBccField = driver.findElement(supplierEmailBCCFieldLocator);
        emailBccField.clear();
        emailBccField.sendKeys(email);

        totalResultMessage += " - Add Supplier Email CC\n";
        WebElement emailCcField = driver.findElement(supplierEmailCCFieldLocator);
        emailCcField.clear();
        emailCcField.sendKeys(email);

        totalResultMessage += " - Add Contact First Name\n";
        WebElement firstNameField = driver.findElement(contactFirstNameFieldLocator);
        firstNameField.clear();
        firstNameField.sendKeys(first);

        totalResultMessage += " - Add Contact Last Name\n";
        WebElement lastNameField = driver.findElement(contactLastNameFieldLocator);
        lastNameField.clear();
        lastNameField.sendKeys(last);

        totalResultMessage += " - Add Contact Job Title\n";
        WebElement jobTitleField = driver.findElement(contactJobTitleFieldLocator);
        jobTitleField.clear();
        jobTitleField.sendKeys("QA");

        totalResultMessage += " - Add Contact Phone\n";
        WebElement phoneField = driver.findElement(contactPhoneFieldLocator);
        phoneField.clear();
        phoneField.sendKeys("8888888888");

        totalResultMessage += " - Add Contact Email\n";
        WebElement emailField = driver.findElement(contactEmailFieldLocator);
        emailField.clear();
        emailField.sendKeys(email);

        totalResultMessage += " - Add Contact Fax\n";
        WebElement faxField = driver.findElement(contactFaxFieldLocator);
        faxField.clear();
        faxField.sendKeys("4444444444");
    }
}
