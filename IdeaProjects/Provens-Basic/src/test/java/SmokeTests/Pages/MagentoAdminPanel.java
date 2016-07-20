package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.SimpleGUI;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

/**
 * Created by Ihor on 7/20/2016.
 */
public class MagentoAdminPanel extends BrowserSettings {
    private WebDriver driver;

    public MagentoAdminPanel(WebDriver driver) {
        this.driver = driver;
    }

    private By magentoLoginFieldLocator = By.xpath("//div[@class='login-box']//input[@id='username']");
    private By magentoPasswordFieldLocator = By.xpath("//div[@class='login-box']//input[@id='login']");
    private By magentoLoginButtonLocator = By.xpath("//div[@class='login-box']//input[@value='Login']");
    private By magentoPopupBoxLocator = By.xpath("//div[@id='message-popup-window']");
    private By magentoPopupBoxCloseButtonLocator = By.xpath("//div[@id='message-popup-window']//a/span");

    private By magentoMenuBarSystemButtonLocator = By.xpath("//div[@class='nav-bar']/ul/li[11]/a");
    private By magentoMenuBarConfigButtonLocator = By.xpath("//div[@class='nav-bar']/ul/li[11]/ul/li[19]");

    private By magentoConfigSaveButtonLocator = By.xpath("//div[@class='main-col-inner']//button[@class='scalable save']");
    private By magentoConfigAdvancedExportButtonLocator =
            By.xpath("//ul[@id='system_config_tabs']//a[@href='http://linux.mailordercentral.com/qatestlab06/index.php/admin/system_config/edit/section/freestyle_advancedexport/']");

    private By magentoConfigUsernameFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_username']");
    private By magentoConfigPassFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_password']");
    private By magentoConfigAuthFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_authorization_url']");
    private By magentoConfigNotificationFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_service_url']");
    private By magentoConfigQueueServiceFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_queue_queue_service_url']");
    private By magentoWebSitesDropdownLocator = By.xpath("//div[@class='switcher']//select");

    public void adminPanelLogin() {
        totalResultMessage += "Open Magento admin panel\n";
        driver.get(magentoEnvironment.get(SimpleGUI.magentoIndex));

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoLoginFieldLocator));

        driver.findElement(magentoLoginFieldLocator).sendKeys(magentoLogin);
        driver.findElement(magentoPasswordFieldLocator).sendKeys(magentoPassword);
        driver.findElement(magentoLoginButtonLocator).click();

        try{
            final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
            wait2.until(ExpectedConditions.visibilityOfElementLocated(magentoPopupBoxLocator));
            driver.findElement(magentoPopupBoxCloseButtonLocator).click();
        }catch (NoSuchElementException e){
            System.out.println("Popup was not found");
        }
    }

    public void openSettingsPage() {
        totalResultMessage += "Open Magento settings page\n";
        driver.findElement(magentoMenuBarSystemButtonLocator).click();
        driver.findElement(magentoMenuBarConfigButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));

        totalResultMessage += "Open Advanced Export settings page\n";
        driver.findElement(magentoConfigAdvancedExportButtonLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait2.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));
    }

    public void configureAdvancedExportSettings (String login, String password) {
        totalResultMessage += "Fill 'Username' field\n";
        driver.findElement(magentoConfigUsernameFieldLocator).clear();
        driver.findElement(magentoConfigUsernameFieldLocator).sendKeys(login);

        totalResultMessage += "Fill 'Password' field\n";
        driver.findElement(magentoConfigPassFieldLocator).clear();
        driver.findElement(magentoConfigPassFieldLocator).sendKeys(password);

        totalResultMessage += "Fill 'Authentication Service URL' field\n";
        driver.findElement(magentoConfigAuthFieldLocator).clear();
        driver.findElement(magentoConfigAuthFieldLocator).sendKeys(magentoAutenticationURL);

        totalResultMessage += "Fill 'Notification Service URL' field\n";
        driver.findElement(magentoConfigNotificationFieldLocator).clear();
        driver.findElement(magentoConfigNotificationFieldLocator).sendKeys(magentoNotificationURL);

        totalResultMessage += "Fill 'Queue Service URL' field\n";
        driver.findElement(magentoConfigQueueServiceFieldLocator).clear();
        driver.findElement(magentoConfigQueueServiceFieldLocator).sendKeys(magentoQueueServiceURL);
    }

    public void saveMagentoConfig() {
        totalResultMessage += "Click 'Save Config' button\n";
        driver.findElement(magentoConfigSaveButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));
    }

    public void addFSChannelID() {
        totalResultMessage += "Add FS Channel ID\n";
        totalResultMessage += "Open 'Main Website' setting page\n";

        driver.findElement(magentoWebSitesDropdownLocator).click();

        String dropdownValue;

        for (int i = 1; i <= 100; i++){
            By magentoWebSiteOptionLocator = By.xpath("//div[@class='switcher']//select/option[" + i + "]");
            dropdownValue = driver.findElement(magentoWebSiteOptionLocator).getText();
            if (Objects.equals(dropdownValue, "Main Website")) {
                driver.findElement(magentoWebSiteOptionLocator).click();
                break;
            }
        }
    }
}
