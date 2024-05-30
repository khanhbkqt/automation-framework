package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lazy.Lazy;

public class HomePage extends PageObject {

    private WebDriver driver;

    @Lazy
    @FindBy(xpath = "//h1[contains(text(),'Example')]")
    private WebElement welcomeMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isLoggedIn() {
        String expectedTitle = "Example Domain";
        return driver.getTitle().equals(expectedTitle) && welcomeMessage.getText().equals(expectedTitle);
    }
    
}
