package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import SmokeTests.UI.SimpleGUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ihor on 7/20/2016.
 */
public class SyncPage extends BrowserSettings{
    private WebDriver driver;

    public SyncPage(WebDriver driver) {
        this.driver = driver;
    }

    private By syncFilterByFieldLocator = By.xpath("//div[@class='dataTables_filter']//input");
    private By syncChannelInGridLocator = By.xpath("//table/tbody//tr[1]");
    private By syncViewChannelButtonLocator = By.xpath("//table/tbody//tr[1]//input[@name='view_salesChannel']");
    private By channelOverviewTabLocator = By.xpath("//aside[@id='leftNav']//ul[1]/li/a");


    public void openChannel() {
        totalResultMessage += "Search needed Channel\n";

        String channelName = SimpleGUI.magentoIndexName.replace("qatestlab", "");
        driver.findElement(syncFilterByFieldLocator).sendKeys(channelName);
        driver.findElement(syncFilterByFieldLocator).sendKeys(Keys.ENTER);

        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("'Sync' page was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(syncFilterByFieldLocator));

        totalResultMessage += "Open found Channel\n";
        driver.findElement(syncChannelInGridLocator).click();
        driver.findElement(syncViewChannelButtonLocator).click();
        final Wait<WebDriver> wait2 = new WebDriverWait(driver, timeoutVariable).withMessage("'View Channel' page was not loaded");
        wait2.until(ExpectedConditions.elementToBeClickable(channelOverviewTabLocator));
    }


}
