package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Reporter.log;

/**
 * Created by igor on 21.04.16.
 */
public class AddProductPage extends BrowserSettings{
    private WebDriver driver;

    public AddProductPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productDetailsTabTitleLocator = By.xpath("//section[@class='tabContainer columns']/h2/strong");
    private By productSkuFieldLocator = By.xpath("//input[@name='productInfo_Sku']");
    private By productNameLocator = By.xpath("//input[@name='productInfo_Name']");
    private By productWeightLocator = By.xpath("//input[@name='productInfo_WeightLB']");
    private By productShortDescriptionLocator = By.xpath("//input[@name='productInfo_Desc']");

    private By productPricingTabLocator = By.xpath("//li[@id='pricingTab']");
    private By productPricingTabTitleLocator = By.xpath("//*[@id='pricingModule']//h4/strong");
    private By productRetailPriceLocator = By.xpath("//*[@id='retail-price']");

    private By salesChannelsTabTitleLocator = By.xpath("//*[@id='subTitle']/h2");
    private By productSalesChannelsTabLocator = By.xpath("//li[@id='salesChannelsTab']");
    private By salesChannelNameFieldLocator = By.xpath("//*[@id='control_autoCompleteSingle_1']");
    private By salesChannelTooltipLocator = By.xpath("//*[@id='ui-active-menuitem']");
    private By salesChannelAddButtonLocator = By.xpath("//*[@id='salesChannelsTable']//img[2]");

    private By suppliersTabTitleLocator = By.xpath("//*[@id='subTitle']/h2/strong");
    private By productSuppliersTabLocator = By.xpath("//li[@id='suppliersTab']");
    private By addSupplierButtonLocator = By.xpath("//*[@id='add_supplier']");
    private By addSupplierPopupLocator = By.xpath("//*[@id='dydacomp_messagebox']");
    private By selectSupplierCheckboxLocator = By.xpath("//input[@name='chxBox_supplier']");
    private By addSelectedSupplierButtonLocator = By.xpath("//*[@id='add_selected_supplier']");
    private By selectAddedSupplierLocator = By.xpath("//*[@id='SuppliersItemsTable']/tbody/tr");
    private By openAddedSupplierToEditButtonLocator = By.xpath("//*[@id='rowActions']/input[1]");
    private By warehouseTabLocator = By.xpath("//*[@id='li_Warehouse']");
    private By unitCostFieldLocator = By.xpath("//*[@id='txtPrice']");
    private By unitCostAddButtonLocator = By.xpath("//*[@id='add_item']");
    private By supplierSaveOkButton = By.xpath("//*[@id='btnOkButton1']");
    private By viewCostLinkLocator = By.xpath("//*[@id='SuppliersItemsTable']/tbody/tr/td[3]/a");
    private By saveAndCloseProductButtonLocator = By.xpath("//*[@id='btnSaveAndClose']/div[2]");

    private By productMessageBoxLocator = By.xpath("//*[@id='productMessageBox']");
    private By popupOkBtnLocator = By.xpath("//button[@class='primary-button']");
    private By filterProductsFieldLocator = By.xpath("//*[@id='searchProductResult_filter']/label/input");
    private By productSkuInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[2]");
    private By productNameInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[3]");
    private By productRetailPriceInTheGridLocator = By.xpath("((//*[@id='searchProductResult'])//tbody/tr/*)[4]");


    public void addProductInfo(String sku) {
        log("Add product info");
        log("Add product SKU");
        WebElement productSkuField = driver.findElement(productSkuFieldLocator);
        productSkuField.click();
        productSkuField.clear();
        productSkuField.sendKeys(sku);

    }
}
