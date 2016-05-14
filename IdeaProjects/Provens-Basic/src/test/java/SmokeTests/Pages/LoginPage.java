package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class LoginPage extends BrowserSettings{
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By emailInputLocator = By.xpath("//input[@name='UserName']");
    private By passwordInputLocator = By.xpath("//input[@name='UserPassword']");
    private By loginButtonLocator = By.xpath("//input[@value='Login']");
    private By siteLogoLocator = By.xpath("//img[@id='logoIcon']");
    private By msgBox = By.xpath("//div[@id='dydacomp_messagebox']");
    private By alreadyLoggedMsgBoxLocator = By.xpath("//div[@id='dydacomp_messagebox']/p");
    private By msgBoxOkButton = By.xpath("//div [@class='ui-dialog-buttonset']/button[1]");
    private By closeMsgBoxLocator = By.xpath("//span[@class='ui-icon ui-icon-closethick']");
    private By signInDropdown = By.xpath("//li[@id='SignIn']");
    private By logOutButton = By.xpath("//a[@href='/web/Home/Logout']");

    public void loginMerchant() {
        log("Login Merchant user to FS");
        WebElement login = driver.findElement(emailInputLocator);
        login.click();
        login.clear();
        login.sendKeys(merchantEmail);

        WebElement password = driver.findElement(passwordInputLocator);
        password.click();
        password.clear();
        password.sendKeys(merchantPassword);

        driver.findElement(loginButtonLocator).click();


//        if (driver.findElement(msgBox).isDisplayed()) {
//            System.out.println("Message box appears");
//            log("Message box appears");
//            String msgBoxText = driver.findElement(msgBox).getText();
//            if ("This user is already logged in. Do you want to log off the active session?".equals(msgBoxText)) driver.findElement(msgBoxOkButton).click();
//            else log("Unexpectedly message box");
//        }
//
//        System.out.println("close popup");
//        driver.findElement(closeMsgBoxLocator).click();
//        System.out.println("confirm popup");
//        driver.findElement(msgBoxOkButton).click();
//        System.out.println("close popup");
//        Assert.assertEquals(driver.findElement(siteLogoLocator).isDisplayed(), true, "Main page is not loaded");
    }

    public void logOutUser() {
        final Wait<WebDriver> wait1 = new WebDriverWait(driver, 5).withMessage("'Sign In' dropdown is not clickable for a long time");
        wait1.until(ExpectedConditions.elementToBeClickable(signInDropdown));
        driver.findElement(signInDropdown).click();
        driver.findElement(logOutButton).click();
    }
}
