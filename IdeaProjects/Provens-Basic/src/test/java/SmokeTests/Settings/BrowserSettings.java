package SmokeTests.Settings;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

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

    //    List of Environments
    private ArrayList<String> enviroment = new ArrayList<String>(
            Arrays.asList("https://qa01.freestylecommerce.info/web/",
                    "https://qa03.freestylecommerce.info/web/",
                    "https://qa05.freestylecommerce.info/web/",
                    "https://my.freestylecommerce.com/web/"));

//    protected String userAlreadyLoggedMsg = "This user is already logged in. Do you want to log off the active session?";

//    Customer data
    public String firstName = "FirstName_" + generateRandomData.generateRandomNumber(4);
    public String lastName = "LastName_" + generateRandomData.generateRandomNumber(4);
    protected String customerEmail = firstName + "@dydacomp.biz";
    protected String phone = generateRandomData.generateRandomNumber(10);

//    Billing Address data
    protected String billingAddressTitle = "Billing Address";
    protected String addressFirstName = "TesterBillingFirstName";
    protected String addressLastName = "TesterBillingLastName";
    protected String addressLine1 = "Tester Billing Address Line 11";
    protected String addressZip = "10113";

//    Shipping Address data
    protected String shippingAddressTitle = "Shipping Address";
    protected String paymentMethodsTitle = "Payment Method";

//    CreditCard info
    protected String visaTestCardNumber = "4005550000000019";
    protected String addCustomerPopupMessage = "The customer has been successfully created.";
    protected String saveSettingsPopupMessage = "Configuration has been saved successfully.";

//    Warehouse data
    public String warehouseName = "Test Warehouse_" + generateRandomData.generateRandomNumber(3);
    protected String warehouseContactName = "Test Warehouse Contact Name";
    protected String startPickupTime = "08:00";
    protected String endPickupTime = "21:00";

//    Bin data
    public String newBinName = "Test Warehouse Bin";
    protected String saveWarehousePopupMessage = "Save warehouse successfully";

//    Product data
    protected String prodNum = generateRandomData.generateRandomNumber(4);
    public String productSku = "ProductSKU_" + prodNum;
    protected String productName = "ProductName_" + prodNum;
    protected String productWeight = generateRandomData.generateRandomNumber(1);
    protected String productDescription = productSku + " Description";
    protected String productRetailPrice = generateRandomData.generateRandomNumber(3);
    protected String productSalesChannel = "Call Center";

//    Supplier data
    protected String supplierAccountNumber = generateRandomData.generateRandomNumber(5);
    protected String supplierName = "MySupplier_" + supplierAccountNumber;
    protected String supplierURL = generateRandomData.generateRandomNumber(5) + ".site.aa";
    protected String supplierAddress = "Lucky Street " + generateRandomData.generateRandomNumber(3);
    protected String supplierEmail = supplierName + "@dydacomp.biz";

//    Authorize credentials
    public String authApiLoginId = "3y8Z2fk5Z3n";
    public String authTransactionKey = "2s25qyDYe249uTRx";

//    UPS credentials
    protected String upsUserName = "Dev.api@dydacomp";
    protected String upsPassword = "7xy7mZBcXYEKw358gCKrDaqqeX";
    protected String upsLicenseNumber = "0C8701ECC4023070";
    protected String upsShipperNumber = "08611E";

//    USPS credentials
    protected String uspsAccountId = "2502974";
    protected String uspsPassPhrase = "EliManningHOF!1?";

//    create UPS Ground shipping method
    protected String upsGroundMethodName = "UPS Ground_" + generateRandomData.generateRandomNumber(2);
    protected String shippingMethodPrice = generateRandomData.generateRandomNumber(1);

    protected int timeoutVariable = 10;

    //    public boolean validCredentials = true;
    public static String totalResultMessage = "";

    @BeforeTest
    public void setUp(int envIndex, int browserIndex, WebDriver driver) {
        System.out.println("Run WebDriver");
        totalResultMessage += "Run WebDriver\n";
        driver.get(enviroment.get(envIndex));
        driver.manage().timeouts().implicitlyWait(timeoutVariable, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown(WebDriver driver) {
        System.out.println("Close WebDriver");
        totalResultMessage += "Close WebDriver";
        driver.close();
    }

    public static void log(String message) {
        Reporter.log(new Date().toString() + "\t" + message + "\n");
    }
}
