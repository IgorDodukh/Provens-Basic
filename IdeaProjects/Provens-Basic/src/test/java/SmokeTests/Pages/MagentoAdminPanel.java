package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.ProgressBar;
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

    private By magentoConfigSaveButtonLocator = By.xpath("//div[@class='main-col-inner']//button[@class='scalable save']");

    private By magentoConfigUsernameFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_username']");
    private By magentoConfigPassFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_password']");
    private By magentoConfigAuthFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_authorization_url']");
    private By magentoConfigNotificationFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_api_api_service_url']");
    private By magentoConfigQueueServiceFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_queue_queue_service_url']");
    private By magentoChannelIDFieldLocator = By.xpath("//input[@id='freestyle_advancedexport_settings_chanel_id']");
    private By magentoWebSitesDropdownLocator = By.xpath("//div[@class='switcher']//select");

    public void adminPanelLogin() {
        totalResultMessage += "Open Magento admin panel\n";
        driver.get(magentoEnvironment.get(SimpleGUI.magentoIndex));
        ProgressBar.addProgressValue(progressVariable);

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoLoginFieldLocator));
        ProgressBar.addProgressValue(progressVariable);

        driver.findElement(magentoLoginFieldLocator).sendKeys(magentoLogin);
        driver.findElement(magentoPasswordFieldLocator).sendKeys(magentoPassword);
        driver.findElement(magentoLoginButtonLocator).click();
        ProgressBar.addProgressValue(progressVariable);

        try{
            final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
            wait2.until(ExpectedConditions.visibilityOfElementLocated(magentoPopupBoxLocator));
            driver.findElement(magentoPopupBoxCloseButtonLocator).click();
        }catch (NoSuchElementException e){
            System.out.println("Popup was not found");
        }
        ProgressBar.addProgressValue(progressVariable);
    }

    public void openSettingsPage() {
        totalResultMessage += "Open Magento settings page\n";
        String systemMenuItem;
        int systemItem = 0;

        totalResultMessage += "Click 'System' menu item\n";
        for (int i = 1; i <= 50; i++){
            By magentoMenuBarSystemButtonLocator = By.xpath("//div[@class='nav-bar']/ul/li[" + i + "]/a");
            systemMenuItem = driver.findElement(magentoMenuBarSystemButtonLocator).getText();
            if (Objects.equals(systemMenuItem, "System")) {
                driver.findElement(magentoMenuBarSystemButtonLocator).click();
                systemItem = i;
                break;
            }
        }
        ProgressBar.addProgressValue(progressVariable);

        String configurationMenuItem;
        totalResultMessage += "Click 'Configuration' menu item\n";

        for (int i = 1; i <= 50; i++){
            By magentoMenuBarConfigButtonLocator = By.xpath("//div[@class='nav-bar']/ul/li[" + systemItem + "]/ul/li[" + i + "]");
            configurationMenuItem = driver.findElement(magentoMenuBarConfigButtonLocator).getText();
            if (Objects.equals(configurationMenuItem, "Configuration")) {
                driver.findElement(magentoMenuBarConfigButtonLocator).click();
                break;
            }
        }
        try {
            final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
            wait.until(ExpectedConditions.elementToBeClickable(magentoLoginButtonLocator));
            driver.findElement(magentoLoginFieldLocator).sendKeys(magentoLogin);
            driver.findElement(magentoPasswordFieldLocator).sendKeys(magentoPassword);
            driver.findElement(magentoLoginButtonLocator).click();

        } catch (NoSuchElementException e) {
        }
        try{
            final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
            wait2.until(ExpectedConditions.visibilityOfElementLocated(magentoPopupBoxLocator));
            driver.findElement(magentoPopupBoxCloseButtonLocator).click();
        }catch (NoSuchElementException e){
            System.out.println("Popup was not found");
        }
        ProgressBar.addProgressValue(progressVariable);

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));


        String advancedExportMenuItem;
        totalResultMessage += "Open Advanced Export settings page\n";

        for (int i = 1; i <= 50; i++){
            By advancedExportMenuItemLocator = By.xpath("//ul[@id='system_config_tabs']/li[" + i + "]//dd[1]/a/span");
            advancedExportMenuItem = driver.findElement(advancedExportMenuItemLocator).getText();
            if (Objects.equals(advancedExportMenuItem, "Advanced Export")) {
                driver.findElement(advancedExportMenuItemLocator).click();
                break;
            }
        }
        ProgressBar.addProgressValue(progressVariable);

        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait2.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }

    public void configureAdvancedExportSettings (String login, String password) {
        String magentoAutenticationURL = magentoFSLink + "api/api/authentication";
        String magentoNotificationURL = magentoFSLink + "api/api/notification";
        String magentoQueueServiceURL = magentoFSLink + "api/Magento/CreateEntities";


        totalResultMessage += "Fill 'Username' field\n";
        driver.findElement(magentoConfigUsernameFieldLocator).clear();
        driver.findElement(magentoConfigUsernameFieldLocator).sendKeys(login);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Fill 'Password' field\n";
        driver.findElement(magentoConfigPassFieldLocator).clear();
        driver.findElement(magentoConfigPassFieldLocator).sendKeys(password);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Fill 'Authentication Service URL' field\n";
        driver.findElement(magentoConfigAuthFieldLocator).clear();
        driver.findElement(magentoConfigAuthFieldLocator).sendKeys(magentoAutenticationURL);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Fill 'Notification Service URL' field\n";
        driver.findElement(magentoConfigNotificationFieldLocator).clear();
        driver.findElement(magentoConfigNotificationFieldLocator).sendKeys(magentoNotificationURL);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Fill 'Queue Service URL' field\n";
        driver.findElement(magentoConfigQueueServiceFieldLocator).clear();
        driver.findElement(magentoConfigQueueServiceFieldLocator).sendKeys(magentoQueueServiceURL);
        ProgressBar.addProgressValue(progressVariable);
    }

    public void saveMagentoConfig() {
        totalResultMessage += "Click 'Save Config' button\n";
        driver.findElement(magentoConfigSaveButtonLocator).click();

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }

    public void addFSChannelID() {
        totalResultMessage += "Add FS Channel ID\n";
        totalResultMessage += "Open 'Main Website' setting page\n";

        driver.findElement(magentoWebSitesDropdownLocator).click();

        String dropdownValue;

        for (int i = 1; i <= 100; i++){
            By magentoWebSiteOptionLocator = By.xpath("//select[@id='store_switcher']/option[" + i + "]");
            dropdownValue = driver.findElement(magentoWebSiteOptionLocator).getText();
            if (Objects.equals(dropdownValue, "          Main Website      ")) {
                driver.findElement(magentoWebSiteOptionLocator).click();
                break;
            }
        }
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Change FS Channel ID\n";
        driver.findElement(magentoChannelIDFieldLocator).clear();
        driver.findElement(magentoChannelIDFieldLocator).sendKeys(magentoChannelID);
        ProgressBar.addProgressValue(progressVariable);

        totalResultMessage += "Save new Channel ID\n";
        driver.findElement(magentoConfigSaveButtonLocator).click();
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Config page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoConfigSaveButtonLocator));
        ProgressBar.addProgressValue(progressVariable);
    }
}
