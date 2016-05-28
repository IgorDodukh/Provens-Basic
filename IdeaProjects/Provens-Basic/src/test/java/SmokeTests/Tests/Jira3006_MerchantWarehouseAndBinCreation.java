package SmokeTests.Tests;

import SmokeTests.Pages.AddWarehousePage;
import SmokeTests.Pages.LoginPage;
import SmokeTests.Pages.MainPage;
import SmokeTests.Settings.BrowserSettings;
import org.testng.annotations.Test;

/**
 * Created by igor on 18.04.16.
 */
public class Jira3006_MerchantWarehouseAndBinCreation extends BrowserSettings {

    @Test
    public void jira3006() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginMerchant(email, merchantPassword);

        MainPage mainPage = new MainPage(driver);
        mainPage.openAddWarehousePage();

        AddWarehousePage addWarehousePage = new AddWarehousePage(driver);
        addWarehousePage.addWarehouseInfo(warehouseName, warehouseContactName, phone, startPickupTime, endPickupTime, addressLine1, addressZip);
        addWarehousePage.addWarehouseBin(newBinName);
        addWarehousePage.saveWarehouse();
    }
}
