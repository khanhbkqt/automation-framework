package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import lazy.Lazy;

public class LoginPage extends PageObject {

    @Lazy
    @FindBy(name = "username")
    WebElement usernameField;
    
    @Lazy
    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit' and @value='login']")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    
    public void clickLoginButton() {
        loginButton.click();
    }

    public void openLoginPage() {
        driver.get("https://www.stealmylogin.com/demo.html");
    }
}
