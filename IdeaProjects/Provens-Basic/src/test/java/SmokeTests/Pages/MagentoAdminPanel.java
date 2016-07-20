package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.SimpleGUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private By magentonavBarLocator = By.xpath("//div[@id='message-popup-window']");


    public void adminPanelLogin () {
        totalResultMessage += "Open Magento admin panel\n";
        driver.get(magentoEnvironment.get(SimpleGUI.magentoIndex));

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(magentoLoginFieldLocator));

        driver.findElement(magentoLoginFieldLocator).sendKeys(magentoLogin);
        driver.findElement(magentoPasswordFieldLocator).sendKeys(magentoPassword);
        driver.findElement(magentoLoginButtonLocator).click();

        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("Login page was not loaded");
        wait2.until(ExpectedConditions.visibilityOfElementLocated(magentonavBarLocator));
    }
}
