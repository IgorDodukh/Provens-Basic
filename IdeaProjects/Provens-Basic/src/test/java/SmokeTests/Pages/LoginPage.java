package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private By msgBoxOkButton = By.xpath("//button[@autotest-id='btnOK']");
    private By closeMsgBoxLocator = By.xpath("//span[@class='ui-icon ui-icon-closethick']");
    private By signInDropdown = By.xpath("//li[@id='SignIn']");
    private By logOutButton = By.xpath("//a[@href='/web/Home/Logout']");
    private By wrongCredentialsLocator = By.xpath("//div[@id='LoginMessage']");

    private By siteLogoIconLocator = By.xpath("//img[@id='logoIcon']");


//    public String credentialsStatus = "";


    public void loginMerchant(String email, String pass) throws InterruptedException {
        totalResultMessage += "Login user to FS:\n";
        totalResultMessage += " - Enter Login\n";
        WebElement login = driver.findElement(emailInputLocator);
        login.clear();
        login.sendKeys(email);

        totalResultMessage += " - Enter Password\n";
        WebElement password = driver.findElement(passwordInputLocator);
        password.clear();
        password.sendKeys(pass);

        totalResultMessage += " - Click 'Login' button\n";
        driver.findElement(loginButtonLocator).click();

//        String title = driver.findElement(wrongCredentialsLocator).getText();
//        if (Objects.equals(title, "Incorrect Userame or Password.")){
//            System.out.println("Your credentials are not valid");
//            validCredentials = false;
////            tearDown(driver);
//        } else {
//            validCredentials = true;
//            System.out.println("Your credentials are valid");
//        }
//
//        if(validCredentials){
            Thread.sleep(1000);
            try {
                driver.findElement(msgBox);
                totalResultMessage += "'User is already logged' popup appears\n";
                driver.findElement(msgBoxOkButton).click();
                totalResultMessage += "'User is already logged' popup confirmed\n";
            } catch (NoSuchElementException e) {
                totalResultMessage += "User is logging now\n";
            }
//        }
//        credentialsStatus = String.valueOf(validCredentials);
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeoutVariable).withMessage("User was not loaded");
        wait.until(ExpectedConditions.elementToBeClickable(siteLogoIconLocator));

    }

    public void logOutUser() {
        final Wait<WebDriver> wait1 = new WebDriverWait(driver, timeoutVariable).withMessage("'Sign In' dropdown is not clickable for a long time");
        wait1.until(ExpectedConditions.elementToBeClickable(signInDropdown));
        driver.findElement(signInDropdown).click();
        driver.findElement(logOutButton).click();
    }
}
