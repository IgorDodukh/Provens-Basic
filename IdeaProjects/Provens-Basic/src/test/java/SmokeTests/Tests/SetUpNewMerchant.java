package SmokeTests.Tests;

import SmokeTests.Pages.*;
import SmokeTests.Settings.BrowserSettings;
import org.testng.annotations.Test;

/**
 * Created by igor on 27.05.16.
 */
public class SetUpNewMerchant extends BrowserSettings {

    @Test
    public void setupNewMerchant() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
//        mainPage.openSetUpPage();
//
//        SettingsPage settingsPage = new SettingsPage(driver);
//        settingsPage.setShipaheadSetting();
//
//        mainPage.openMainPage();
        mainPage.openThirdPartyConnectionsPage();

        ThirdPartyConnectionsPage thirdPartyConnectionsPage = new ThirdPartyConnectionsPage(driver);
        thirdPartyConnectionsPage.configureAuthorizeAccount(authApiLoginId, authTransactionKey);
        thirdPartyConnectionsPage.configureUPSAccount(upsUserName, upsPassword, upsLicenseNumber, upsShipperNumber);
        thirdPartyConnectionsPage.configureUSPSAccount(uspsAccountId, uspsPassPhrase);

        mainPage.openMainPage();
        mainPage.openShippingMethodsPage();

        ShippingMethodsPage shippingMethodsPage = new ShippingMethodsPage(driver);
        shippingMethodsPage.openShippingMethodCreatingForm();
        shippingMethodsPage.createUPSGroundShippingMethod(upsGroundMethodName, shippingMethodPrice);
    }
}
