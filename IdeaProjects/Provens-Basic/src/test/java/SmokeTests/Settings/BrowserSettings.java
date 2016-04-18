package SmokeTests.Settings;

import SmokeTests.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by igor on 17.04.16.
 */
public class BrowserSettings {
    protected WebDriver driver;
    protected String merchantEmail = "themerchant@dydacomp.biz";
    protected String merchantPassword = "78qa22!#";
//    protected String userAlreadyLoggedMsg = "This user is already logged in. Do you want to log off the active session?";
    protected String customerFirstName = "TesterFirstName_11";
    protected String customerLastName = "TesterLastName_11";
    protected String customerPhone = "1234567890";
    protected String billingAddressTitle = "Billing Address";
    protected String billingAddressFirstName = "TesterBillingFirstName_11";
    protected String billingAddressLastName = "TesterBillingLastName_11";
    protected String billingAddressAddrLine1 = "Tester Billing Address Line 11";
    protected String billingAddressZip = "10113";

    protected String shippingAddressTitle = "Shipping Address";
    protected String paymentMethodsTitle = "Payment Method";
    protected String visaTestCardNumber = "4005550000000019";
    protected String addCustomerPopupMessage = "The customer has been successfully created.";


    @BeforeTest
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("https://qa03.freestylecommerce.info/web/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass

    public void tearDown() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOutUser();

        driver.close();
    }
    public void log(String message) {
        Reporter.log(new Date().toString() + "\t" + message + "\n");
    }
}
