package SmokeTests.Tests;

import SmokeTests.Pages.AddProductPage;
import SmokeTests.Pages.LoginPage;
import SmokeTests.Pages.MainPage;
import SmokeTests.Settings.BrowserSettings;
import org.testng.annotations.Test;

/**
 * Created by igor on 21.04.16.
 */
public class Jira3015_CreateProductAndBin extends BrowserSettings{

    @Test
    public void jira3015() throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.openAddProductPage();

        AddProductPage addProductPage = new AddProductPage(driver);
        addProductPage.addProductInfo(productSku);

    }

}
