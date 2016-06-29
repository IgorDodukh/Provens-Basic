package SmokeTests.Tests;

import SmokeTests.Pages.AddSupplierPage;
import SmokeTests.Pages.LoginPage;
import SmokeTests.Pages.MainPage;
import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 6/27/2016.
 */
public class Jira3012_CreateSupplier extends BrowserSettings {

    @Test
    public void jira3012(String email, String merchantPassword, WebDriver driver) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.openSuppliersPage();
        mainPage.openAddSupplierPage();

        AddSupplierPage addSupplierPage = new AddSupplierPage(driver);
        addSupplierPage.addSupplierContactInfo(supplierAccountNumber, supplierName, supplierURL, supplierAddress, addressZip, supplierEmail, firstName, lastName);
        addSupplierPage.saveSupplier();
    }
}
