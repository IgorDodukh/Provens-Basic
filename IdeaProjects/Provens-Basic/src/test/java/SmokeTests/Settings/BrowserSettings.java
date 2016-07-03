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

    private static GenerateRandomData generateRandomData = new GenerateRandomData();

    //    List of Environments
    public static ArrayList<String> enviroment = new ArrayList<String>(
            Arrays.asList("https://qa01.freestylecommerce.info/web/",
                    "https://qa03.freestylecommerce.info/web/",
                    "https://qa05.freestylecommerce.info/web/",
                    "https://my.freestylecommerce.com/web/"));

//    protected String userAlreadyLoggedMsg = "This user is already logged in. Do you want to log off the active session?";

//    Customer data
    public static String firstName = "FirstName_" + generateRandomData.generateRandomNumber(4);
    public static String lastName = "LastName_" + generateRandomData.generateRandomNumber(4);
    public static String customerEmail = firstName + "@dydacomp.biz";
    public static String phone = generateRandomData.generateRandomNumber(10);

//    Billing Address data
    public static String billingAddressTitle = "Billing Address";
    public static String addressFirstName = "TesterBillingFirstName";
    public static String addressLastName = "TesterBillingLastName";
    public static String addressLine1 = "Tester Billing Address Line 11";
    public static String addressZip = "10113";

//    Shipping Address data
    public static String shippingAddressTitle = "Shipping Address";
    public static String paymentMethodsTitle = "Payment Method";

//    CreditCard info
    public static String visaTestCardNumber = "4005550000000019";
    public static String addCustomerPopupMessage = "The customer has been successfully created.";
    public static String saveSupplierPopupMessage = "Supplier was created successfully.\n";
    public static String saveSettingsPopupMessage = "Configuration has been saved successfully.";

//    Warehouse data
    public static String warehouseName = "Test Warehouse_" + generateRandomData.generateRandomNumber(3);
    public static String warehouseContactName = "Test Warehouse Contact Name";
    public static String startPickupTime = "08:00";
    public static String endPickupTime = "21:00";

//    Bin data
    public static String newBinName = "Test Warehouse Bin";
    public static String saveWarehousePopupMessage = "Save warehouse successfully";

//    Product data
    public static String prodNum = generateRandomData.generateRandomNumber(4);
    public static String productSku = "ProductSKU " + prodNum;
    public static String productName = "ProductName " + prodNum;
    public static String productWeight = generateRandomData.generateRandomNumber(1);
    public static String productDescription = productSku + " Description";
    public static String productRetailPrice = generateRandomData.generateRandomNumber(3);
    public static String productSalesChannel = "Call Center";

//    Supplier data
    public static String supplierAccountNumber = generateRandomData.generateRandomNumber(5);
    public static String supplierName = "MySupplier_" + supplierAccountNumber;
    public static String supplierURL = generateRandomData.generateRandomNumber(5) + ".site.blabla";
    public static String supplierAddress = "Lucky Street " + generateRandomData.generateRandomNumber(3);
    public static String supplierEmail = supplierName + "@dydacomp.biz";

//    Bin Data
    public static String binName = productName + " Bin " + generateRandomData.generateRandomNumber(2);
    public static String binPriority = generateRandomData.generateRandomNumber(3);

    //    Inventory Data
    public static String inventoryLotNumber = generateRandomData.generateRandomNumber(5);
    public static String inventoryUnitCost = generateRandomData.generateRandomNumber(2);
    public static String inventoryQty = generateRandomData.generateRandomNumber(6);
    public static String inventoryNotes = "My Notes " + generateRandomData.generateRandomString(10);

    //    Authorize credentials
    public static String authApiLoginId = "3y8Z2fk5Z3n";
    public static String authTransactionKey = "2s25qyDYe249uTRx";

//    UPS credentials
    public static String upsUserName = "Dev.api@dydacomp";
    public static String upsPassword = "7xy7mZBcXYEKw358gCKrDaqqeX";
    public static String upsLicenseNumber = "0C8701ECC4023070";
    public static String upsShipperNumber = "08611E";

//    USPS credentials
    public static String uspsAccountId = "2502974";
    public static String uspsPassPhrase = "EliManningHOF!1?";

//    create UPS Ground shipping method
    public static String upsGroundMethodName = "UPS Ground-" + generateRandomData.generateRandomNumber(2);
    public static String shippingMethodPrice = generateRandomData.generateRandomNumber(1);

    public static int timeoutVariable = 10;

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
