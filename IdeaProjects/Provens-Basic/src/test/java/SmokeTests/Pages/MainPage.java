package SmokeTests.Pages;

import SmokeTests.Settings.BrowserSettings;
import org.openqa.selenium.WebDriver;

/**
 * Created by igor on 17.04.16.
 */
public class MainPage extends BrowserSettings {
    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


}
