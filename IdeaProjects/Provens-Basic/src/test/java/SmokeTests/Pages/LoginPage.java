package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Created by igor on 17.04.16.
 */
public class LoginPage extends BrowserSettings{
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By emailInputLocator = By.xpath("//input[@name='UserName']");
    By passwordInputLocator = By.xpath("//input[@name='UserPassword']");
    By loginButtonLocator = By.xpath("//input[@value='Login']");
    By siteLogoLocator = By.xpath("//img[@id='logoIcon']");
//    By msgBox = By.xpath("//div[@id='dydacomp_messagebox']");
//    By alreadyLoggedMsgBoxLocator = By.xpath("//div[@id='dydacomp_messagebox']/p");
//    By msgBoxOkButton = By.xpath("//div [@class='ui-dialog-buttonset']/button");
//    By closeMsgBoxLocator = By.xpath("//span[@class='ui-icon ui-icon-closethick']");
    By signInDropdown = By.xpath("//li[@id='SignIn']");
    By logOutButton = By.xpath("//a[@href='/web/Home/Logout']");

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


/*        if (driver.findElement(msgBox).isDisplayed()) {
            log("Message box appears");
            String msgBoxText = driver.findElement(msgBox).getText();
            if (userAlreadyLoggedMsg == msgBoxText) driver.findElement(msgBoxOkButton).click();
            else log("Unexpectedly message box");
        }*/

//        System.out.println("close popup");
//        driver.findElement(closeMsgBoxLocator).click();
//        System.out.println("confirm popup");
//        driver.findElement(msgBoxOkButton).click();
//        System.out.println("close popup");
        Assert.assertEquals(driver.findElement(siteLogoLocator).isDisplayed(), true, "Main page is not loaded");
    }

    public void logOutUser() {
        driver.findElement(signInDropdown).click();
        driver.findElement(logOutButton).click();
    }
}
