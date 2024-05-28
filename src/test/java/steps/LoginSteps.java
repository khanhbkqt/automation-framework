package steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import config.WebDriverUtils;
import pages.HomePage;
import pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setup() {
        driver = WebDriverUtils.getDriver();
        loginPage = new LoginPage(driver);
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^User is on the login page$")
    public void userIsOnLoginPage() {
        loginPage.openLoginPage();
    }

    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("^User clicks on login button$")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("^User should be logged in successfully$")
    public void verifyLoginSuccess() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isLoggedIn(), "Login failed. The page title as not expected");
    }

    @Then("Error message is displayed")
    public void Error_message_is_displayed() {
        
    }

    @When("User left the username and password empty")
    public void enterEmptyLoginCredentials() {
        loginPage.enterUsername("");
        loginPage.enterPassword("");
    }
}
