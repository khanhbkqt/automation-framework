package pages;
import org.openqa.selenium.WebDriver;

import lazy.Lazy;
import lazy.LazyWebElement;

public class LoginPage extends PageObject {

    @Lazy(name = "username")
    LazyWebElement usernameField;
    
    @Lazy(name = "password")
    LazyWebElement passwordField;

    @Lazy(xpath = "//input[@type='submit' and @value='login']")
    LazyWebElement loginButton;

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
