package SmokeTests.Tests;

import SmokeTests.Pages.AddCustomerPage;
import SmokeTests.Pages.LoginPage;
import SmokeTests.Pages.MainPage;
import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by igor on 17.04.16.
 */
public class Jira3675_AddNewCustomerWithCreditCard extends BrowserSettings{

    @Test
    public void jira3675(String email, String merchantPassword, WebDriver driver) throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.openAddCustomerPage();
//        mainPage.openCustomersGrid();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

//        addCustomerPage.openAddCustomerPage();

        addCustomerPage.addCustomerInfo(firstName, lastName, customerEmail, phone);
        addCustomerPage.addBillingAddress(addressFirstName, addressLastName, addressLine1, addressZip);
        addCustomerPage.addShippingAddress();
        addCustomerPage.addCreditCard(visaTestCardNumber);
        addCustomerPage.saveNewCustomer();
        addCustomerPage.searchNewCustomerInTheGrid(firstName);
    }
}
