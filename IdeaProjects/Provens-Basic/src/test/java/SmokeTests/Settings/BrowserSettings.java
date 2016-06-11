package SmokeTests.Settings;

import SmokeTests.Pages.LoginPage;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by igor on 17.04.16.
 */

public class BrowserSettings {
    public WebDriver driver;

    private GenerateRandomData generateRandomData = new GenerateRandomData();

    private ArrayList<String> enviroment = new ArrayList<String>(
            Arrays.asList("https://qa01.freestylecommerce.info/web/",
                    "https://qa03.freestylecommerce.info/web/",
                    "https://qa05.freestylecommerce.info/web/",
                    "https://my.freestylecommerce.com/web/"));


    //protected String email = "themerchant@dydacomp.biz";
    protected String email = "newadmin@dydacomp.biz";
    protected String merchantPassword = "78qa22!#";
//    protected String userAlreadyLoggedMsg = "This user is already logged in. Do you want to log off the active session?";

    protected String firstName = "TesterFirstName_" + generateRandomData.generateRandomNumber(4);
    protected String lastName = "TesterLastName_" + generateRandomData.generateRandomNumber(4);
    protected String phone = generateRandomData.generateRandomNumber(10);
    protected String billingAddressTitle = "Billing Address";
    protected String addressFirstName = "TesterBillingFirstName_11";
    protected String addressLastName = "TesterBillingLastName_11";
    protected String addressLine1 = "Tester Billing Address Line 11";
    protected String addressZip = "10113";

    protected String shippingAddressTitle = "Shipping Address";
    protected String paymentMethodsTitle = "Payment Method";
    protected String visaTestCardNumber = "4005550000000019";
    protected String addCustomerPopupMessage = "The customer has been successfully created.";
    protected String saveSettingsPopupMessage = "Configuration has been saved successfully.";


    protected String warehouseName = "Test Warehouse4" + generateRandomData.generateRandomNumber(3);
    protected String warehouseContactName = "Test Warehouse Contact Name";
    protected String startPickupTime = "08:00";
    protected String endPickupTime = "21:00";

    protected String newBinName = "Test Warehouse Bin";
    protected String saveWarehousePopupMessage = "Save warehouse successfully";

    protected String productSku = "Product SKU" + generateRandomData.generateRandomNumber(4);
    protected String productWeight = generateRandomData.generateRandomNumber(1);
    protected String productDescription = productSku + generateRandomData.generateRandomString(10);
    protected String productRetailPrice = generateRandomData.generateRandomNumber(3);
    protected String productSalesChannel = "Call Center";

    //    Authorize credentials
    protected String authApiLoginId = "3y8Z2fk5Z3n";
    protected String authTransactionKey = "2s25qyDYe249uTRx";

    //    UPS credentials
    protected String upsUserName = "Dev.api@dydacomp";
    protected String upsPassword = "7xy7mZBcXYEKw358gCKrDaqqeX";
    protected String upsLicenseNumber = "0C8701ECC4023070";
    protected String upsShipperNumber = "08611E";

    //    USPS credentials
    protected String uspsAccountId = "2502974";
    protected String uspsPassPhrase = "EliManningHOF!1?";

    //    create UPS Ground shipping method
    protected String upsGroundMethodName = "UPS Ground" + generateRandomData.generateRandomNumber(2);
    protected String shippingMethodPrice = generateRandomData.generateRandomNumber(1);

    @BeforeTest
    public void setUp(int envIndex) {
        driver = new FirefoxDriver();
        driver.get(enviroment.get(envIndex));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass

    public void tearDown() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logOutUser();
        driver.close();
    }

    protected void log(String message) {
        Reporter.log(new Date().toString() + "\t" + message + "\n");
    }
}
