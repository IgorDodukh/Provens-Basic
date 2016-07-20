package SmokeTests.UI;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.Tests.*;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ihor on 7/16/2016.
 */
public class DropdownValueDeterminer {
    private ConfigureMerchant configureMerchant = new ConfigureMerchant();
    private AddNewCustomer addNewCustomer = new AddNewCustomer();
    private AddProductWithInventory addProductWithInventory = new AddProductWithInventory();
    private AddWarehouseAndBin addWarehouseAndBin = new AddWarehouseAndBin();
    private CreateSupplier createSupplier = new CreateSupplier();
    private MakeReorder makeReorder = new MakeReorder();
    private ConfigureChannel configureChannel = new ConfigureChannel();


    public void entityTypeDropdown(int entityTypeComboBoxIndex, String login, String password, String testCardNumber, WebDriver driver) throws InterruptedException {
        SimpleGUI.resultMessage += "Oh boy, you are lucky.\n" + "Test has been finished.\n";
        if (entityTypeComboBoxIndex == 0) {
            BrowserSettings.progressVariable = 3;
            configureMerchant.setupNewMerchant(login, password, driver);
            SimpleGUI.resultMessage += "New Merchant '" + login + "' has been configured";
        } else if (entityTypeComboBoxIndex == 1) {
            BrowserSettings.progressVariable = 4;
            addNewCustomer.jira3675(login, password, testCardNumber, driver);
            SimpleGUI.resultMessage += "New Customer has been created\n";
            SimpleGUI.resultMessage += "\nCustomer name is:\n" + BrowserSettings.firstName + " " + BrowserSettings.lastName;

        } else if (entityTypeComboBoxIndex == 2) {
            BrowserSettings.progressVariable = 2;
            addProductWithInventory.jira3015(login, password, driver);
            SimpleGUI.resultMessage += "New Product has been created\n";
            SimpleGUI.resultMessage += "\nProduct SKU is: " + BrowserSettings.productSku;
            SimpleGUI.resultMessage += "\nProduct Bin name is: " + BrowserSettings.binName;
            SimpleGUI.resultMessage += "\nProduct qty is: " + BrowserSettings.inventoryQty;
        } else if (entityTypeComboBoxIndex == 4) {
            BrowserSettings.progressVariable = 5;
            addWarehouseAndBin.jira3006(login, password, driver);
            SimpleGUI.resultMessage += "New Warehouse and Bin have been created\n";
            SimpleGUI.resultMessage += "\nWarehouse name is: " + BrowserSettings.warehouseName;
            SimpleGUI.resultMessage += "\nBin name is: " + BrowserSettings.newBinName;
        } else if (entityTypeComboBoxIndex == 3) {
            BrowserSettings.progressVariable = 4;
            createSupplier.jira3012(login, password, driver);
            SimpleGUI.resultMessage += "New Supplier has been created\n";
            SimpleGUI.resultMessage += "\nSupplier name is: " + BrowserSettings.supplierName;
        } else if (entityTypeComboBoxIndex == 6) {
            makeReorder.makeReorder(login, password, driver);
            SimpleGUI.resultMessage += "New Order has been created\n";
            SimpleGUI.resultMessage += "\nOrder Number is: " + BrowserSettings.orderNumber;
        } else if (entityTypeComboBoxIndex == 5) {
            configureChannel.configureMagentoChannel(/*login, password,*/ driver);
            SimpleGUI.resultMessage += "\nMagento "+ SimpleGUI.magentoIndexName;
            SimpleGUI.resultMessage += "\nhas been synced with " + SimpleGUI.environmentsComboBox.getSelectedItem();
        }
    }
}
