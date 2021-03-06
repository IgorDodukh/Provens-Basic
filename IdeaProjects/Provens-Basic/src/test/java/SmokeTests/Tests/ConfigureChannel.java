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
    public void configureMagentoChannel(String email, String merchantPassword, WebDriver driver) throws InterruptedException {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.openSyncPage();

        SyncPage syncPage = new SyncPage(driver);
        syncPage.openChannel();
        syncPage.getChannelID();

        MagentoAdminPanel magentoAdminPanel = new MagentoAdminPanel(driver);
        magentoAdminPanel.adminPanelLogin();
        magentoAdminPanel.openSettingsPage();
        magentoAdminPanel.configureAdvancedExportSettings(email, merchantPassword);
        magentoAdminPanel.saveMagentoConfig();
        magentoAdminPanel.addFSChannelID();

    }

}
