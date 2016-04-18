package SmokeTests.Tests;

import SmokeTests.Pages.AddCustomerPage;
import SmokeTests.Pages.LoginPage;
import SmokeTests.Settings.BrowserSettings;
import org.testng.annotations.Test;

/**
 * Created by igor on 17.04.16.
 */
public class Jira3675_AddNewCustomerWithCreditCard extends BrowserSettings{

    @Test
    public void jira3675() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.openAddCustomerPage();
        addCustomerPage.addCustomerInfo();
        addCustomerPage.addBillingAddress();
        addCustomerPage.addShippingAddress();
        addCustomerPage.addCreditCard();
    }
}
