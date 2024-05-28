package pages;

import org.openqa.selenium.WebDriver;

import lazy.Lazy;
import lazy.LazyWebElement;

public class HomePage extends PageObject {

    private WebDriver driver;

    @Lazy(xpath = "//h1[contains(text(),'Example')]")
    private LazyWebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLoggedIn() {
        String expectedTitle = "Example Domain";
        return driver.getTitle().equals(expectedTitle) && welcomeMessage.getText().equals(expectedTitle);
    }
    
}
