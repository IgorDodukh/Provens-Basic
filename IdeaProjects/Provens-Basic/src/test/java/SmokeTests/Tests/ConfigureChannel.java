package SmokeTests.Tests;

import SmokeTests.Pages.*;
import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Ihor on 7/19/2016.
 */
public class ConfigureChannel extends BrowserSettings {
    @Test
    public void configureMagentoChannel(/*String email, String merchantPassword,*/ WebDriver driver) throws InterruptedException {

        MagentoAdminPanel magentoAdminPanel = new MagentoAdminPanel(driver);
        magentoAdminPanel.adminPanelLogin();

//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.loginMerchant(email, merchantPassword);
//
//        MainPage mainPage = new MainPage(driver);

    }

}
